package com.newcodingtoncity.model.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.mappers.EventMapper;



public class EventDAO implements IEventDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	private static String allEventsQuery = DatabaseHelper.getQuery("allevents");
	
	private static String museumEventsQuery = DatabaseHelper.getQuery("museum");
	private static String zooEventsQuery = DatabaseHelper.getQuery("zoo");
	private static String parkEventsQuery = DatabaseHelper.getQuery("park");
	private static String theaterEventsQuery = DatabaseHelper.getQuery("theater");
	private static String stadiumEventsQuery = DatabaseHelper.getQuery("stadium");
	private static String largeBusinessEventsQuery = DatabaseHelper.getQuery("largebusiness");
	private static String touristAttractionEventsQuery = DatabaseHelper.getQuery("touristattraction");
	private static String traditionalMarketEventsQuery = DatabaseHelper.getQuery("traditionalmarket");
	private static String eventByIdQuery = DatabaseHelper.getQuery("eventbyid");
	private static String insertEventQuery = DatabaseHelper.getQuery("insertevent");

	public EventDAO(Connection connection) {
		this.connection = connection;
	}

	public ArrayList<Event> requestEventList(String sqlQuery) throws ClassNotFoundException,
	SQLException, IOException {
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

	
	public ArrayList<Event> showAllEvents() throws ClassNotFoundException,
	SQLException, IOException {
		
		return requestEventList(allEventsQuery);
	}
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,SQLException, IOException {
		return requestEventList(museumEventsQuery);
	}
	

	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(zooEventsQuery);
	}

	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(parkEventsQuery);
	}

	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(theaterEventsQuery);
	}

	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(stadiumEventsQuery);
	}

	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(largeBusinessEventsQuery);
	}

	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(touristAttractionEventsQuery);
	}

	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException,
	SQLException, IOException {
	
		return requestEventList(traditionalMarketEventsQuery);
	}
	

	public Event showEventById (int id) throws ClassNotFoundException, SQLException, IOException{

		statement = connection.prepareStatement(eventByIdQuery);
		statement.setInt(1,id);
		resultSet = statement.executeQuery();
		Event event = EventMapper.map(resultSet);
		resultSet.close();
		return event;
	}

	@Override
	public int insertEvent(Event insertEvent) {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(insertEventQuery);
			preparedStatement.setString(1, insertEvent.getEventName());
			preparedStatement.setString(2, insertEvent.getDescription());
			preparedStatement.setInt(3, insertEvent.getTicketPrice());
			preparedStatement.setInt(4, insertEvent.getSeatsAvailable());

			affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

	@Override
	public int deleteEvent(int eventId) {

		return 0;
	}

}