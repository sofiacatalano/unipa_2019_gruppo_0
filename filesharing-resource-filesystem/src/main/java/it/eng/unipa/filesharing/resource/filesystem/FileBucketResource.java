package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;

import it.eng.unipa.filesharing.resource.BucketResource;

class FileBucketResource extends AbstractContainerResource implements BucketResource {
	
	public FileBucketResource(File file) {
		super(null,file);
	}
	
	
	public boolean create() {
		if(!this.getFile().exists()) {
			return this.getFile().getAbsoluteFile().mkdirs();
		}
		throw new RuntimeException("bucket non esistente e impossible creare il bucket");
	}
	
	
	public boolean exist() {
		return this.getFile().exists();
	}
	
	
	@Override
	protected FileBucketResource getFileBucketResource() {
		return this;
	}


	
	

}
