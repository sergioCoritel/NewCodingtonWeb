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
		
		return requestEventList(DatabaseHelper.getQuery("allevents"));
	}
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,SQLException, IOException {
		return requestEventList(DatabaseHelper.getQuery("museum"));
	}
	

	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(DatabaseHelper.getQuery("zoo"));
	}

	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(DatabaseHelper.getQuery("park"));
	}

	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(DatabaseHelper.getQuery("teather"));
	}

	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(DatabaseHelper.getQuery("stadium"));
	}

	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(DatabaseHelper.getQuery("largeBusiness"));
	}

	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(DatabaseHelper.getQuery("touristAttraction"));
	}

	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException,
	SQLException, IOException {
	
		return requestEventList(DatabaseHelper.getQuery("traditionalMarket"));
	}
	

	public Event showEventById (int id) throws ClassNotFoundException, SQLException, IOException{

		statement = connection.prepareStatement(DatabaseHelper.getQuery("eventbyid"));
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
			preparedStatement = connection.prepareStatement(DatabaseHelper.getQuery("insertevent"));
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