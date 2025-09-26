package dao;



	import model.EntityA;
	import util.DatabaseConnection;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class EntityADAO {
	    
	    public boolean createEntityA(EntityA entity) {
	        String sql = "INSERT INTO EntityA (Name, Description, Attribute1, Attribute2) VALUES (?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getName());
	            pstmt.setString(2, entity.getDescription());
	            pstmt.setString(3, entity.getAttribute1());
	            pstmt.setString(4, entity.getAttribute2());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error creating EntityA: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public EntityA getEntityAById(int entityAID) {
	        String sql = "SELECT * FROM EntityA WHERE EntityAID = ?";
	        EntityA entity = null;
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, entityAID);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                entity = new EntityA(
	                    rs.getInt("EntityAID"),
	                    rs.getString("Name"),
	                    rs.getString("Description"),
	                    rs.getString("Attribute1"),
	                    rs.getString("Attribute2"),
	                    rs.getTimestamp("CreatedAt")
	                );
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityA: " + e.getMessage());
	        }
	        return entity;
	    }
	    
	    public List<EntityA> getAllEntities() {
	        List<EntityA> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityA ORDER BY CreatedAt DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                EntityA entity = new EntityA(
	                    rs.getInt("EntityAID"),
	                    rs.getString("Name"),
	                    rs.getString("Description"),
	                    rs.getString("Attribute1"),
	                    rs.getString("Attribute2"),
	                    rs.getTimestamp("CreatedAt")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityA list: " + e.getMessage());
	        }
	        return entities;
	    }
	    
	    public boolean updateEntityA(EntityA entity) {
	        String sql = "UPDATE EntityA SET Name = ?, Description = ?, Attribute1 = ?, Attribute2 = ? WHERE EntityAID = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getName());
	            pstmt.setString(2, entity.getDescription());
	            pstmt.setString(3, entity.getAttribute1());
	            pstmt.setString(4, entity.getAttribute2());
	            pstmt.setInt(5, entity.getEntityAID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error updating EntityA: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public boolean deleteEntityA(int entityAID) {
	        String sql = "DELETE FROM EntityA WHERE EntityAID = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, entityAID);
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error deleting EntityA: " + e.getMessage());
	            return false;
	        }
	    }
	}


