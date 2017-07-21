package org.ffcc.CommunityVessellsRest.controllers;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.MultipartConfig;


import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.repository.EventContainerRepository;
import org.ffcc.CommunityVessellsRest.repository.EventRepository;
import org.ffcc.CommunityVessellsRest.services.StorageService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;




@RestController
@Transactional
public class EventController {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventContainerRepository eventContainerRepository; 
	
	@Autowired
	private StorageService fileUpload;
	
	
    
	//Create Event
	@RequestMapping(value = "/api/event", method = RequestMethod.POST)
	public ResponseEntity<Void> createEvent(@RequestBody Event event, UriComponentsBuilder ucBuilder) {
		
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
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/events/{id}").buildAndExpand(event.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	

	
	@RequestMapping(path = "/api/event/{id}/avatar", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file){

		Event event=eventRepository.findOne(id);
		event.setAvatar("/img/user/"+fileUpload.store(file));
		eventRepository.save(event);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
