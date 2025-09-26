package util;


	


	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class DatabaseConfig {
	    // Database connection parameters
	    private static final String DB_URL = "jdbc:mysql://localhost:3306/event_management_system";
	    private static final String DB_USER = "root"; // Change if different
	    private static final String DB_PASSWORD = ""; // Change if you have a password
	    
	    static {
	        try {
	            // Load MySQL JDBC Driver
	            Class.forName("jdbc:mysql://localhost:3306/event_management_system");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("MySQL JDBC Driver not found!", e);
	        }
	    }
	    
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    }
	}
