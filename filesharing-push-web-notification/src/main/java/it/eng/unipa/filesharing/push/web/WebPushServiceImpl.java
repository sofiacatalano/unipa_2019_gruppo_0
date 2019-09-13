package it.eng.unipa.filesharing.push.web;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.eng.unipa.filesharing.push.exception.NotificationException;
import it.eng.unipa.filesharing.push.web.dto.WebPushMessage;
import it.eng.unipa.filesharing.push.web.dto.WebPushSubscription;
import nl.martijndwars.webpush.Notification;

@Service
public class WebPushServiceImpl implements WebPushService{
	
	Logger LOGGER = Logger.getLogger(WebPushServiceImpl.class.getCanonicalName());
	
	
	@Value("${it.eng.webpush.pushservice.publickey:BBYCxwATP2vVgw7mMPHJfT6bZrJP2iUV7OP_oxHzEcNFenrX66D8G34CdEmVULNg4WJXfjkeyT0AT9LwavpN8M4=}")
	String publicKey;

	@Value("${it.eng.webpush.pushservice.privatekey:AKYLHgp-aV3kOys9Oy6QgxNI6OGIlOB3G6kjGvhl57j_}")
	String privateKey;
	
	private static nl.martijndwars.webpush.PushService pushService = new nl.martijndwars.webpush.PushService();
	
	
	@Autowired
	private WebPushSubscriptionService subscriptionService;
	
	@PostConstruct
	public void init() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		pushService.setPublicKey(publicKey);
		pushService.setPrivateKey(privateKey);		
	}



	@Override
	public WebPushMessage notify(WebPushMessage message) throws NotificationException {
		try {
		String messageString = message.toBody();
		LOGGER.info("SENDING MESSAGE: " + messageString);
		
		for (WebPushSubscription subscription: subscriptionService.listSubscriptionForMessage(message)) {
			LOGGER.info("START SENDING TO: " + subscription.getNotificationEndPoint());
			
			Notification notification = new Notification(
						subscription.getNotificationEndPoint(),
						subscription.getPublicKey(),
						subscription.getAuth(),
						messageString);
			
			HttpResponse send;
				send = pushService.send(notification);
			
			LOGGER.info("END SENDING TO: " + subscription.getNotificationEndPoint() + " --> " + send.getStatusLine().getStatusCode());
		}
		} catch (Exception e) {
			throw new NotificationException(e);
		}
		
		return message;		
		
	}
	

}
