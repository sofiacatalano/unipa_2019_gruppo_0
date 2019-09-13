package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;

import it.eng.unipa.filesharing.resource.ChildResource;
import it.eng.unipa.filesharing.resource.Resource;

abstract class AbstractChildResource extends AbstractResource implements ChildResource{
	
	public AbstractChildResource(FileBucketResource bucketResource,File file) {
		super(bucketResource,file);
	}

	@Override
	public Resource getParent() {
		if(this.getFile().getParentFile().equals(getFileBucketResource().getFile())){
			return this.getFileBucketResource();
		}else {
			return evalChildResource(this.getFile().getParentFile());
		}
	}
	
	

}
