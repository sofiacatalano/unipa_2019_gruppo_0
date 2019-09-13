package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import it.eng.unipa.filesharing.resource.ChildResource;
import it.eng.unipa.filesharing.resource.ContainerResource;

abstract class AbstractContainerResource extends AbstractResource implements ContainerResource{

	public AbstractContainerResource(FileBucketResource fileBucketResource,File file) {
		super(fileBucketResource,file);
	}
	
	boolean create() {
		if(!this.getFile().exists()) {
			return this.getFile().mkdir();
		}
		throw new RuntimeException("bucket non esistente e impossible creare il bucket");
	}
	
	@Override
	public List<ChildResource> getChilds() {
		List<ChildResource> childResources = new ArrayList<>();
		for(File f : getFile().listFiles()) {
			childResources.add(evalChildResource(f));
		}
		return childResources;
	}

	@Override
	public boolean isLeaf() {
		return getChilds().isEmpty();
	}
	
}
