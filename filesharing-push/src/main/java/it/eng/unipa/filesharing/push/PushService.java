package it.eng.unipa.filesharing.push;

import it.eng.unipa.filesharing.push.exception.NotificationException;

public interface PushService<M extends Message> {
	
	M notify(M message) throws NotificationException;
		

}
