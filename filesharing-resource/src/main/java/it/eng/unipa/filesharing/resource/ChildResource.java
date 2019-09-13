package it.eng.unipa.filesharing.resource;

public interface ChildResource extends Resource{
	
	public Resource getParent();
	
	@Override
	default boolean isType(TYPE type) {
		return type==TYPE.CHILD;
	}
	

}
