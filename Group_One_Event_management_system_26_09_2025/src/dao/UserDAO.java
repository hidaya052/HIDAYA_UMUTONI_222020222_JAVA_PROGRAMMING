package dao;

import gui.User;

import java.util.*;

import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

	public class UserDAO {
	    
	    public UserDAO(int int1, String string, String string2, String string3,
				String string4, Timestamp timestamp) {
	
		}

		public UserDAO() {
			// TODO Auto-generated constructor stub
		}

		public UserDAO() {
			// TODO Auto-generated constructor stub
		}

		public UserDAO() {
			// TODO Auto-generated constructor stub
		}

		public boolean createUser1(UserDAO user) {
	        String sql = "INSERT INTO User (Username, PasswordHash, Role, Email) VALUES (?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, user.getUsername());
	            pstmt.setString(2, user.getPasswordHash());
	            pstmt.setString(3, user.getRole());
	            pstmt.setString(4, user.getEmail());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            if (e.getErrorCode() == 1062) {
	                System.out.println("Error: Username or email already exists.");
	            } else {
	                System.out.println("Database error: " + e.getMessage());
	            }
	            return false;
	        }
	    }
	    
	    public UserDAO getUserById(int userID) {
	        String sql = "SELECT * FROM User WHERE UserID = ?";
	        UserDAO user = null;
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, userID);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                user = new UserDAO(
	                    rs.getInt("UserID"),
	                    rs.getString("Username"),
	                    rs.getString("PasswordHash"),
	                    rs.getString("Role"),
	                    rs.getString("Email"),
	                    rs.getTimestamp("CreatedAt")
	                );
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving user: " + e.getMessage());
	        }
	        return user;
	    }
	    
	    public List<UserDAO> getAllUsers1() {
	        List<UserDAO> users = new ArrayList<>();
	        String sql = "SELECT * FROM User ORDER BY CreatedAt DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                UserDAO user = new UserDAO(
	                    rs.getInt("UserID"),
	                    rs.getString("Username"),
	                    rs.getString("PasswordHash"),
	                    rs.getString("Role"),
	                    rs.getString("Email"),
	                    rs.getTimestamp("CreatedAt")
	                );
	                users.add(user);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving users: " + e.getMessage());
	        }
	        return users;
	    }
	    
	    public boolean updateUser(UserDAO user) {
	        String sql = "UPDATE User SET Username = ?, PasswordHash = ?, Role = ?, Email = ? WHERE UserID = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, user.getUsername());
	            pstmt.setString(2, user.getPasswordHash());
	            pstmt.setString(3, user.getRole());
	            pstmt.setString(4, user.getEmail());
	            pstmt.setInt(5, user.getUserID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            if (e.getErrorCode() == 1062) {
	                System.out.println("Error: Username or email already exists.");
	            } else {
	                System.out.println("Error updating user: " + e.getMessage());
	            }
	            return false;
	        }
	    }
	    
	    public int getUserID() {
			// TODO Auto-generated method stub
			return 0;
		}

		public String getEmail() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getRole() {
			// TODO Auto-generated method stub
			return null;
		}

		private String getPasswordHash() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean deleteUser(int userID) {
	        String sql = "DELETE FROM User WHERE UserID = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, userID);
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error deleting user: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public User authenticate(String username, String password) {
	        String sql = "SELECT * FROM User WHERE Username = ? AND PasswordHash = ?";
	        UserDAO user = null;
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, username);
	            pstmt.setString(2, "hashed_" + password);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Authentication error: " + e.getMessage());
	        }
	        return user;
	    }
	

	public boolean createUser(UserDAO user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<UserDAO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserID(int parseInt) {
		// TODO Auto-generated method stub
		
	}

}
