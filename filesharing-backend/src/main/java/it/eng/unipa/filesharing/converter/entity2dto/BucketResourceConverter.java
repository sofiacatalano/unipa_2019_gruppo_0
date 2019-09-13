package it.eng.unipa.filesharing.converter.entity2dto;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.dto.ResourceDTO;
import it.eng.unipa.filesharing.resource.BucketResource;
import it.eng.unipa.filesharing.resource.ContainerResource;
import it.eng.unipa.filesharing.resource.Resource;

@Component
public class BucketResourceConverter implements Converter<BucketResource,ResourceDTO> {
	
	@Autowired
	ResourceConverter resourceConverter;
	
	@Override
	public ResourceDTO convert(BucketResource source) {
		return recursiveCopy(source);
	}
	
	private ResourceDTO recursiveCopy(Resource source) {
		ResourceDTO dto = null;
		if(source!=null) {
			
			dto  = resourceConverter.convert(source);
			
			if(source.isType(it.eng.unipa.filesharing.resource.Resource.TYPE.CONTAINER)) {
				dto.setChilds(((ContainerResource)source).getChilds().stream().map((r)->recursiveCopy(r)).collect(Collectors.toList()));
			}
		}
		
		return dto;
		
	}

}
