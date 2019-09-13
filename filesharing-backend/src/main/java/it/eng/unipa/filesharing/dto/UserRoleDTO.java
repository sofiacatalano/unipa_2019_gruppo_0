package it.eng.unipa.filesharing.dto;

public class UserRoleDTO {
	
	public UserRoleDTO() {
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private String email;
	private String longName;
	private boolean admin;
	private boolean active;
	
	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", longName=" + longName + ", admin=" + admin + ", active="+active+"]";
	}
	
	
	
	
	
	
	
	
	
}
