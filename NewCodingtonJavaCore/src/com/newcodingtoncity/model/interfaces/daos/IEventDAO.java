package com.newcodingtoncity.model.interfaces.daos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;

public interface IEventDAO {
	
	public ArrayList<Event> showAllEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showParkEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException, SQLException, IOException;
	public Event showEventById (int id) throws ClassNotFoundException, SQLException, IOException;
	public int insertEvent(Event insertEvent);
	public int deleteEvent(int eventId);
    public int updateEvent(Event updateEvent) throws ClassNotFoundException, SQLException, IOException;
	public int updateSeatsEventDec(int eventId)  throws ClassNotFoundException, SQLException, IOException;
	public int updateSeatsEventInc(int eventId)  throws ClassNotFoundException, SQLException, IOException;
}
