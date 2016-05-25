package guitar.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SQLiteJDBC {
	  public static Connection main( String args[] )
	  {
	    Connection conn = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection("jdbc:sqlite:GuitarSystem.db");
	    } catch ( Exception e ) {
	      
	    }
	    return conn;
	  }
	}
