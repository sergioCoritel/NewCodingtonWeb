package com.newcodingtoncity.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.services.EventSignUpService;

@Controller
public class EventsSignUpController {
	
	@RequestMapping(value = "/register_event.htm")
	public String registerEventController(HttpServletRequest request, HttpServletResponse response) {
		int eventId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		EventSignUp eventSignUp = new EventSignUp(eventId,user.getUserId());
		EventSignUpService eventSignUpService = new EventSignUpService();
		eventSignUpService.registerVisitorForNewEvent(eventSignUp);
		return "redirect:/myevents.htm";
	}

	@RequestMapping(value = "/unregister_event.htm")
	public String unRegisterEventController(HttpServletRequest request, HttpServletResponse response) {
		int eventId = Integer.parseInt(request.getParameter("id"));
		User user = (User) request.getSession().getAttribute("user");
		EventSignUp eventSignUp = new EventSignUp(eventId,user.getUserId());
		EventSignUpService eventSignUpService = new EventSignUpService();
		eventSignUpService.unregisterVisitorForEvent(eventSignUp);	
		return "redirect:/myevents.htm";
	}

}
