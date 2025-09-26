package model;





	import java.sql.Timestamp;

	public class EntityD {
	    private int entityDID;
	    private String referenceNo;
	    private double amount;
	    private Timestamp date;
	    private String method;
	    private String status;
	    private int entityBID;

	    public EntityD() {}

	    public EntityD(int entityDID, String referenceNo, double amount, Timestamp date, String method, String status, int entityBID) {
	        this.entityDID = entityDID;
	        this.referenceNo = referenceNo;
	        this.amount = amount;
	        this.date = date;
	        this.method = method;
	        this.status = status;
	        this.entityBID = entityBID;
	    }

	    // Getters and Setters
	    public int getEntityDID() { return entityDID; }
	    public void setEntityDID(int entityDID) { this.entityDID = entityDID; }

	    public String getReferenceNo() { return referenceNo; }
	    public void setReferenceNo(String referenceNo) { this.referenceNo = referenceNo; }

	    public double getAmount() { return amount; }
	    public void setAmount(double amount) { this.amount = amount; }

	    public Timestamp getDate() { return date; }
	    public void setDate(Timestamp date) { this.date = date; }

	    public String getMethod() { return method; }
	    public void setMethod(String method) { this.method = method; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public int getEntityBID() { return entityBID; }
	    public void setEntityBID(int entityBID) { this.entityBID = entityBID; }

	    public String toString() {
	        return "EntityD{entityDID=" + entityDID + ", referenceNo='" + referenceNo + "', amount=" + amount + ", status='" + status + "'}";
	    }
	}


