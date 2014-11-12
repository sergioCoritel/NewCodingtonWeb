package com.newcodingtoncity.model.interfaces.daos;

import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;

public interface IEventDAO {
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showParkEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException, SQLException;
	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException, SQLException;
}
