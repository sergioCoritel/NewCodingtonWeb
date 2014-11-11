package com.newcodingtoncity.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;



public class EventsDAO {

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

	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,
			SQLException {
		connection = CodingtonConnectToDB.createConnection();
		statement = connection.prepareStatement(museumEventsQuery);
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event event = new Event();

			event.setEventName(resultSet.getString("eventname"));
			event.setDescription(resultSet.getString("description"));
			event.setDuration(resultSet.getInt("duration"));
			event.setEventType(resultSet.getString("eventtype"));
			event.setSchedule(resultSet.getString("schedule"));
			event.setTicketPrice(resultSet.getInt("ticketprice"));

			eventList.add(event);
		}
		resultSet.close();
		CodingtonConnectToDB.closeConnection();
		return eventList;
	}

//	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,
//			SQLException {}
//
//	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,
//			SQLException {}
//
//	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,
//			SQLException {}
//
//	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,
//			SQLException {}
}