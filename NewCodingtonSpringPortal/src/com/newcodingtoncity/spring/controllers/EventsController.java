package com.newcodingtoncity.spring.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.services.EventService;

@Controller
public class EventsController{

	@RequestMapping(value = "/list_events.htm")
	public ModelAndView listEventsController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();		
		String type = request.getParameter("type");

    	EventService eventService = new EventService();
		ArrayList<Event> findEvents = new ArrayList<Event>();
		if(type.equals("business")){
			findEvents = (ArrayList<Event>) eventService.getLargeBusinessEvents();
		}
		if(type.equals("museum")){
			findEvents = (ArrayList<Event>) eventService.getMuseumEvents();
		}
		if(type.equals("stadium")){
			findEvents = (ArrayList<Event>) eventService.getStadiumEvents();
		}
		if(type.equals("theater")){
			findEvents = (ArrayList<Event>) eventService.getTheaterEvents();
		}
		if(type.equals("park")){
			findEvents = (ArrayList<Event>) eventService.getParkEvents();
		}
		if(type.equals("tourist")){
			findEvents = (ArrayList<Event>) eventService.getTouristAttractionEvents();
		}
		if(type.equals("market")){
			findEvents = (ArrayList<Event>) eventService.getTraditionalMarketEvents();
		}
		if(type.equals("zoo")){
			findEvents = (ArrayList<Event>) eventService.getZooEvents();
		}
		request.setAttribute("section",type);
		modelAndView.addObject("events", findEvents);
		return modelAndView;
	}

	@RequestMapping(value = "/show_event.htm")
	public ModelAndView showEventController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();		
		int id = Integer.parseInt(request.getParameter("id"));
		EventService eventService = new EventService();	
		Event findEvent = eventService.getEventById(id);
		modelAndView.addObject("event", findEvent);
		return modelAndView;
	}
	
	@RequestMapping(value = "/create_event.htm")
	public String newEventController() {
		return "handle_event";
	}
	
	@RequestMapping(value = "/update_event.htm")
	public String updateEventController() {
		return "handle_event";
	}
	
	@RequestMapping(value = "/delete_event.htm")
	public String deleteEventController(HttpServletRequest request, HttpServletResponse response) {	
		int id = Integer.parseInt(request.getParameter("id"));
		EventService eventService = new EventService();	
		eventService.deleteEvent(id);
		return "welcome";
	}
}