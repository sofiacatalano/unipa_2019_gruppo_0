package it.eng.unipa.filesharing.push.web;

import org.springframework.stereotype.Service;

import it.eng.unipa.filesharing.push.web.dto.WebPushMessage;
import it.eng.unipa.filesharing.push.web.dto.WebPushSubscription;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Service
public class WebPushSubscriptionServiceImpl implements WebPushSubscriptionService {
	
	Logger LOGGER = Logger.getLogger(WebPushSubscriptionService.class.getCanonicalName());
	
	
	private Map<String, WebPushSubscription> subscriptions = new ConcurrentHashMap<>();

	@Override
	public void unsubscribe(WebPushSubscription subscription) {
		subscriptions.remove(subscription.getNotificationEndPoint());		
		LOGGER.info("UNSUBSCRIBED: " + subscription.getNotificationEndPoint());		
	}

	@Override
	public void subscribe(WebPushSubscription subscription) {
		subscriptions.put(subscription.getNotificationEndPoint(), subscription);		
		LOGGER.info("SUBSCRIBED: " + subscription.getNotificationEndPoint());
	}

	@Override
	public Collection<WebPushSubscription> listSubscriptionForMessage(WebPushMessage message) {
		return subscriptions.values();
	}
	
	

}
