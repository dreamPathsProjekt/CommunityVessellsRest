package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.ClothOps;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.domain.ExpireOps;
import org.ffcc.CommunityVessellsRest.domain.Product;
import org.ffcc.CommunityVessellsRest.repository.ClothOpsRepository;
import org.ffcc.CommunityVessellsRest.repository.EventContainerRepository;
import org.ffcc.CommunityVessellsRest.repository.ExpireOpsRepository;
import org.ffcc.CommunityVessellsRest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ClothOpsRepository clothOpsRepository;
	
	@Autowired
	private ExpireOpsRepository  expireOpsRepository;
	
	@Autowired
	private EventContainerRepository eventContainerRepository;
	
	@Override
	public Product findProductById(Long id) {
		
		return productRepository.findOne(id);
	}

	@Override
	public void createProduct(EventContainer eventContainer,Product product) {
		
		product.setType(eventContainer.getType());

		ExpireOps expireOps=product.getExpireOps();
		ClothOps clothOps=product.getClothOps();

		if(eventContainer.getType().equals("Food")||eventContainer.getType().equals("Pharmaceuticals")){
			
			expireOps.setIsExpired();

			expireOpsRepository.save(expireOps);
			product.setExpireOps(expireOps);

			productRepository.save(product);

			expireOps.setProduct(product);
			expireOpsRepository.save(expireOps);
		}
		if(eventContainer.getType().equals("Clothing")){
			
			clothOps.setIsFubar();
			
			clothOpsRepository.save(clothOps);
			product.setClothOps(clothOps);
			
			productRepository.save(product);
			
			clothOps.setProduct(product);
			clothOpsRepository.save(clothOps);
			
		}
		
		eventContainer.addProduct(product);
		eventContainerRepository.save(eventContainer);
		
		product.setEventContainer(eventContainer);
		productRepository.save(product);
		
	}
	
	@Override
	public String checkIfExpired(Product product){
		
		ExpireOps expireOps=product.getExpireOps();
		expireOps.setIsExpired();
		expireOpsRepository.save(expireOps);
		
		return expireOps.getIsExpired();
	}
	
	@Override
	public void updateProduct(Product product){
		productRepository.save(product);
	}

}
