package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.domain.Product;
import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.repository.EventContainerRepository;
import org.ffcc.CommunityVessellsRest.repository.EventRepository;
import org.ffcc.CommunityVessellsRest.repository.VolunteerRepository;
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
	
	@Autowired
	VolunteerRepository volunteerRepository;
	
	@Autowired
	private VolunteerService volunteerService;
	
	@Autowired
	private ProductService productService;
	
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

	@Override
	public Event findEventById(Long id) {
		Event event= eventRepository.findOne(id);
		return event;
	}

	@Override
	public void createPromisedProduct(Long id, Long volunteer_id,Product product) {

		Event event = eventRepository.findOne(id);
		Volunteer volunteer = volunteerService.findVolunteerById(volunteer_id);
		EventContainer eventContainer = event.getEventContainer();
		
					
		product.setIsPromised("Yes");
		volunteer.addProduct(product);				
		product.setVolunteer(volunteer);
		product.setEmail(volunteer.getEmail());
		
		productService.createProduct(eventContainer, product);
		volunteerRepository.save(volunteer);
		
	}
	
	@Override
	public String checkIfExpired(Long id){
		Product product = productService.findProductById(id);
		return productService.checkIfExpired(product);
	}

	@Override
	public String storeProduct(Long id) {
		
		Product product = productService.findProductById(id);
		EventContainer eventContainer=product.getEventContainer();
		if(product.getCount()+eventContainer.getAvailableProducts()>eventContainer.getCapacity()){
			return "Product exceeds "+eventContainer.getTitle()+" capacity: "+eventContainer.getCapacity();
		}
		
		product.setIsPromised("No");
		product.setDateStored(new java.sql.Date(new java.util.Date().getTime()));
		productService.updateProduct(product);
		
		
		eventContainer.setAvailableProducts(eventContainer.getAvailableProducts() + product.getCount());
		eventContainerRepository.save(eventContainer);
		return "Product Saved in "+eventContainer.getTitle();
		
	}

}
