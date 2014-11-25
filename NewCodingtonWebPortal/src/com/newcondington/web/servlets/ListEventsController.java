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
	
    	EventService eventService = new EventService(request.getServletContext());	
		ArrayList<Event> findEvents = (ArrayList<Event>) eventService.getMuseumEvents();
    	request.getServletContext().setAttribute("events",eventService.getMuseumEvents());
    	String urlDispatcher = "WEB-INF/views/list_events.jsp";
    	return urlDispatcher;
    }
}
