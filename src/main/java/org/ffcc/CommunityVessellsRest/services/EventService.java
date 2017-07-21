package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.springframework.web.multipart.MultipartFile;

public interface EventService {

	void createEvent(Event event);
	
	void uploadImage(Long id,MultipartFile file);
	
	Event findEventById(Long id);
}
