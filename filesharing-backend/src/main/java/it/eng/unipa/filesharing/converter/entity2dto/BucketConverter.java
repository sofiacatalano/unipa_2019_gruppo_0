package it.eng.unipa.filesharing.converter.entity2dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.dto.BucketDTO;
import it.eng.unipa.filesharing.model.Bucket;

@Component
public class BucketConverter  implements Converter<Bucket, BucketDTO>{

	@Override
	public BucketDTO convert(Bucket bucket) {
		BucketDTO bucketDTO = null;
		if(bucket!=null) {
			bucketDTO = new BucketDTO();
			bucketDTO.setName(bucket.getName());
			bucketDTO.setDescription(bucket.getName());
		}
		return bucketDTO;
	}
}
