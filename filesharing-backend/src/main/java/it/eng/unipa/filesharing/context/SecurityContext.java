package it.eng.unipa.filesharing.context;

import org.keycloak.KeycloakPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContext {
	
	public static final String getEmail(){
		KeycloakPrincipal principal = getPrincipal();
		return principal!=null ? principal.getName() : null;
	}
	
	public static final String getLongName() {
		KeycloakPrincipal principal = getPrincipal();
		return  principal!=null ? principal.getKeycloakSecurityContext().getToken().getName() : null;
	}
	
	
	private static final KeycloakPrincipal getPrincipal(){
		org.springframework.security.core.context.SecurityContext context = SecurityContextHolder.getContext();
		if(context!=null) {
			Authentication authentication = context.getAuthentication();
			if(authentication!=null) {
				return (KeycloakPrincipal)authentication.getPrincipal();
			}
		}
		return null;
	}


	public static final Object getAttributes(String attributeName){
		KeycloakPrincipal keycloakPrincipal = getPrincipal();
		return keycloakPrincipal!=null ? keycloakPrincipal.getKeycloakSecurityContext().getToken().getOtherClaims().get(attributeName) : null;
	}


}
