package org.ffcc.CommunityVessellsRest.controllers;



import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.Product;
import org.ffcc.CommunityVessellsRest.services.EventService;
import org.ffcc.CommunityVessellsRest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;




@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
		
    
	//Create Event
	@RequestMapping(value = "/api/event", method = RequestMethod.POST)
	public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
		
		eventService.createEvent(event);
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/events/{id}").buildAndExpand(event.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	
	@RequestMapping(path = "/api/event/{id}/avatar", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file){

		eventService.uploadImage(id, file);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/event/{id}/promise/{volunteer_id}", method = RequestMethod.POST)
	public ResponseEntity<Void> createPromisedProduct(@PathVariable("id") Long id,@PathVariable("volunteer_id") Long volunteer_id,@RequestBody Product product, UriComponentsBuilder ucBuilder) {
					
		eventService.createPromisedProduct(id, volunteer_id, product);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/products/{id}").buildAndExpand(product.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/product/{id}/isexpired", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String checkIfExpired(@PathVariable("id") Long id){
		try{
			return eventService.checkIfExpired(id);
		}catch(NullPointerException notExpireOps){
			
			return "This product is of type Clothing or the product does not exist";
		}
	}
}
