package org.ffcc.CommunityVessellsRest.services;


import org.ffcc.CommunityVessellsRest.domain.Volunteer;

public interface VolunteerService {

	Volunteer findVolunteerByEmail(String email);
}
