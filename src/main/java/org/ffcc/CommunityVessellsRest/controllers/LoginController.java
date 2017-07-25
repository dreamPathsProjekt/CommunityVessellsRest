package org.ffcc.CommunityVessellsRest.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.ffcc.CommunityVessellsRest.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@Valid @RequestParam String email,@Valid @RequestParam String password,HttpSession session,ModelMap model){
		try{
			String message = loginService.login(email, password, session);
			session.setAttribute("message", message);
			model.addAttribute("message",session.getAttribute("message"));
			
			if(session.getAttribute("user")!=null&&session.getAttribute("user").equals("volunteer")){
				
				model.addAttribute("sessionUser", session.getAttribute("user"));
				model.addAttribute("sessionId", session.getAttribute("id"));
				model.addAttribute("sessionEmail",session.getAttribute("email"));
				
				return "volunteer";
			}
			if(session.getAttribute("user")!=null&&session.getAttribute("user").equals("organization")){
				
				model.addAttribute("sessionUser", session.getAttribute("user"));
				model.addAttribute("sessionId", session.getAttribute("id"));
				model.addAttribute("sessionEmail",session.getAttribute("email"));
				
				return "organization";
			}
			return "index";
		}
		catch(ConstraintViolationException constraint){
			session.setAttribute("constraint", constraint.getMessage());
			model.addAttribute("constraint",session.getAttribute("constraint"));
			return "index";
		}
		
	}


}
