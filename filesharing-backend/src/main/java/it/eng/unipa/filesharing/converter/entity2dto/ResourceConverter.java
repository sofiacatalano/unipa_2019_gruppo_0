package it.eng.unipa.filesharing.converter.entity2dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.dto.ResourceDTO;
import it.eng.unipa.filesharing.dto.ResourceDTO.TYPE;
import it.eng.unipa.filesharing.resource.Resource;

@Component
public class ResourceConverter implements Converter<Resource, ResourceDTO>{

	@Override
	public ResourceDTO convert(Resource source) {
		ResourceDTO dto = null;
		if(source!=null) {
			dto = new ResourceDTO();
			dto.setName(source.getName());
			dto.setUniqueKey(source.getUniqueKey());
			dto.setLeaf(source.isLeaf());
			
			if(source.isType(it.eng.unipa.filesharing.resource.Resource.TYPE.BUCKET)) {
				dto.setType(TYPE.BUCKET);
			}else if(source.isType(it.eng.unipa.filesharing.resource.Resource.TYPE.FOLDER)) {
				dto.setType(TYPE.FOLDER);
			}else if(source.isType(it.eng.unipa.filesharing.resource.Resource.TYPE.CONTENT)) {
				dto.setType(TYPE.CONTENT);
				//non copio il contenuto;
			}
		}
		return dto;
	}

}
