package it.eng.unipa.filesharing.service.exception;

public class UserRoleNotFoundException extends NotFoundException {
	
	public UserRoleNotFoundException(String email) {
		super("user role not found:"+email);
		// TODO Auto-generated constructor stub
	}

}
