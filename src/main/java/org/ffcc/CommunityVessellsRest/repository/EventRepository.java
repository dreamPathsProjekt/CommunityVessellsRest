package org.ffcc.CommunityVessellsRest.repository;



import org.ffcc.CommunityVessellsRest.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
