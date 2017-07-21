package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.repository.EventContainerRepository;
import org.ffcc.CommunityVessellsRest.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventContainerRepository eventContainerRepository;
	
	@Autowired
	private StorageService fileUpload;
	
	@Override
	public void createEvent(Event event) {

		//Read Nested Json Obj
		EventContainer eventContainer=event.getEventContainer();
		eventContainer.setAvailableProducts(0);
		//Allocate one to one relation
		eventContainerRepository.save(eventContainer);
		
		eventRepository.save(event);
		
		
		//Allocate one to one relation to container
		eventContainer.setEvent(event);
		
		//Update related objects		
		eventContainerRepository.save(eventContainer);
		event.setEventContainer(eventContainer);
		eventRepository.save(event);

	}

	@Override
	public void uploadImage(Long id,MultipartFile file){
		
		Event event=eventRepository.findOne(id);
		event.setAvatar("/img/user/"+fileUpload.store(file));
		eventRepository.save(event);
	}

}
