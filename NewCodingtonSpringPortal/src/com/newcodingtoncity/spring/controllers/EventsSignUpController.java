package com.newcodingtoncity.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.services.EventSignUpService;

@Controller
public class EventsSignUpController {
	
	@RequestMapping(value = "/register_event.htm")
	public String registerEventController(HttpServletRequest request, HttpServletResponse response) {
		int eventId = Integer.parseInt(request.getParameter("id"));
		int visitorId = Integer.parseInt(request.getSession().getId());
		EventSignUp eventSignUp = new EventSignUp(eventId,visitorId);
		EventSignUpService eventSignUpService = new EventSignUpService();
		eventSignUpService.registerVisitorForNewEvent(eventSignUp);
		return "show_event";
	}

	@RequestMapping(value = "/unregister_event.htm")
	public String unRegisterEventController(HttpServletRequest request, HttpServletResponse response) {
		int eventId = Integer.parseInt(request.getParameter("id"));
		int visitorId = Integer.parseInt(request.getSession().getId());
		EventSignUp eventSignUp = new EventSignUp(eventId,visitorId);
		EventSignUpService eventSignUpService = new EventSignUpService();
		eventSignUpService.unregisterVisitorForEvent(eventSignUp);	
		return "show_event";
	}

}
