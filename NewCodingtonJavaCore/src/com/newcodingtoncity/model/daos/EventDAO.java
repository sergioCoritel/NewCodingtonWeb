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
	private DatabaseHelper databaseHelper;

	public EventDAO(Connection connection, DatabaseHelper databaseHelper) {
		this.connection = connection;
		this.databaseHelper = databaseHelper;
	}

	public ArrayList<Event> requestEventList(String sqlQuery) throws ClassNotFoundException,
	SQLException, IOException {
		ArrayList<Event> eventList = new ArrayList<Event>();
		try {
			statement = connection.prepareStatement(sqlQuery);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Event event = EventMapper.map(resultSet);
				eventList.add(event); 
			}
			resultSet.close();
			
		} catch (Exception e) {
			System.out.println("Error en EventDao "+e.getMessage());
			System.out.println("sqlQuery: " + sqlQuery);
		}
		
		return eventList;
	}

	
	public ArrayList<Event> showAllEvents() throws ClassNotFoundException,
	SQLException, IOException {
		
		return requestEventList(databaseHelper.getQuery("alleventsandplaces"));
	}
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,SQLException, IOException {
		return requestEventList(databaseHelper.getQuery("museum"));
	}
	
	
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(databaseHelper.getQuery("zoo"));
	}

	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(databaseHelper.getQuery("park"));
	}

	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(databaseHelper.getQuery("theater"));
	}

	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(databaseHelper.getQuery("stadium"));
	}

	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(databaseHelper.getQuery("large_business"));
	}

	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(databaseHelper.getQuery("tourist_attraction"));
	}

	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException,
	SQLException, IOException {
	
		return requestEventList(databaseHelper.getQuery("traditional_market"));
	}
	

	public Event showEventById (int id) throws ClassNotFoundException, SQLException, IOException{

		statement = connection.prepareStatement(databaseHelper.getQuery("eventbyid"));
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
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("insert_events"));
			System.out.println(databaseHelper.getQuery("insert_events"));
			preparedStatement.setString(1,insertEvent.getEventName());
			preparedStatement.setString(2,insertEvent.getDescription());
			preparedStatement.setString(3,insertEvent.getStart());
			preparedStatement.setString(4,insertEvent.getEnd());
			preparedStatement.setString(5,insertEvent.getEventType());
			preparedStatement.setFloat(6, insertEvent.getTicketPrice());
			preparedStatement.setInt(7,insertEvent.getSeatsAvailable());
			preparedStatement.setInt(8,insertEvent.getSeatsTotal());
			preparedStatement.setInt(9,insertEvent.getPlace().getId());
			
			
			affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedRows;
	}

	@Override
	public int deleteEvent(int eventId) {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("delete_event"));
		    preparedStatement.setInt(1, eventId);	 
		    affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

	@Override
	public int updateEvent(Event updateEvent) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("update_infoevents"));
			preparedStatement.setString(1,updateEvent.getEventName());
			preparedStatement.setString(2,updateEvent.getDescription());
			preparedStatement.setString(3,updateEvent.getStart());
			preparedStatement.setString(4,updateEvent.getEnd());
			preparedStatement.setString(5,updateEvent.getEventType());
			preparedStatement.setFloat(6, updateEvent.getTicketPrice());
			preparedStatement.setInt(7,updateEvent.getSeatsAvailable());
			preparedStatement.setInt(8,updateEvent.getSeatsTotal());
			preparedStatement.setInt(9,updateEvent.getPlace().getId());
			preparedStatement.setInt(10, updateEvent.getEventId());
		    affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

	@Override
	public int updateSeatsEventDec(int eventId) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("update_seats_event_dec"));
		    preparedStatement.setInt(1, eventId);	 
		    affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

	@Override
	public int updateSeatsEventInc(int eventId) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("update_seats_event_inc"));
		    preparedStatement.setInt(1, eventId);	 
		    affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

}