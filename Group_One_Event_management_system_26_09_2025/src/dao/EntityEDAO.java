package dao;


	import model.EntityE;
	import util.DatabaseConnection;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class EntityEDAO {
	    
	    public boolean createEntityE(EntityE entity) {
	        String sql = "INSERT INTO EntityE (Category, Detail, Owner, Location, EntityCID) VALUES (?, ?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getCategory());
	            pstmt.setString(2, entity.getDetail());
	            pstmt.setString(3, entity.getOwner());
	            pstmt.setString(4, entity.getLocation());
	            pstmt.setInt(5, entity.getEntityCID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error creating EntityE: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public List<EntityE> getAllEntities() {
	        List<EntityE> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityE ORDER BY CreatedAt DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                EntityE entity = new EntityE(
	                    rs.getInt("EntityEID"),
	                    rs.getString("Category"),
	                    rs.getString("Detail"),
	                    rs.getString("Owner"),
	                    rs.getString("Location"),
	                    rs.getTimestamp("CreatedAt"),
	                    rs.getInt("EntityCID")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityE list: " + e.getMessage());
	        }
	        return entities;
	    }
	}

