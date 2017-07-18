package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class VolunteerServiceImpl implements VolunteerService {

	@Autowired
	private VolunteerRepository volunteerRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Volunteer findVolunteerByEmail(String email) {
		
		return volunteerRepository.findByEmail(email);
	}

	@Override
	public void saveVolunteer(Volunteer volunteer) {
		
		volunteer.setPassword(bCryptPasswordEncoder.encode(volunteer.getPassword()));
		volunteerRepository.save(volunteer);
	}

}
