package util;


	import java.sql.*;
	import java.util.Properties;
	import java.io.InputStream;
	import java.io.FileInputStream;

	public class DatabaseConnection {
	    private static Connection connection = null;
	    private static Properties props = new Properties();

	    static {
	        try {
	            InputStream input = new FileInputStream("database.properties");
	            props.load(input);
	            
	            Class.forName(props.getProperty("db.driver"));
	            System.out.println("MySQL JDBC Driver Registered!");
	            
	        } catch (Exception e) {
	            System.out.println("Error loading database configuration: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	    public static Connection getConnection() {
	        try {
	            if (connection == null || connection.isClosed()) {
	                String url = props.getProperty("db.url");
	                String username = props.getProperty("db.username");
	                String password = props.getProperty("db.password");
	                
	                connection = DriverManager.getConnection(url, username, password);
	                System.out.println("Database connection established successfully!");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database connection failed: " + e.getMessage());
	            e.printStackTrace();
	        }
	        return connection;
	    }

	    public static void closeConnection() {
	        try {
	            if (connection != null && !connection.isClosed()) {
	                connection.close();
	                System.out.println("Database connection closed.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error closing connection: " + e.getMessage());
	        }
	    }
	    
	    public static void testConnection() {
	        try (Connection conn = getConnection()) {
	            if (conn != null && !conn.isClosed()) {
	                System.out.println(" Database connection test: SUCCESS");
	            }
	        } catch (SQLException e) {
	            System.out.println(" Database connection test: FAILED");
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	}

