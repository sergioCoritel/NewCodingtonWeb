package com.newcodingtoncity.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController{  

	@RequestMapping(value = "/welcome.htm")
	public String welcomeController() {
		return "welcome";
	}

}