package model;


	import java.sql.Timestamp;

	public class Userr1{
	    private int userID;
	    private String username;
	    private String passwordHash;
	    private String role;
	    private String email;
	    private Timestamp createdAt;

	    public Userr1() {}

	    public Userr() {
	        this.userID = userID;
	        this.username = username;
	        this.passwordHash = passwordHash;
	        this.role = role;
	        this.email = email;
	        this.createdAt = createdAt;
	    }

	    // Getters and Setters
	    public int getUserID() { return userID; }
	    public void setUserID(int userID) { this.userID = userID; }

	    public String getUsername() { return username; }
	    public void setUsername(String username) { this.username = username; }

	    public String getPasswordHash() { return passwordHash; }
	    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

	    public String getRole() { return role; }
	    public void setRole(String role) { this.role = role; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public Timestamp getCreatedAt() { return createdAt; }
	    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

	    @Override
	    public String toString() {
	        return "User{userID=" + userID + ", username='" + username + "', role='" + role + "', email='" + email + "'}";
	    }
	}

