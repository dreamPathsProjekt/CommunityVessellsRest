package org.ffcc.CommunityVessellsRest.repository;

import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;


public interface EventContainerRepository extends PagingAndSortingRepository<EventContainer, Long> {

}
