package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.Product;
import org.springframework.web.multipart.MultipartFile;

public interface EventService {

	void createEvent(Event event);
	
	void uploadImage(Long id,MultipartFile file);
	
	Event findEventById(Long id);
	

	void createPromisedProduct(Long id, Long volunteer_id, Product product);

	String checkIfExpired(Long id);
	
	String storeProduct(Long id);
}
