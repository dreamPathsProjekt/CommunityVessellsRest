package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;

public interface VolunteerService {
	public Volunteer findVolunteerByEmail(String email);
	public void saveVolunteer(Volunteer volunteer);
}
