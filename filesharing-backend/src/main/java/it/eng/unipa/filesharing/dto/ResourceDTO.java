package it.eng.unipa.filesharing.dto;

import java.util.Arrays;
import java.util.List;

public class ResourceDTO {
	
	public enum TYPE{BUCKET,FOLDER,CONTENT};
	
	private TYPE type;
	private boolean leaf;
	
	private String uniqueKey;
	private String name;
	
	private List<ResourceDTO> childs;
	
	private byte[] content;
	
	public ResourceDTO() {
		
	}
	
	
	public TYPE getType() {
		return type;
	}


	public void setType(TYPE type) {
		this.type = type;
	}


	public boolean isLeaf() {
		return leaf;
	}


	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}


	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}


	public List<ResourceDTO> getChilds() {
		return childs;
	}


	public void setChilds(List<ResourceDTO> childs) {
		this.childs = childs;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContent(byte[] content) {
		this.content = content;
	}
	
	public byte[] getContent() {
		return content;
	}


	@Override
	public String toString() {
		return "ResourceDTO [type=" + type + ", leaf=" + leaf + ", uniqueKey=" + uniqueKey + ", name=" + name
				+ ", childs=" + childs + ", content=" + Arrays.toString(content) + "]";
	}


	
	
	
	
}
