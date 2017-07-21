package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public Organization findOrganizationByEmail(String email) {
		
		return organizationRepository.findOrganizationByEmail(email);
		
	}

}
