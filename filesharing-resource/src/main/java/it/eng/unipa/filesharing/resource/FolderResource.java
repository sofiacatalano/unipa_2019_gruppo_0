package it.eng.unipa.filesharing.resource;

public interface FolderResource extends ChildResource,ContainerResource{

	@Override
	default boolean isType(TYPE type) {
		return ChildResource.super.isType(type) || ContainerResource.super.isType(type) || type == TYPE.FOLDER;
	}

}
