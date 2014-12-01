package com.newcodingtoncity.model.daos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.mappers.EventMapper;
import com.newcodingtoncity.model.mappers.EventSignUpMapper;

public class EventSignUpDAO implements IEventSignUpDAO{

	private JdbcTemplate jdbcTemplateObject;
	private Properties queryProperties;

	public EventSignUpDAO(JdbcTemplate jdbcTemplateObject,Properties queryProperties ) {
		this.jdbcTemplateObject = jdbcTemplateObject;
		this.queryProperties = queryProperties;
	} 

	@Override
	public boolean IsRegisteredToEvent(final EventSignUp e){
		List<EventSignUp> eventSignUp =  jdbcTemplateObject.query(queryProperties.getProperty("IsRegisteredToEvent"),new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setInt(1, e.getEventId());
				statement.setInt(2, e.getVisitorId());
			}
		}, new EventSignUpMapper());
		return eventSignUp.size() >= 1;

	}

	@Override
	public int registerVisitorForNewEventDAO(final EventSignUp e){
		int affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("registerVisitorToEvent"), 
				new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setInt(1, e.getEventId());
				statement.setInt(2, e.getVisitorId());
			}
		});
		return affectedRows;
	}

	@Override
	public int unregisterVisitorForEventDAO(final EventSignUp e){
		int affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("unRegisterVisitorToEvent"), 
				new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement statement)
					throws SQLException {
				statement.setInt(1, e.getEventId());
				statement.setInt(2, e.getVisitorId());
			}
		});   		
		return affectedRows;
	}

	@Override
	public int updateRestSeatsAvailableEvent(EventSignUp e){
		return jdbcTemplateObject.update(queryProperties.getProperty("update_seats_event_dec"), e.getEventId());
	}

	@Override
	public int updateSumSeatsAvailableEvent(EventSignUp e){
		return jdbcTemplateObject.update(queryProperties.getProperty("update_seats_event_inc"), e.getEventId());
	} 

	@Override
	public boolean checkSeatsAvailableDAO(EventSignUp e){
		List<Integer> seatsAvailable = jdbcTemplateObject.query(queryProperties.getProperty("seats_available_event"),new Object[]{e.getEventId()},new RowMapper<Integer>(){
			@Override
			public Integer mapRow(ResultSet resultSet, int numRow) throws SQLException {	
				return resultSet.getInt("seats_available");
			}

		});
		return seatsAvailable.get(0)>0;
	}

	@Override
	public int deleteEventFromEventSignUpDAO(EventSignUp e) {
		return jdbcTemplateObject.update(queryProperties.getProperty("deleteEventFromEventSignup"), e.getEventId());
	}


	@Override
	public List<Event> viewEventsOfUserDAO(EventSignUp e) throws SQLException {
		return jdbcTemplateObject.query(queryProperties.getProperty("events_of_one_user"),new Object[]{e.getVisitorId()},new EventMapper());	
	}


}
