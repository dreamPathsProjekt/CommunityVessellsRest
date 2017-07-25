package org.ffcc.CommunityVessellsRest.services;

import javax.servlet.http.HttpSession;

import org.ffcc.CommunityVessellsRest.domain.Organization;
import org.ffcc.CommunityVessellsRest.domain.Volunteer;
import org.ffcc.CommunityVessellsRest.encryption.EncryptMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private VolunteerService volunteerService;
	
	@Override
	public String login(String email, String password,HttpSession session) {
		Organization org = organizationService.findOrganizationByEmail(email);
		Volunteer vol = volunteerService.findVolunteerByEmail(email);

		if(vol!=null){
			if(EncryptMD5.authenticateUser(password, vol.getPassword())){
				session.setAttribute("user", "volunteer");
				session.setAttribute("id", vol.getId());
				session.setAttribute("email", vol.getEmail());
				return "Welcome "+vol.getFirstName()+" "+vol.getLastName();
			}
			return "User Credentials are wrong!";
		}
		if(org!=null){
			if(EncryptMD5.authenticateUser(password, org.getPassword())){
				session.setAttribute("user", "organization");
				session.setAttribute("id", org.getId());
				session.setAttribute("email", org.getEmail());
				return "Welcome "+org.getName();
			}
			return "User Credentials are wrong!";
		}
		return "There is no User registered with email "+email;
	}
	

}
