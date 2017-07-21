package org.ffcc.CommunityVessellsRest.repository;



import org.ffcc.CommunityVessellsRest.domain.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

}
