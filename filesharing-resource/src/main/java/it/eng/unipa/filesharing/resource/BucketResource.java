package it.eng.unipa.filesharing.resource;

public interface BucketResource extends ContainerResource{
	
	@Override
	default boolean isType(TYPE type) {
		return ContainerResource.super.isType(type) || type==TYPE.BUCKET;
	}
	

	
	
	
	
}
