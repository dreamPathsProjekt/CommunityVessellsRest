package org.ffcc.CommunityVessellsRest.repository;

import java.util.List;

import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


public interface VolunteerRepository extends PagingAndSortingRepository<Volunteer, Long> {
	Volunteer findVolunteerByEmail( String email);
}
