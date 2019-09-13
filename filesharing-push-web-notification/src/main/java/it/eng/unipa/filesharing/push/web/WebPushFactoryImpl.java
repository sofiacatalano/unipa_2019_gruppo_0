package it.eng.unipa.filesharing.push.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.push.PushFactory;
import it.eng.unipa.filesharing.push.web.dto.WebPushMessage;
import it.eng.unipa.filesharing.push.web.dto.WebPushSubscription;

@Component
public class WebPushFactoryImpl implements WebPushFactory {
	
	@Autowired
	private WebPushService webPushService;
	
	@Autowired
	WebPushSubscriptionService webPushSubscriptionService;

	@Override
	public WebPushService createPushService() {
		return webPushService;
	}

	@Override
	public WebPushSubscriptionService createSubscriptionService() {
		return webPushSubscriptionService;
	}

	@Override
	public WebPushMessage createMessage() {
		return new WebPushMessage();
	}

	@Override
	public WebPushSubscription createSubscription() {
		// TODO Auto-generated method stub
		return null;
	}

}
