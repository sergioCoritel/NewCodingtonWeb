package com.newcondington.web.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.services.EventService;
import com.newcodingtoncity.model.services.UserService;
import com.newcondington.web.servlets.base.IController;

public class ListEventsController  implements IController  {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
    	String type = request.getParameter("type");

    	EventService eventService = new EventService(request.getServletContext());	
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
		request.removeAttribute("events");
		request.setAttribute("section",type);
    	request.setAttribute("events",findEvents);
    	String urlDispatcher = "WEB-INF/views/list_events.jsp";
    	return urlDispatcher;
    }
}
