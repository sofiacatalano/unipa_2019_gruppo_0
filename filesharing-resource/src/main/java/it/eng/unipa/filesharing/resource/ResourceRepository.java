package it.eng.unipa.filesharing.resource;

import java.util.List;
import java.util.UUID;

public interface ResourceRepository {
	
	public List<BucketResource> list(UUID team);
	
	public Resource read(BucketResource bucket,String uniqueKey);
	
	public BucketResource createBucket(UUID team,String name);
	
	public boolean deleteBucket(UUID team,String name);
	
	public BucketResource loadBucket(UUID team,String name);
	
	public FolderResource createFolder(Resource parent,String name);
	
	public ContentResource createContent(Resource parent,String name,byte[] content);
	
	public boolean deleteResource(Resource delete,boolean recursive);
	
}
