package com.newcodingtoncity.model.interfaces.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;

public interface IEventSignUpDAO {
	
	/**
	 * 
	 * @param e
	 * @return number of rows affected if register was successful 
	 */
	public int registerVisitorForNewEvent(EventSignUp e);
	
	
	/**
	 * 
	 * @param e
	 * @return number of rows affected if unregister was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int unregisterVisitorForEvent(EventSignUp e);
	
	
	/**
	 * 
	 * @param e
	 * @return number of rows affected if user could delete an event successful
	 */
	public int deleteEventFromEventSignUp(EventSignUp e);
	
	
	/**
	 * 
	 * @param e
	 * @return true if visitor is registered to an event
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isVisitorRegisteredToEvent(EventSignUp e);


	/**
	 * 
	 * @param e
	 * @return list of event of a visitor 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Event> viewEventsOfUser(EventSignUp e) throws SQLException;
	
	
	/**
	 * 
	 * @param resultSet
	 * @return list of all events
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Event> showAllEvents(ResultSet resultSet)  throws SQLException;
	
}
