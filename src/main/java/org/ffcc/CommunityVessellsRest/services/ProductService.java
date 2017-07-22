package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.domain.Product;

public interface ProductService {

	Product findProductById(Long id);
	void createProduct(EventContainer eventContainer,Product product);
	String checkIfExpired(Product product);
}
