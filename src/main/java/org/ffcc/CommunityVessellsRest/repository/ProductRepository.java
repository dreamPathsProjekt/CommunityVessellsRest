package org.ffcc.CommunityVessellsRest.repository;

import org.ffcc.CommunityVessellsRest.domain.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
