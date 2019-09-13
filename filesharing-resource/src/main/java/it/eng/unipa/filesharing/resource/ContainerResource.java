package it.eng.unipa.filesharing.resource;

import java.util.List;

public interface ContainerResource extends Resource{
	
	@Override
	default boolean isType(TYPE type) {
		return type == TYPE.CONTAINER;
	}
	
	
	public List<ChildResource> getChilds();
	

}
