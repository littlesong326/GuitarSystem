package guitar.system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SQLiteJDBC {
	  public static Connection getConnection()
	  {
	    Connection conn = null;
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      conn = DriverManager.getConnection("jdbc:sqlite:GuitarSystem.db");
	    } catch ( Exception e ) {
	    	System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    
	    System.out.println("Opened database successfully");
	    return conn;
	  }
	}
