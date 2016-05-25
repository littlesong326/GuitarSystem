package guitar.system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import guitar.system.servlet.Guitar;
import guitar.system.dao.SQLiteJDBC;
public class GuitarDao {
	 public List<Guitar> list(int pageNum, int offset, String name) throws SQLException {
	        Connection conn = null;
	        PreparedStatement ps = null;
	        ResultSet resultSet = null;
	        List<Guitar> result = new ArrayList<>();
	        try{
	            conn = SQLiteJDBC.getConnection();
	            String sql="select p.id, p.name, p.price, p.quantity, p.description, c.name "
	                    + "from product p left join product_category c on (p.product_category_id = c.id)";
	            if(name != null && !name.isEmpty()) {
	                name = "%" + name + "%";
	                sql +=  "where p.name like ? ";
	                sql += " limit ? offset ?";
	                ps=conn.prepareStatement(sql);
	                ps.setString(1, name);
	                ps.setInt(2, pageNum);
	                ps.setInt(3, offset);
	            } else {
	                sql += " limit ? offset ?";
	                ps=conn.prepareStatement(sql);
	                ps.setInt(1, pageNum);
	                ps.setInt(2, offset);
	            }
	            resultSet = ps.executeQuery();
	            while(resultSet.next()) {
	                Product product = new Product();
	                product.setId(resultSet.getLong(1));
	                product.setName(resultSet.getString(2));
	                product.setPrice(resultSet.getFloat(3));
	                product.setQuantity(resultSet.getLong(4));
	                product.setDescription(resultSet.getString(5));
	                ProductCategory pc = new ProductCategory();
	                pc.setName(resultSet.getString(6));
	                product.setProductCategory(pc);
	                result.add(product);
	            }
	        } finally {
	            if(resultSet != null) resultSet.close();
	            if(ps != null) ps.close();
	            if(conn != null) conn.close();
	        }
	        return result;
	    }
}
