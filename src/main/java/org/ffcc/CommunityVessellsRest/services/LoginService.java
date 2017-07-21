package org.ffcc.CommunityVessellsRest.services;

import javax.servlet.http.HttpSession;

public interface LoginService {

	String login(String email,String password,HttpSession session);
}
