package org.ffcc.CommunityVessellsRest.services;


import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.springframework.web.multipart.MultipartFile;

public interface VolunteerService {

	Volunteer findVolunteerByEmail(String email);
	void createVolunteer(Volunteer volunteer);
	void uploadImage(Long id, MultipartFile file);
}
