package it.eng.unipa.filesharing.converter.entity2dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import it.eng.unipa.filesharing.dto.UserRoleDTO;
import it.eng.unipa.filesharing.model.UserRole;


@Component
public class UserRoleConverter implements Converter<UserRole, UserRoleDTO>{

	@Override
	public UserRoleDTO convert(UserRole userRole) {
		UserRoleDTO userRoleDTO = null;
		if(userRole!=null) {
			userRoleDTO = new UserRoleDTO();
			userRoleDTO.setAdmin(userRole.isAdmin());
			userRoleDTO.setActive(userRole.isActive());
			userRoleDTO.setEmail(userRole.getOid().getEmail());
			userRoleDTO.setLongName(userRole.getLongName());
			
		}
		return userRoleDTO;
	}



}
