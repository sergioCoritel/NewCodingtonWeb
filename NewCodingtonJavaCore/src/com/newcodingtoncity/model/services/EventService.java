package com.newcodingtoncity.model.services;

import java.util.ArrayList;
import java.util.List;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.daos.EventDAO;
import com.newcodingtoncity.model.domain.*;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;



public class EventService {
	
	public List<Event> getAllEvents(){
		
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> allEvents = new ArrayList<Event>();
		
		manager = new DAOManager();
		eventDAO = manager.getEventDAO();

		
		return allEvents;
		
	}
	
}
