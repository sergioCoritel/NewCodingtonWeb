package com.newcodingtoncity.model.interfaces.daos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;



public interface IEventSignUpDAO {

	/**
	 * 
	 * @param e
	 * @return number of rows affected if register was successful 
	 */
	public int registerVisitorForNewEventDAO(EventSignUp e);



	/**
	 * 
	 * @param e
	 * @return number of rows affected if register was successful 
	 */
	public boolean IsRegisteredToEvent(EventSignUp e);

	/**
	 * 
	 * @param e
	 * @return number of rows affected if unregister was successful
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int unregisterVisitorForEventDAO(EventSignUp e);


	/**
	 * 
	 * @param e
	 * @return number of rows affected if user could delete an event successful
	 */
	public int deleteEventFromEventSignUpDAO(EventSignUp e);

	/**
	 * 
	 * @param e
	 * @return list of event of a eventvisitor 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Event> viewEventsOfUserDAO(EventSignUp e) throws SQLException;


	/**
	 * 
	 * @param resultSet
	 * @return list of all events
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public int updateRestSeatsAvailableEvent(EventSignUp e);
	public int updateSumSeatsAvailableEvent(EventSignUp e);
	public boolean checkSeatsAvailableDAO(EventSignUp e);




}
