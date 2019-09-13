package it.eng.unipa.filesharing.resource;

import java.util.List;

public interface ContentResource extends ChildResource{
	
	public byte[] getContent();
	
	@Override
	default boolean isType(TYPE type) {
		return ChildResource.super.isType(type) || type==TYPE.CONTENT;
	}
	
	default List<ChildResource> getChilds() {
		return null;
	}
	
	default boolean isLeaf() {
		return true;
	}

}
