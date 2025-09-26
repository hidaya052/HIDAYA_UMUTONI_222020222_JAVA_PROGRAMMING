package model;







	import java.sql.Timestamp;

	public class EntityC {
	    private int entityCID;
	    private String name;
	    private String type;
	    private Timestamp startDate;
	    private Timestamp endDate;
	    private String status;
	    private int entityAID;

	    public EntityC() {}

	    public EntityC(int entityCID, String name, String type, Timestamp startDate, Timestamp endDate, String status, int entityAID) {
	        this.entityCID = entityCID;
	        this.name = name;
	        this.type = type;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.status = status;
	        this.entityAID = entityAID;
	    }

	    // Getters and Setters
	    public int getEntityCID() { return entityCID; }
	    public void setEntityCID(int entityCID) { this.entityCID = entityCID; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getType() { return type; }
	    public void setType(String type) { this.type = type; }

	    public Timestamp getStartDate() { return startDate; }
	    public void setStartDate(Timestamp startDate) { this.startDate = startDate; }

	    public Timestamp getEndDate() { return endDate; }
	    public void setEndDate(Timestamp endDate) { this.endDate = endDate; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public int getEntityAID() { return entityAID; }
	    public void setEntityAID(int entityAID) { this.entityAID = entityAID; }

	    public String toString() {
	        return "EntityC{entityCID=" + entityCID + ", name='" + name + "', type='" + type + "', status='" + status + "'}";
	    }
	}
