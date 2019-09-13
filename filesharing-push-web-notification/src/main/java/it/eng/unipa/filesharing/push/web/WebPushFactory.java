package it.eng.unipa.filesharing.push.web;

import it.eng.unipa.filesharing.push.PushFactory;
import it.eng.unipa.filesharing.push.web.dto.WebPushMessage;
import it.eng.unipa.filesharing.push.web.dto.WebPushSubscription;

public interface WebPushFactory extends PushFactory<WebPushSubscription, WebPushMessage, WebPushService, WebPushSubscriptionService>{

	
	
}
