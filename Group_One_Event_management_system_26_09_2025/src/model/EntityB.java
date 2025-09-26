package model;




	import java.sql.Timestamp;

	public class EntityB {
	    private int entityBID;
	    private String title;
	    private Timestamp date;
	    private String status;
	    private double value;
	    private String notes;
	    private int entityAID;

	    public EntityB() {}

	    public EntityB(int entityBID, String title, Timestamp date, String status, double value, String notes, int entityAID) {
	        this.entityBID = entityBID;
	        this.title = title;
	        this.date = date;
	        this.status = status;
	        this.value = value;
	        this.notes = notes;
	        this.entityAID = entityAID;
	    }

	    // Getters and Setters
	    public int getEntityBID() { return entityBID; }
	    public void setEntityBID(int entityBID) { this.entityBID = entityBID; }

	    public String getTitle() { return title; }
	    public void setTitle(String title) { this.title = title; }

	    public Timestamp getDate() { return date; }
	    public void setDate(Timestamp date) { this.date = date; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public double getValue() { return value; }
	    public void setValue(double value) { this.value = value; }

	    public String getNotes() { return notes; }
	    public void setNotes(String notes) { this.notes = notes; }

	    public int getEntityAID() { return entityAID; }
	    public void setEntityAID(int entityAID) { this.entityAID = entityAID; }

	    public String toString() {
	        return "EntityB{entityBID=" + entityBID + ", title='" + title + "', status='" + status + "', value=" + value + "}";
	    }
	}

