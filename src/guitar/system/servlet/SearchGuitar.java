package guitar.system.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linlin.song.bigwork.entity.Customer;

/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String serialnumber = request.getParameter("serialnumber");
		String price = request.getParameter("price");
		String builder = request.getParameter("builder");
		String model = request.getParameter("model");
		String type = request.getParameter("type");
		String backwood = request.getParameter("backwood");
		String topwood = request.getParameter("topwood");
		  try {

	            Guitar guitar = new Guitar(serialnumber, 0, builder, model, type, backwood, topwood);
	            guitar.setbuilder(builder);
	            guitar.setmodel(model);
	            guitar.settype(type);
	            guitar.setbackwood(backwood);
	            guitar.settopwood(topwood);
	            this.search.save(guitar);
	            request.getRequestDispatcher("/WebContent/result.jsp").forward(request, response);
		  } catch (SQLException e) {
	            e.printStackTrace();
	            request.getRequestDispatcher("/WebContent/result.jsp").forward(request, response);
	}
	
}}
