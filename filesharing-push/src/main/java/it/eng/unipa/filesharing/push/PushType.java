package it.eng.unipa.filesharing.push;

public class PushType {

	private final String name;
	private final String description;
	private final PushFactory pushFactory;
	
	public PushType(String name, String description, PushFactory pushFactory) {
		super();
		this.name = name;
		this.description = description;
		this.pushFactory = pushFactory;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public PushFactory getPushFactory() {
		return pushFactory;
	}
	
	

}


