package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import it.eng.unipa.filesharing.resource.BucketResource;
import it.eng.unipa.filesharing.resource.ContentResource;
import it.eng.unipa.filesharing.resource.FolderResource;
import it.eng.unipa.filesharing.resource.Resource;
import it.eng.unipa.filesharing.resource.ResourceRepository;

public class FileSystemResourceRepository implements ResourceRepository {
	
	private File basePath;
	
	
	public FileSystemResourceRepository(File basePath) {
		this.basePath = basePath;
	}

	@Override
	public List<BucketResource> list(UUID team) {
		File teamFolder = new File(basePath,team.toString());
		File[] bucketFile = teamFolder.listFiles();
		List<BucketResource> bucketResources = new ArrayList<>(); 
		for(File file : bucketFile) {
			bucketResources.add(new FileBucketResource(file));
		}
		return bucketResources;
		/*
		return Arrays.asList(new File(basePath,team.toString()).listFiles()).stream().map((file)->new FileBucketResource(file)).collect(Collectors.toList());
		*/
	}

	@Override
	public Resource read(BucketResource bucketResource,String uniqueKey) {
		File resolve = UniqueKeyUtils.resolve(basePath,uniqueKey);
		if(bucketResource instanceof FileBucketResource) {
			FileBucketResource fileBucketResource = (FileBucketResource)bucketResource;
			if(resolve.toPath().startsWith(fileBucketResource.getFile().getAbsoluteFile().toPath())) {
				return UniqueKeyUtils.evalChildResource(fileBucketResource, resolve);
			}else{
				throw new RuntimeException("Unique key non appartenente al bucket");
			}
		}
		throw new RuntimeException("Tipo bucket resource non supportato");
	}

	@Override
	public BucketResource createBucket(UUID team, String name) {
		File file = new File(new File(basePath,team.toString()),name);
		FileBucketResource fileBucketResource = new FileBucketResource(file);
		if(fileBucketResource.create()) {
			return fileBucketResource;
		}else {
			return null;
		}
	}
	
	@Override
	public BucketResource loadBucket(UUID team, String name) {
		File file = new File(new File(basePath,team.toString()),name);
		FileBucketResource fileBucketResource = new FileBucketResource(file);
		if(fileBucketResource.exist()) {
			return fileBucketResource;
		}else {
			return null;
		}
	}
	
	@Override
	public FolderResource createFolder(Resource parent, String name) {
		if(parent instanceof AbstractContainerResource) {
			AbstractContainerResource abstractResourceParent = (AbstractContainerResource) parent;
			FileFolderResource fileFolderResource = new FileFolderResource(abstractResourceParent.getFileBucketResource(), new File(abstractResourceParent.getFile(),name));
			fileFolderResource.create();
			return fileFolderResource;
		}else {
			throw new RuntimeException("Tipo resource non supportato");
		}
	}

	@Override
	public ContentResource createContent(Resource parent, String name, byte[] content) {
		if(parent instanceof AbstractResource) {
			AbstractResource abstractResourceParent = (AbstractResource) parent;
			FileContentResource fileContentResource = new FileContentResource(abstractResourceParent.getFileBucketResource(), new File(abstractResourceParent.getFile(),name));
			fileContentResource.create(content);
			return fileContentResource;
		}else {
			throw new RuntimeException("Tipo resource non supportato");
		}
	}

	@Override
	public boolean deleteResource(Resource delete,boolean recursive) {
		if(delete instanceof AbstractResource) {
			return ((AbstractResource)delete).delete(recursive);
		}else{
			throw new RuntimeException("tipo file non ammesso");
		}
	}
	
	@Override
	public boolean deleteBucket(UUID team,String bucketName) {
		AtomicBoolean a = new AtomicBoolean(true);
		BucketResource bucketResource = loadBucket(team, bucketName);
		boolean delete = deleteResource(bucketResource, true);
		boolean prevValue = a.get();
		a.set( prevValue && delete);
		return a.get();
	}

}
