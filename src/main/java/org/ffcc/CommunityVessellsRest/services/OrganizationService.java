package org.ffcc.CommunityVessellsRest.services;

import org.ffcc.CommunityVessellsRest.domain.Organization;

public interface OrganizationService {

	Organization findOrganizationByEmail(String email);
}
