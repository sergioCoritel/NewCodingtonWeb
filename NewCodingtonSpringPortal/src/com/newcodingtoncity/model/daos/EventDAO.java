package com.newcodingtoncity.model.daos;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.mappers.EventMapper;

public class EventDAO implements IEventDAO {

	private JdbcTemplate jdbcTemplateObject;
	private Properties queryProperties;
	
	public EventDAO(JdbcTemplate jdbcTemplateObject,Properties queryProperties ) {
	    this.jdbcTemplateObject = jdbcTemplateObject;
	    this.queryProperties = queryProperties;
	} 
	

	public ArrayList<Event> requestEventList(String sqlQuery) throws ClassNotFoundException,
	SQLException, IOException {
		ArrayList<Event> eventList = new ArrayList<Event>();
		eventList = (ArrayList<Event>) jdbcTemplateObject.query(sqlQuery, 
                new EventMapper());
		return eventList;
	}

	
	public ArrayList<Event> showAllEvents() throws ClassNotFoundException,
	SQLException, IOException {
		return requestEventList(queryProperties.getProperty("alleventsandplaces"));
	}
	
	public ArrayList<Event> showMuseumEvents() throws ClassNotFoundException,SQLException, IOException {
		return requestEventList(queryProperties.getProperty("museum"));
	}
	
	
	public ArrayList<Event> showZooEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(queryProperties.getProperty("zoo"));
	}

	public ArrayList<Event> showParkEvents() throws ClassNotFoundException,SQLException, IOException {
		

		return requestEventList(queryProperties.getProperty("park"));
	}

	public ArrayList<Event> showTheaterEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(queryProperties.getProperty("theater"));
	}

	public ArrayList<Event> showStadiumEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(queryProperties.getProperty("stadium"));
	}

	public ArrayList<Event> showLargeBusinessEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(queryProperties.getProperty("large_business"));
	}

	public ArrayList<Event> showTouristAttractionEvents() throws ClassNotFoundException,SQLException, IOException {

		return requestEventList(queryProperties.getProperty("tourist_attraction"));
	}

	public ArrayList<Event> showTraditionalMarketEvents() throws ClassNotFoundException,
	SQLException, IOException {
	
		return requestEventList(queryProperties.getProperty("traditional_market"));
	}
	

	public Event showEventById (int id) throws ClassNotFoundException, SQLException, IOException{
		Event event = jdbcTemplateObject.queryForObject(queryProperties.getProperty("eventbyid"), 
                    new Object[]{id}, new EventMapper());
		return event;
	}

	@Override
	public int insertEvent(final Event insertEvent) {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("insert_events"), 
				 new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement)
						throws SQLException {
					preparedStatement.setString(1,insertEvent.getEventName());
					preparedStatement.setString(2,insertEvent.getDescription());
					preparedStatement.setString(3,insertEvent.getStart());
					preparedStatement.setString(4,insertEvent.getEnd());
					preparedStatement.setString(5,insertEvent.getEventType());
					preparedStatement.setFloat(6, insertEvent.getTicketPrice());
					preparedStatement.setInt(7,insertEvent.getSeatsAvailable());
					preparedStatement.setInt(8,insertEvent.getSeatsTotal());
					preparedStatement.setInt(9,insertEvent.getPlace().getId());
				}
					
				});
			   
		return affectedRows;
	}

	@Override
	public int deleteEvent(int eventId) {
		return jdbcTemplateObject.update(queryProperties.getProperty("delete_event"), eventId);
	
	}

	@Override
	public int updateEvent(final Event updateEvent) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("update_infoevents"), 
				 new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement)
						throws SQLException {
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
				}
				
		});
		return affectedRows;
	}

	@Override
	public int updateSeatsEventDec(int eventId) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("update_seats_event_dec"),eventId);
		return affectedRows;
	}

	@Override
	public int updateSeatsEventInc(int eventId) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("update_seats_event_inc"),eventId);
		return affectedRows;
	}

}