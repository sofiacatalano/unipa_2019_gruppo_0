package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import it.eng.unipa.filesharing.resource.ContentResource;

class FileContentResource extends AbstractChildResource implements ContentResource{

	public FileContentResource(FileBucketResource fileBucketResource,File file) {
		super(fileBucketResource,file);
	}

	@Override
	public byte[] getContent() {
		try {
			return Files.readAllBytes(getFile().toPath());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean create(byte[] body) {
		if(!getFile().exists()) {
			try {
				Files.write(getFile().toPath(),body);
				return true;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}else{
			throw new RuntimeException("risorsa gia' esistente");
		}
	}

}
