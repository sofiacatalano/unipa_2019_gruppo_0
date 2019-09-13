package it.eng.unipa.filesharing.push;

public interface PushFactory<S extends Subscription,M extends Message,PS extends PushService<M>,SS extends SubscriptionService<S, M>> {
	
	PS createPushService();
	
	SS createSubscriptionService();
	
	M createMessage();
	
	S createSubscription();

}
