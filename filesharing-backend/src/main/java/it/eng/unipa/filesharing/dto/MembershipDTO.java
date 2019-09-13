package it.eng.unipa.filesharing.dto;

public class MembershipDTO {
	
	private String email;
	private boolean permissionCreate;
	private boolean permissionDelete;
	
	
	public MembershipDTO(String email,boolean permissionCreate,boolean permissionDelete) {
		this.email = email;
		this.permissionCreate = permissionCreate;
		this.permissionDelete = permissionDelete;
	}
	
	public MembershipDTO() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isPermissionCreate() {
		return permissionCreate;
	}
	public void setPermissionCreate(boolean permissionCreate) {
		this.permissionCreate = permissionCreate;
	}
	public boolean isPermissionDelete() {
		return permissionDelete;
	}
	public void setPermissionDelete(boolean permissionDelete) {
		this.permissionDelete = permissionDelete;
	}
	
	
	
	
}
