package org.ffcc.CommunityVessellsRest.repository;

import java.util.List;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Long> {
	Volunteer findByEmail( String email);
}
