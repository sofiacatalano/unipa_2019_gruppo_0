package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;

import it.eng.unipa.filesharing.resource.FolderResource;
import it.eng.unipa.filesharing.resource.Resource;

class FileFolderResource extends AbstractContainerResource implements FolderResource {
	
	public FileFolderResource(FileBucketResource fileBucketResource,File file) {
		super(fileBucketResource,file);
	}
	
	
	public boolean create() {
		if(!this.getFile().exists()) {
			return this.getFile().mkdirs();
		}
		throw new RuntimeException("bucket non esistente e impossible creare il bucket");
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
