package com.newcodingtoncity.spring.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.interfaces.services.IPlaceService;
import com.newcodingtoncity.model.services.EventService;
import com.newcodingtoncity.model.services.EventSignUpService;
import com.newcodingtoncity.model.services.PlaceService;

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
		User user = (User) request.getSession().getAttribute("user");
		EventSignUp eventSignUp = new EventSignUp(id,user.getUserId());
		EventSignUpService eventSignUpService = new EventSignUpService();
		boolean isRegister = eventSignUpService.IsRegisteredToEvent(eventSignUp);
		modelAndView.addObject("isRegister",isRegister);
		return modelAndView;
	}
	
	@RequestMapping(value = "/create_event.htm")
	public ModelAndView createEventController(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();	
		IPlaceService placeService;
		placeService = new PlaceService();
		
		ArrayList<LargeBusiness> largeBusiness = new ArrayList<LargeBusiness>();
		largeBusiness = (ArrayList<LargeBusiness>) placeService.getLargeBusiness();
		
		ArrayList<Museum> museum = new ArrayList<Museum>();
		museum = (ArrayList<Museum>) placeService.getMuseums();
		
		ArrayList<Park> parks = new ArrayList<Park>();
		parks = (ArrayList<Park>) placeService.getParks();
		
		ArrayList<Stadium> stadiums= new ArrayList<Stadium>();
		stadiums = (ArrayList<Stadium>) placeService.getStadiums();
		
		ArrayList<Theater> theaters= new ArrayList<Theater>();
		theaters = (ArrayList<Theater>) placeService.getTheaters();
		
		ArrayList<TouristAttraction> touristAttractions= new ArrayList<TouristAttraction>();
		touristAttractions = (ArrayList<TouristAttraction>) placeService.getTouristAttractions();
		
		ArrayList<TraditionalMarket> traditionalMarkets= new ArrayList<TraditionalMarket>();
		traditionalMarkets = (ArrayList<TraditionalMarket>) placeService.getTraditionalMarkets();
		
		ArrayList<Zoo> zoos= new ArrayList<Zoo>();
		zoos = (ArrayList<Zoo>) placeService.getZoos();
		
		modelAndView.addObject("largeBusiness", largeBusiness);
		modelAndView.addObject("museum", museum);
		modelAndView.addObject("parks", parks);
		modelAndView.addObject("stadium", stadiums);
		modelAndView.addObject("theater", theaters);
		modelAndView.addObject("touristAttraction", touristAttractions);
		modelAndView.addObject("traditionalMarket", traditionalMarkets);
		modelAndView.addObject("zoo", zoos);
		modelAndView.setViewName("handle_event");
		return modelAndView;
	}
	
	@RequestMapping(value = "/new_event.htm")
	public String newEventController(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Event eventInserted = new Event();
		eventInserted.setEventName(request.getParameter("name"));
		eventInserted.setDescription(request.getParameter("description"));
		eventInserted.setStart(request.getParameter("start"));
		eventInserted.setEnd(request.getParameter("end"));
		eventInserted.setEventType(request.getParameter("eventType"));
		eventInserted.setTicketPrice(Integer.parseInt(request.getParameter("ticketPrice")));
		eventInserted.setSeatsAvailable(Integer.parseInt(request.getParameter("seatsAvailable")));
		eventInserted.setSeatsTotal(Integer.parseInt(request.getParameter("seatsAvailable")));
		Place place = new Museum();
		place.setId(Integer.parseInt(request.getParameter("place")));
		
//		if(new EventService().insertEvent(eventInserted) == 1){
//			request.setAttribute("ok", "Created event succesfully.");
//		}else{
//			request.setAttribute("error", "Unexpeted error creating event, please try again.");
//		}
		
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