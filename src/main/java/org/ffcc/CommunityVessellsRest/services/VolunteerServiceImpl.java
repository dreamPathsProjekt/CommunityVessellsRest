package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VolunteerServiceImpl implements VolunteerService {

	@Autowired
	private VolunteerRepository volunteerRepository;
	
	@Override
	public Volunteer findVolunteerByEmail(String email) {
		
		return volunteerRepository.findVolunteerByEmail(email);

	}

}
