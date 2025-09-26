package model;
}

	import java.sql.Timestamp;

	public class EntityA {
	    private int entityAID;
	    private String name;
	    private String description;
	    private String attribute1;
	    private String attribute2;
	    private Timestamp createdAt;

	    public EntityA() {}

	    public EntityA(int entityAID, String name, String description, String attribute1, String attribute2, Timestamp createdAt) {
	        this.entityAID = entityAID;
	        this.name = name;
	        this.description = description;
	        this.attribute1 = attribute1;
	        this.attribute2 = attribute2;
	        this.createdAt = createdAt;
	    }

	    // Getters and Setters
	    public int getEntityAID() { return entityAID; }
	    public void setEntityAID(int entityAID) { this.entityAID = entityAID; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public String getAttribute1() { return attribute1; }
	    public void setAttribute1(String attribute1) { this.attribute1 = attribute1; }

	    public String getAttribute2() { return attribute2; }
	    public void setAttribute2(String attribute2) { this.attribute2 = attribute2; }

	    public Timestamp getCreatedAt() { return createdAt; }
	    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

	    
	    public String toString() {
	        return "EntityA{entityAID=" + entityAID + ", name='" + name + "', description='" + description + "'}";
	    }
	}


