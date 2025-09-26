package model;




	import java.sql.Timestamp;
	
	
	

	public class EntityE {
	    private int entityEID;
	    private String category;
	    private String detail;
	    private String owner;
	    private String location;
	    private Timestamp createdAt;
	    private int entityCID;

	    public EntityE() {}

	    public EntityE(int entityEID, String category, String detail, String owner, String location, Timestamp createdAt, int entityCID) {
	        this.entityEID = entityEID;
	        this.category = category;
	        this.detail = detail;
	        this.owner = owner;
	        this.location = location;
	        this.createdAt = createdAt;
	        this.entityCID = entityCID;
	    }

	    // Getters and Setters
	    public int getEntityEID() { return entityEID; }
	    public void setEntityEID(int entityEID) { this.entityEID = entityEID; }

	    public String getCategory() { return category; }
	    public void setCategory(String category) { this.category = category; }

	    public String getDetail() { return detail; }
	    public void setDetail(String detail) { this.detail = detail; }

	    public String getOwner() { return owner; }
	    public void setOwner(String owner) { this.owner = owner; }

	    public String getLocation() { return location; }
	    public void setLocation(String location) { this.location = location; }

	    public Timestamp getCreatedAt() { return createdAt; }
	    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

	    public int getEntityCID() { return entityCID; }
	    public void setEntityCID(int entityCID) { this.entityCID = entityCID; }

	    public String toString() {
	        return "EntityE{entityEID=" + entityEID + ", category='" + category + "', owner='" + owner + "', location='" + location + "'}";
	    }
	}


