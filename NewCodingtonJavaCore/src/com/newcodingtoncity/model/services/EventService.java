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
			manager.closeConnectionWithCommit();
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

	public Event getEventById(int id_event){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		Event event = null;
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			event = eventDAO.showEventById(id_event);
			manager.closeConnectionWithCommit();
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
		return event;
	}

	public List<Event> getLargeBusinessEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> largeBusinessEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			largeBusinessEvents = eventDAO.showLargeBusinessEvents();
			manager.closeConnectionWithCommit();
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
		return largeBusinessEvents;
	}
	
	public List<Event> getMuseumEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> museumEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			museumEvents = eventDAO.showMuseumEvents();
			manager.closeConnectionWithCommit();
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
		return museumEvents;
	}
	
	public List<Event> getParkEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> parkEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			parkEvents = eventDAO.showParkEvents();
			manager.closeConnectionWithCommit();
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
		return parkEvents;
	}
	
	public List<Event> getStadiumEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> stadiumEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			stadiumEvents = eventDAO.showStadiumEvents();
			manager.closeConnectionWithCommit();
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
		return stadiumEvents;
	}
	
	public List<Event> getTheaterEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> theaterEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			theaterEvents = eventDAO.showTheaterEvents();
			manager.closeConnectionWithCommit();
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
		return theaterEvents;
	}
	
	public List<Event> getTouristAttractionEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> touristAttractionEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			touristAttractionEvents = eventDAO.showTouristAttractionEvents();
			manager.closeConnectionWithCommit();
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
		return touristAttractionEvents;
	}
	
	public List<Event> getTraditionalMarketEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> traditionalMarketEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			traditionalMarketEvents = eventDAO.showTraditionalMarketEvents();
			manager.closeConnectionWithCommit();
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
		return traditionalMarketEvents;
	}
	
	public List<Event> getZooEvents(){
		DAOManager manager = null;
		IEventDAO eventDAO = null;
		List<Event> zooEvents = new ArrayList<Event>();
		try {
			manager = new DAOManager();
			eventDAO = manager.getEventDAO();
			zooEvents = eventDAO.showZooEvents();
			manager.closeConnectionWithCommit();
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
		return zooEvents;
	}
}
