package com.newcodingtoncity.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController{  

	@RequestMapping(value = "/register.htm")
	public String registerController() {
		return "register";
	}


	@RequestMapping(value = "/login.htm")
	public String loginController() {
		boolean loginSuccesfull = true;
		if (!loginSuccesfull) {
			return "index";
		}
		return "welcome";
	}


}