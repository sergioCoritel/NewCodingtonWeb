package com.newcodingtoncity.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController{  

	@RequestMapping("*")
	public String hello(HttpServletRequest request) {
	    return "index";
	}
	
	@RequestMapping(value = "/welcome.htm")
	public String welcomeController() {
		return "welcome";
	}
}