package guitar.system.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataConnection {
	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static Connection conn;
public static  Connection getConnection() {
	try {
		Class.forName(DBDRIVER);
		try {
			//配置了系统路径？？？？？�?
			conn = DriverManager.getConnection("jdbc:sqlite://e:/test.db"); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return conn;

}
	
	public void close() throws Exception {
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
	

	
	
	
	
	

