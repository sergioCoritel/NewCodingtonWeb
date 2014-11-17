package com.newcodingtoncity.model.interfaces.daos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;

public interface IEventDAO {
	
<<<<<<< HEAD
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showParkEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException, SQLException;
	public Event showEventById (int id) throws ClassNotFoundException, SQLException;
=======
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showParkEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException, SQLException, IOException;
	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException, SQLException, IOException;
>>>>>>> agus
}
