package it.eng.unipa.filesharing.dto;

public class BucketDTO {
	
	private String name;
	
	private String description;
	
	private String bucketType;
	
	public BucketDTO() {
	}
	
	

	public BucketDTO(String name, String description, String bucketType) {
		super();
		this.name = name;
		this.description = description;
		this.bucketType = bucketType;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setBucketType(String bucketType) {
		this.bucketType = bucketType;
	}
	
	public String getBucketType() {
		return bucketType;
	}

	@Override
	public String toString() {
		return "BucketDTO [name=" + name + ", description=" + description + "]";
	}
	
	
	

}
