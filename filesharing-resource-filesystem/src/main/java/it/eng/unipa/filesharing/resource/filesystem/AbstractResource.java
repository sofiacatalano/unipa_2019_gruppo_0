package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.FileSystemUtils;

import it.eng.unipa.filesharing.resource.ChildResource;
import it.eng.unipa.filesharing.resource.Resource;

abstract class AbstractResource implements Resource{

	private FileBucketResource fileBucketResource;
	private File file;

	public AbstractResource(FileBucketResource fileBucketResource, File file) {
		this.fileBucketResource=fileBucketResource;
		this.file = file;
	}

	@Override
	public String getUniqueKey() {
		return UniqueKeyUtils.unique(file);
	}

	@Override
	public String getName() {
		return file.getName();
	}
	
	protected ChildResource evalChildResource(File f) {
		return UniqueKeyUtils.evalChildResource(this.getFileBucketResource(), f);
	}

	protected File getFile() {
		return this.file;
	}
	
	boolean delete(boolean recursive) {
		return recursive ? FileSystemUtils.deleteRecursively(this.getFile()) : this.getFile().delete();
	}
	
	protected FileBucketResource getFileBucketResource() {
		return fileBucketResource;
	}

}