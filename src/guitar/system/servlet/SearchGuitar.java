package guitar.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Guitar;

import com.DaoImpl.InventoryImpl;

/**
 * Servlet implementation class nihao
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
		System.out.println("staring");	
		String type=request.getParameter("type");
		String builder=request.getParameter("builder");
		String backwood=request.getParameter("backwood");
		String topwood=request.getParameter("topwood");
		System.out.println(type);
		Guitar guitar=new Guitar();
		guitar.setType(type);
		guitar.setBuilder(builder);
		guitar.setTopwood(topwood);
		guitar.setBackwood(backwood);
		InventoryImpl inventoryImpl=new InventoryImpl();
		PrintWriter pw = response.getWriter();
		try {
			List<Guitar> matchreasult=inventoryImpl.searchGuitar(guitar);
			Iterator mt = matchreasult.iterator();
			response.setContentType("text/x-json");
			String j = "{\"rows\": [";
			while (mt.hasNext()) {
			Guitar guitar2=(Guitar) mt.next();
			System.out.println(guitar2.getType());
			j += "{";
			j += "\"type\": \"" + guitar2.getType() + "\",";
			j += "\"backwood\": \"" + guitar2.getBackwood() + "\",";
			j += "\"topwood\": \"" + guitar2.getTopwood() + "\",";
			j += "\"builder\": \"" + guitar2.getBuilder() + "\"";
			j += "}";
			j += ", ";
			}	
			if (j != "{\"rows\": [") {
				j = j.substring(0, j.length() - 2);
			}
			j += "]}";
			pw.print(j);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ending");	
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	
	}

}
