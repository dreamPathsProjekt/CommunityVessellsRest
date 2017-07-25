package org.ffcc.CommunityVessellsRest.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@GetMapping(path="/")	
	public String index(ModelMap model,HttpSession session){
		if(session.getAttribute("message")!=null){
			model.addAttribute("message",session.getAttribute("message"));
			session.removeAttribute("message");
		}
		
		if(session.getAttribute("constraint")!=null){
			model.addAttribute("constraint",session.getAttribute("constraint"));
			session.removeAttribute("constraint");
		}
		
		if(session.getAttribute("user")!=null){
			model.addAttribute("sessionUser", session.getAttribute("user"));
			model.addAttribute("sessionId", session.getAttribute("id"));
			model.addAttribute("sessionEmail",session.getAttribute("email"));
		}
		return "index";
	}
	
	@GetMapping(path="/organization")	
	public String organization(ModelMap model,HttpSession session){	
		if(session.getAttribute("user")==null || session.getAttribute("user").equals("volunteer")){
			return "index";
		}
		
		model.addAttribute("sessionUser", session.getAttribute("user"));
		model.addAttribute("sessionId", session.getAttribute("id"));
		model.addAttribute("sessionEmail",session.getAttribute("email"));
		
		return "organization";
	}
	
	@GetMapping(path="/volunteer")	
	public String volunteer(ModelMap model,HttpSession session){	

		if(session.getAttribute("user")==null || session.getAttribute("user").equals("organization")){
			return "index";
		}
		model.addAttribute("message",session.getAttribute("message"));
		
		model.addAttribute("sessionUser", session.getAttribute("user"));
		model.addAttribute("sessionId", session.getAttribute("id"));
		model.addAttribute("sessionEmail",session.getAttribute("email"));
		
		return "volunteer";
	}
	
	@GetMapping(path="/logout")	
	public String index(HttpSession session){
		session.invalidate();
		return "index";
	}
	
	
}
