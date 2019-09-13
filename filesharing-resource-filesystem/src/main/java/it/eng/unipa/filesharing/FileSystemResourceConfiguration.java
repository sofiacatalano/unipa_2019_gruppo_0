package it.eng.unipa.filesharing;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.eng.unipa.filesharing.resource.BucketType;
import it.eng.unipa.filesharing.resource.filesystem.FileSystemResourceRepository;

@Configuration
public class FileSystemResourceConfiguration {
	
	@Bean
	public FileSystemResourceRepository getResourceRepository(@Value("${filesystem.basePath}")File basePath) {
		return new FileSystemResourceRepository(basePath);
	}
	
	@Bean("filesystem")
	public BucketType getFileSystemBucketType(FileSystemResourceRepository reposistory) {
		return new BucketType("filesystem","File system bucket",reposistory);
	}

}
