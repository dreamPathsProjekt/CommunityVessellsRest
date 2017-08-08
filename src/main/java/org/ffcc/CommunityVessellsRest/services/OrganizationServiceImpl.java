package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.repository.EventRepository;
import org.ffcc.CommunityVessellsRest.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private StorageService fileUpload;
	
	@Override
	public Organization findOrganizationByEmail(String email) {
		
		return organizationRepository.findOrganizationByEmail(email);
		
	}

	@Override
	public void createOrganization(Organization organization) {
		organizationRepository.save(organization);
		
	}

	@Override
	public void uploadImage(Long id, MultipartFile file) {
		Organization organization=organizationRepository.findOne(id);
		organization.setAvatarPath("images/user/"+fileUpload.store(file));
		organizationRepository.save(organization);
		
		
	}
	
	public void createEvent(Long id,Event event){
		Organization organization=organizationRepository.findOne(id);
		eventService.createEvent(event);
		organization.addEvent(event);
		
		organizationRepository.save(organization);
		event.setOrganization(organization);
		eventRepository.save(event);
		
	}
}
