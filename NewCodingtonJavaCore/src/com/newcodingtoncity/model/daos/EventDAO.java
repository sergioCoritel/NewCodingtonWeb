package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.mappers.EventMapper;



public class EventDAO implements IEventDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	private static String museumEventsQuery = DatabaseHelper.getQuery("museum");

	private static String zooEventsQuery = DatabaseHelper.getQuery("zoo");

	private static String parkEventsQuery = DatabaseHelper.getQuery("park");

	private static String theaterEventsQuery = DatabaseHelper.getQuery("theater");

	private static String stadiumEventsQuery = DatabaseHelper.getQuery("stadium");

	private static String largeBusinessEventsQuery = DatabaseHelper.getQuery("largebusiness");

	private static String touristAttractionEventsQuery = DatabaseHelper.getQuery("touristattraction");

	private static String traditionalMarketEventsQuery = DatabaseHelper.getQuery("traditionalmarket");

	public EventDAO(Connection connection) {
		this.connection = connection;
	}
	
	public ArrayList<Event> requestEventList(String sqlQuery) throws ClassNotFoundException,
	SQLException {
		statement = connection.prepareStatement(sqlQuery);
		
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = EventMapper.map(resultSet);
			eventList.add(event); 
		}
		resultSet.close();
		return eventList;
	}
	
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(museumEventsQuery);
	}

	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(zooEventsQuery);
	}
	
	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(parkEventsQuery);
	}
	
	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(theaterEventsQuery);
	}
	
	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(stadiumEventsQuery);
	}
	
	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(largeBusinessEventsQuery);
	}
	
	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException,
	SQLException {
		
		return requestEventList(touristAttractionEventsQuery);
	}
	
	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException,
	SQLException {
	
		return requestEventList(traditionalMarketEventsQuery);
	}

}