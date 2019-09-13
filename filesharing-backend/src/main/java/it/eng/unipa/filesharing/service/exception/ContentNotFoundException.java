package it.eng.unipa.filesharing.service.exception;

import java.util.UUID;

public class ContentNotFoundException extends NotFoundException {
	
	public ContentNotFoundException(String uniqueKey) {
		super("Impossibile trovare un content con uniqueKey:"+uniqueKey);
		// TODO Auto-generated constructor stub
	}

}
