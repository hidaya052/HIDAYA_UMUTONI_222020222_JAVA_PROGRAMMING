package dao;


	import model.EntityC;
	import util.DatabaseConnection;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class EntityCDAO {
	    
	    public boolean createEntityC(EntityC entity) {
	        String sql = "INSERT INTO EntityC (Name, Type, StartDate, EndDate, Status, EntityAID) VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getName());
	            pstmt.setString(2, entity.getType());
	            pstmt.setTimestamp(3, entity.getStartDate());
	            pstmt.setTimestamp(4, entity.getEndDate());
	            pstmt.setString(5, entity.getStatus());
	            pstmt.setInt(6, entity.getEntityAID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error creating EntityC: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public List<EntityC> getAllEntities() {
	        List<EntityC> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityC ORDER BY StartDate DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                EntityC entity = new EntityC(
	                    rs.getInt("EntityCID"),
	                    rs.getString("Name"),
	                    rs.getString("Type"),
	                    rs.getTimestamp("StartDate"),
	                    rs.getTimestamp("EndDate"),
	                    rs.getString("Status"),
	                    rs.getInt("EntityAID")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityC list: " + e.getMessage());
	        }
	        return entities;
	    }
	}



