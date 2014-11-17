package com.newcodingtoncity.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;



public class EventService {
	
	public List<Event> getAllEvents(){
		
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> allEvents = new ArrayList<Event>();
		
		
		
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			
			allEvents = eventDAO.showAllEvents();
			manager.closeConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allEvents;
		
	}
	
}
