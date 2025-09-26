package util;


	import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

	public class DB {
	    private static Connection connection;
	    
	    public static Connection getConnection() {
	        try {
	            if (connection == null || connection.isClosed()) {
	                Properties props = new Properties();
	                props.load(new FileInputStream("database.properties"));
	                
	                String url = props.getProperty("db.url");
	                String username = props.getProperty("db.username");
	                String password = props.getProperty("db.password");
	                
	                connection = DriverManager.getConnection(url, username, password);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Database Connection Failed: " + e.getMessage(), 
	                "Connection Error", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    public static void closeConnection() {
	        try {
	            if (connection != null && !connection.isClosed()) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	

}
