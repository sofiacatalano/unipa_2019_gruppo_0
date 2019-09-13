package it.eng.unipa.filesharing.resource;

public interface Resource {
	
	public String getUniqueKey();
	 
	public enum TYPE{BUCKET,FOLDER,CONTENT,CHILD,CONTAINER};
	
	public String getName();
	
	public boolean isType(TYPE type);
	
	public boolean isLeaf();

}
