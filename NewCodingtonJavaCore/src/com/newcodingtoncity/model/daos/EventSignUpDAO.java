package com.newcodingtoncity.model.daos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;

public class EventSignUpDAO implements IEventSignUpDAO{

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DatabaseHelper databaseHelper;


	public EventSignUpDAO(Connection connection, DatabaseHelper databaseHelper) {
		this.connection = connection;
		this.databaseHelper = databaseHelper;
	}


	@Override
	public boolean isVisitorRegisteredToEvent(EventSignUp e) {

		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("IsRegisteredToEvent");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getEventId());
			statement.setInt(2, e.getVisitorId());

			resultSet = statement.executeQuery();

			while (resultSet.next()){

			}

			if(resultSet.getRow()==0){
				return false;
			}

		} catch (Exception ee) {
			System.out.println("isVisitorRegisteredToEvent 1: "+ ee.getMessage());
			return false;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" isVisitorRegisteredToEvent 2: "+ ee.getMessage());
				return false;
			}

		} 

		return true;
	}


	@Override
	public int registerVisitorForNewEvent(EventSignUp e){

		int affectedRows = 0;

		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("registerVisitorToEvent");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getId());
			statement.setInt(2, e.getEventId());
			statement.setInt(3, e.getVisitorId());

			affectedRows = statement.executeUpdate();


		} catch (Exception ee) {
			System.out.println("registerVisitorForNewEvent 1: "+ ee.getMessage());
			return affectedRows;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" registerVisitorForNewEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}


	@Override
	public int unregisterVisitorForEvent(EventSignUp e){
		int affectedRows = 0;

		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("unRegisterVisitorToEvent");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getEventId());
			statement.setInt(2, e.getVisitorId());

			affectedRows = statement.executeUpdate();


		} catch (Exception ee) {
			System.out.println("unregisterVisitorForEvent 1: "+ ee.getMessage());
			return affectedRows;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" unregisterVisitorForEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}


	@Override
	public int deleteEventFromEventSignUp(EventSignUp e) {

		int affectedRows = 0;

		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("deleteEventFromEventSignup");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getEventId());

			affectedRows = statement.executeUpdate();


		} catch (Exception ee) {
			System.out.println("unregisterVisitorForEvent 1: "+ ee.getMessage());
			return affectedRows;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" unregisterVisitorForEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;

	}

	@Override
	public List<Event> showAllEvents(ResultSet resultSet)  throws SQLException {

		List<Event> events = new ArrayList<Event>();
		Event event = new Event();

		while(resultSet.next()) {

			event.setEventId(resultSet.getInt("id_event"));
			event.setEventName(resultSet.getString("name_event"));
			event.setDescription(resultSet.getString("description_event"));
			event.setStart(resultSet.getString("start_event"));
			event.setEnd(resultSet.getString("end_event"));
			event.setEventType(resultSet.getString("type_event"));
			event.setTicketPrice(resultSet.getInt("ticket_price"));
			event.setSeatsAvailable(resultSet.getInt("seats_available"));
			event.setSeatsTotal(resultSet.getInt("seats_total"));

			event.getPlace().setId(resultSet.getInt("id_place"));

			events.add(event);

		}

		return events;
	}           
	
	@Override
	public List<Event> viewEventsOfUser(EventSignUp e) throws SQLException {
		
		List<Event> events = new ArrayList<Event>();
		
		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("eventsOfUser");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getVisitorId());
		    
		    resultSet =  statement.executeQuery();
		    
		    events = this.showAllEvents(resultSet);


		} catch (Exception ee) {
			System.out.println("viewEventsOfUser 1: "+ ee.getMessage());
			return events;

		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}

				if (connection != null) {
					CodingtonConnectToDB.closeConnection(connection);
					connection = null;
				}
			}catch (Exception ee) {
				System.out.println(" viewEventsOfUser 2: "+ ee.getMessage());
				return events;
			}

		} 

		return events;

	}


}
