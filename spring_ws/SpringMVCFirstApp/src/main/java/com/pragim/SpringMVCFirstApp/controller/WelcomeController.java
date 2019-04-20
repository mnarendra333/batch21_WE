package com.pragim.SpringMVCFirstApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	
	
	
	@RequestMapping("/display")
	public ModelAndView welcomeMsg(){
		
		String message = "Welcome to Spring MVC Tutorials!!!";
		return new ModelAndView("success","msg",message);
	}

}
