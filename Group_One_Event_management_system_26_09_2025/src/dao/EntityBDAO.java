package dao;



	import model.EntityB;
	import util.DatabaseConnection;
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;

	public class EntityBDAO {
	    
	    public boolean createEntityB(EntityB entity) {
	        String sql = "INSERT INTO EntityB (Title, Date, Status, Value, Notes, EntityAID) VALUES (?, ?, ?, ?, ?, ?)";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setString(1, entity.getTitle());
	            pstmt.setTimestamp(2, entity.getDate());
	            pstmt.setString(3, entity.getStatus());
	            pstmt.setDouble(4, entity.getValue());
	            pstmt.setString(5, entity.getNotes());
	            pstmt.setInt(6, entity.getEntityAID());
	            
	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	            
	        } catch (SQLException e) {
	            System.out.println("Error creating EntityB: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public EntityB getEntityBById(int entityBID) {
	        String sql = "SELECT * FROM EntityB WHERE EntityBID = ?";
	        EntityB entity = null;
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, entityBID);
	            ResultSet rs = pstmt.executeQuery();
	            
	            if (rs.next()) {
	                entity = new EntityB(
	                    rs.getInt("EntityBID"),
	                    rs.getString("Title"),
	                    rs.getTimestamp("Date"),
	                    rs.getString("Status"),
	                    rs.getDouble("Value"),
	                    rs.getString("Notes"),
	                    rs.getInt("EntityAID")
	                );
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityB: " + e.getMessage());
	        }
	        return entity;
	    }
	    
	    public List<EntityB> getAllEntities() {
	        List<EntityB> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityB ORDER BY Date DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {
	            
	            while (rs.next()) {
	                EntityB entity = new EntityB(
	                    rs.getInt("EntityBID"),
	                    rs.getString("Title"),
	                    rs.getTimestamp("Date"),
	                    rs.getString("Status"),
	                    rs.getDouble("Value"),
	                    rs.getString("Notes"),
	                    rs.getInt("EntityAID")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityB list: " + e.getMessage());
	        }
	        return entities;
	    }
	    
	    public List<EntityB> getEntitiesByEntityA(int entityAID) {
	        List<EntityB> entities = new ArrayList<>();
	        String sql = "SELECT * FROM EntityB WHERE EntityAID = ? ORDER BY Date DESC";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            
	            pstmt.setInt(1, entityAID);
	            ResultSet rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	                EntityB entity = new EntityB(
	                    rs.getInt("EntityBID"),
	                    rs.getString("Title"),
	                    rs.getTimestamp("Date"),
	                    rs.getString("Status"),
	                    rs.getDouble("Value"),
	                    rs.getString("Notes"),
	                    rs.getInt("EntityAID")
	                );
	                entities.add(entity);
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Error retrieving EntityB by EntityA: " + e.getMessage());
	        }
	        return entities;
	    }
	}
