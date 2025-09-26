package dao;



	import model.EntityD;
	import util.DatabaseConnection;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class EntityDDAO {
	    
	    public boolean createEntityD(EntityD entity) {
	        String sql = "INSERT INTO EntityD (ReferenceNo, Amount, Date, Method, Status, EntityBID) VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getReferenceNo());
	            pstmt.setDouble(2, entity.getAmount());
	            pstmt.setTimestamp(3, entity.getDate());
	            pstmt.setString(4, entity.getMethod());
	            pstmt.setString(5, entity.getStatus());
	            pstmt.setInt(6, entity.getEntityBID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error creating EntityD: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public List<EntityD> getAllEntities() {
	        List<EntityD> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityD ORDER BY Date DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                EntityD entity = new EntityD(
	                    rs.getInt("EntityDID"),
	                    rs.getString("ReferenceNo"),
	                    rs.getDouble("Amount"),
	                    rs.getTimestamp("Date"),
	                    rs.getString("Method"),
	                    rs.getString("Status"),
	                    rs.getInt("EntityBID")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityD list: " + e.getMessage());
	        }
	        return entities;
	    }
	}


