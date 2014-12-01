package com.newcodingtoncity.model.interfaces.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.newcodingtoncity.model.domain.Event;



public interface IEventService {
	
	public List<Event> getAllEvents() throws ClassNotFoundException, SQLException, IOException;
	public Event getEventById(int id_event) throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getLargeBusinessEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getMuseumEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getParkEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getStadiumEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getTheaterEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getTouristAttractionEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getTraditionalMarketEvents() throws ClassNotFoundException, SQLException, IOException;
	public List<Event> getZooEvents() throws ClassNotFoundException, SQLException, IOException;
	public int deleteEvent(int eventId);

}
