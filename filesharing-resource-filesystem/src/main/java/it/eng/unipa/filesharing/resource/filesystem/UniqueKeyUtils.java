package it.eng.unipa.filesharing.resource.filesystem;

import java.io.File;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import it.eng.unipa.filesharing.resource.ChildResource;

class UniqueKeyUtils {
	
	private static Encoder encoder = Base64.getEncoder();
	private static Decoder decoder = Base64.getDecoder();
	
	
	public static String unique(File file) {
		return encoder.encodeToString(file.getAbsolutePath().getBytes());
	}
	
	public static File resolve(File basePath,String unique) {
		String pathname = new String(decoder.decode(unique.getBytes()));
		if(pathname.contains(basePath.getName())) {
			return new File(pathname); 
		}else {
			throw new RuntimeException("unique "+unique+" errato");
		}
	}
	
	
	public static ChildResource evalChildResource(FileBucketResource fileBucketResource,File f) {
		return f.isDirectory() ? new FileFolderResource(fileBucketResource, f) : new FileContentResource(fileBucketResource,f);
	}

}
