package org.ffcc.CommunityVessellsRest.controllers;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.repository.EventContainerRepository;
import org.ffcc.CommunityVessellsRest.repository.EventRepository;
import org.ffcc.CommunityVessellsRest.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventContainerRepository eventContainerRepository;
	
	@GetMapping(path="/test")
	public @ResponseBody String test(){
		Organization org = new Organization();
		org.setEmail("test@test.com");
		org.setPassword("testtest");
		org.setDescription("aaa");
		org.setType("ngo");
		organizationRepository.save(org);
		
		Event event = new Event();
		event.setTitle("tst event");
		event.setAddress("bla st 5");
		
		EventContainer cont=new EventContainer();
		cont.setTitle("testbla");
		cont.setCapacity(10);
		cont.setAvailableProducts(0);
		eventContainerRepository.save(cont);
		
		
		eventRepository.save(event);
		
		
		
		
		
		return	 "Saved";
		}
}
