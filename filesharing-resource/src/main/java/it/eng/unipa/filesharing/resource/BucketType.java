package it.eng.unipa.filesharing.resource;

public class BucketType {

	private final String name;
	private final String description;
	private final ResourceRepository repository;
	
	public BucketType(String name, String description, ResourceRepository repository) {
		super();
		this.name = name;
		this.description = description;
		this.repository = repository;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public ResourceRepository getRepository() {
		return repository;
	}
	
	

}


