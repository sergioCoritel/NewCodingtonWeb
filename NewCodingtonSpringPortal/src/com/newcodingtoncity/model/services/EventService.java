package com.newcodingtoncity.model.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;



public class EventService {
	private IEventDAO eventDAO;

	public EventService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(  "beans.xml");  
		DAOManager daoManager = (DAOManager) ctx.getBean("daoManager");
		this.eventDAO = daoManager.getEventDAO();
	}

	public List<Event> getAllEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showAllEvents();

	}

	public Event getEventById(int id_event) throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showEventById(id_event);
	}

	public List<Event> getLargeBusinessEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showLargeBusinessEvents();

	}

	public List<Event> getMuseumEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showMuseumEvents();
	}

	public List<Event> getParkEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showParkEvents();
	}

	public List<Event> getStadiumEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showStadiumEvents();

	}

	public List<Event> getTheaterEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTheaterEvents();

	}

	public List<Event> getTouristAttractionEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTouristAttractionEvents();

	}

	public List<Event> getTraditionalMarketEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showTraditionalMarketEvents();

	}

	public List<Event> getZooEvents() throws ClassNotFoundException, SQLException, IOException{
		return eventDAO.showZooEvents();

	}
}
