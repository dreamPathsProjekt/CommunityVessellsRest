package org.ffcc.CommunityVessellsRest.controllers;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.services.VolunteerService;
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
public class VolunteerController {

	@Autowired
	private VolunteerService volunteerService;
	
	//Register Volunteer
	@RequestMapping(value = "/api/volunteer", method = RequestMethod.POST)
	public ResponseEntity<Void> createVolunteer(@RequestBody Volunteer volunteer, UriComponentsBuilder ucBuilder) {
		
		volunteerService.createVolunteer(volunteer);
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/volunteers/{id}").buildAndExpand(volunteer.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//upload avatar
	@RequestMapping(path = "/api/volunteer/{id}/avatar", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> uploadImage(@PathVariable("id") Long id,@RequestParam("file") MultipartFile file){

		volunteerService.uploadImage(id, file);
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
}
