package org.ffcc.CommunityVessellsRest.repository;

import org.ffcc.CommunityVessellsRest.domain.ClothOps;
import org.ffcc.CommunityVessellsRest.domain.Event;
import org.ffcc.CommunityVessellsRest.domain.EventContainer;
import org.ffcc.CommunityVessellsRest.domain.ExpireOps;
import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.domain.Product;
import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ExposeIdRestConfiguration extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	    config.exposeIdsFor(Volunteer.class);
	    config.exposeIdsFor(Organization.class);
	    config.exposeIdsFor(Product.class);
	    config.exposeIdsFor(Event.class);
	    config.exposeIdsFor(EventContainer.class);
	    config.exposeIdsFor(ExpireOps.class);
	    config.exposeIdsFor(ClothOps.class);
	}
}
