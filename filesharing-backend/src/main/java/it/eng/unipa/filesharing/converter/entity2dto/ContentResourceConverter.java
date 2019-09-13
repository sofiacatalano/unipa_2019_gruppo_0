package it.eng.unipa.filesharing.converter.entity2dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.dto.ResourceDTO;
import it.eng.unipa.filesharing.resource.ContentResource;

@Component
public class ContentResourceConverter implements Converter<ContentResource,ResourceDTO>{

	@Autowired
	ResourceConverter resourceConverter;
	
	@Override
	public ResourceDTO convert(ContentResource source) {
		ResourceDTO dto  = resourceConverter.convert(source);
		dto.setContent(source.getContent());
		return dto;
	}
}
