package it.eng.unipa.filesharing.push;

import java.util.Collection;

public interface SubscriptionService<S extends Subscription,M extends Message> {
	
	public void unsubscribe(S subscription);
	public void subscribe(S subscription);
	public Collection<S> listSubscriptionForMessage(M message);

}
