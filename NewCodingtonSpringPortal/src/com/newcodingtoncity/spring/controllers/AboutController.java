package com.newcodingtoncity.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController{

	@RequestMapping(value = "/about.htm")
	public String aboutController() {
		return "about";
	}
}