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

public class ShowEventController  implements IController  {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
    	int id = Integer.parseInt(request.getParameter("id"));

    	EventService eventService = new EventService(request.getServletContext());	
		Event findEvent = eventService.getEventById(id);
		
		request.removeAttribute("event");
		request.setAttribute("section","Show");
    	request.setAttribute("event",findEvent);
    	String urlDispatcher = "WEB-INF/views/show_event.jsp";
    	return urlDispatcher;
    }
}
