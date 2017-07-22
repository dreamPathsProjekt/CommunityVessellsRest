package org.ffcc.CommunityVessellsRest.controllers;

import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	//Register Organization
	@RequestMapping(value = "/api/organization", method = RequestMethod.POST)
	public ResponseEntity<Void> createOrganization(@RequestBody Organization organization, UriComponentsBuilder ucBuilder) {
		
		organizationService.createOrganization(organization);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/organizations/{id}").buildAndExpand(organization.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//upload avatar
	@RequestMapping(path = "/api/organization/{id}/avatar", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file){

		organizationService.uploadImage(id, file);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//create event send org id and event json
	@RequestMapping(value = "/api/organization/{id}/event", method = RequestMethod.POST)
	public ResponseEntity<Void> createEvent(@PathVariable("id") Long id,@RequestBody Event event,UriComponentsBuilder ucBuilder) {
		
		organizationService.createEvent(id, event);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/organizations/{id}").buildAndExpand(id+"/events/"+event.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
