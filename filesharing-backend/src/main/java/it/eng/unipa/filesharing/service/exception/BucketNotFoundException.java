package it.eng.unipa.filesharing.service.exception;

import java.util.UUID;

public class BucketNotFoundException extends NotFoundException {
	
	public BucketNotFoundException(UUID uuid,String bucketName) {
		super("Impossibile recuperare il bucket con UUID:"+uuid+" name:"+bucketName);
		// TODO Auto-generated constructor stub
	}

}
