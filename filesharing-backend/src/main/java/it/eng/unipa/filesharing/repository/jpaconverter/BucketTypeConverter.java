package it.eng.unipa.filesharing.repository.jpaconverter;

import javax.persistence.AttributeConverter;

import it.eng.unipa.filesharing.context.AppContextManager;
import it.eng.unipa.filesharing.resource.BucketType;

public class BucketTypeConverter implements AttributeConverter<BucketType, String>{

	@Override
	public String convertToDatabaseColumn(BucketType attribute) {
		return attribute!=null ? attribute.getName() : null;
	}

	@Override
	public BucketType convertToEntityAttribute(String dbData) {
		return dbData!=null ? (BucketType)AppContextManager.getAppContext().getBean(dbData) : null;
	}
	
	

}
