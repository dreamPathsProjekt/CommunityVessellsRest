package org.ffcc.CommunityVessellsRest.repository;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Long> {
	Volunteer findVolunteerByEmail( String email);
}
