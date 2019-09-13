package it.eng.unipa.filesharing.push.web;

import java.util.Collection;

import it.eng.unipa.filesharing.push.SubscriptionService;
import it.eng.unipa.filesharing.push.web.dto.WebPushMessage;
import it.eng.unipa.filesharing.push.web.dto.WebPushSubscription;

public interface WebPushSubscriptionService extends SubscriptionService<WebPushSubscription, WebPushMessage>{
	
	public void unsubscribe(WebPushSubscription subscription);
	public void subscribe(WebPushSubscription subscription);
	public Collection<WebPushSubscription> listSubscriptionForMessage(WebPushMessage message);

}
