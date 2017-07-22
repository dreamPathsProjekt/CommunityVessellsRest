package org.ffcc.CommunityVessellsRest.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.ffcc.CommunityVessellsRest.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@Valid @RequestParam String email,@Valid @RequestParam String password,HttpSession session){
		try{
			String message = loginService.login(email, password, session);
			session.setAttribute("message", message);
			if(session.getAttribute("user")!=null&&session.getAttribute("user").equals("volunteer")){
				return "volunteer";
			}
			if(session.getAttribute("user")!=null&&session.getAttribute("user").equals("organization")){
				return "organization";
			}
			
		}
		catch(ConstraintViolationException constraint){
			session.setAttribute("constraint", constraint.getMessage());
			return "redirect:/login";
		}
		return "redirect:/login";
	}


}
