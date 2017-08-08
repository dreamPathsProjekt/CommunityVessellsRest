package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class VolunteerServiceImpl implements VolunteerService {

	@Autowired
	private VolunteerRepository volunteerRepository;
	
	@Autowired
	private StorageService fileUpload;
	
	@Override
	public Volunteer findVolunteerByEmail(String email) {
		
		return volunteerRepository.findVolunteerByEmail(email);

	}

	@Override
	public void createVolunteer(Volunteer volunteer) {
		volunteerRepository.save(volunteer);
		
	}
	
	@Override
	public void uploadImage(Long id, MultipartFile file) {
		Volunteer volunteer=volunteerRepository.findOne(id);
		volunteer.setAvatarPath("images/user/"+fileUpload.store(file));
		volunteerRepository.save(volunteer);
		
		
	}

	@Override
	public Volunteer findVolunteerById(Long id) {
		return volunteerRepository.findOne(id);
	}

}
