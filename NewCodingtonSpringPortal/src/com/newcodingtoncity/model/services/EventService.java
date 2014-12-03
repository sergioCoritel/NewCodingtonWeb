package com.newcodingtoncity.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.services.IEventService;



public class EventService implements IEventService{
	private IEventDAO eventDAO;

	public EventService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(  "beans.xml");  
		DAOManager daoManager = (DAOManager) ctx.getBean("daoManager");
		this.eventDAO = daoManager.getEventDAO();
	}

	@Override
	public List<Event> getAllEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showAllEvents();

	}

	@Override
	public Event getEventById(int id_event) throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showEventById(id_event);
	}

	@Override
	public List<Event> getLargeBusinessEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showLargeBusinessEvents();

	}

	@Override
	public List<Event> getMuseumEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showMuseumEvents();
	}

	@Override
	public List<Event> getParkEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showParkEvents();
	}

	@Override
	public List<Event> getStadiumEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showStadiumEvents();

	}

	@Override
	public List<Event> getTheaterEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTheaterEvents();

	}

	@Override
	public List<Event> getTouristAttractionEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTouristAttractionEvents();

	}

	@Override
	public List<Event> getTraditionalMarketEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTraditionalMarketEvents();

	}

	@Override
	public List<Event> getZooEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showZooEvents();
	}
	
	@Override
	public int deleteEvent(int eventId){
		return eventDAO.deleteEvent(eventId);
	}
	
	public int insertEvent(Event insertEvent){
		return eventDAO.insertEvent(insertEvent);
	}
	
	public int updateEvent(Event insertEvent) throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.updateEvent(insertEvent);
	}
}
