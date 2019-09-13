package it.eng.unipa.filesharing.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamDTO {
	
	private UUID uuid;
	private String name;
	private String description;
	private List<UserRoleDTO> members = new ArrayList<UserRoleDTO>();
	private List<BucketDTO> buckets = new ArrayList<BucketDTO>();
	
	public TeamDTO() {
	}
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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
	public List<UserRoleDTO> getMembers() {
		return members;
	}
	
	public void setMembers(List<UserRoleDTO> members) {
		this.members = members;
	}
	
	public List<BucketDTO> getBuckets() {
		return buckets;
	}
	
	public void setBuckets(List<BucketDTO> buckets) {
		this.buckets = buckets;
	}

	@Override
	public String toString() {
		return "TeamDTO [uuid=" + uuid + ", name=" + name + ", description=" + description + ", members=" + members+ ", buckets="+buckets+"]";
	}
	
	
	
	
}
