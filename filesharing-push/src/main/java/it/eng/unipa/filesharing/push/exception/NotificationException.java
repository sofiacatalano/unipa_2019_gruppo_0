package it.eng.unipa.filesharing.push.exception;

public class NotificationException extends Exception {

	public NotificationException(Exception e) {
		super(e);
	}
	
	public NotificationException(String s) {
		super(s);
	}
	
	public NotificationException() {
		// TODO Auto-generated constructor stub
	}

}
