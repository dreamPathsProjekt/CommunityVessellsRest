package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.springframework.web.multipart.MultipartFile;

public interface OrganizationService {

	Organization findOrganizationByEmail(String email);
	
	void createOrganization(Organization organization);
	
	void uploadImage(Long id,MultipartFile file);
	
	void createEvent(Long id,Event event);
}
