package com.newcodingtoncity.model.daos;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.mappers.EventMapper;
import com.newcodingtoncity.model.mappers.EventSignUpMapper;

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
	public boolean checkEventsofVisitorDAO(EventSignUp e){
		int fila =0;
		try{	
			String sql  = databaseHelper.getQuery("eventsusersFilterEventsUsers");
			statement = connection.prepareStatement(sql);
			statement.setInt(1, e.getEventId());
			statement.setInt(2, e.getVisitorId());

			resultSet = statement.executeQuery();
			
			resultSet.last();
			fila = resultSet.getRow();
			resultSet.beforeFirst();
			
			//System.out.println("Existe la fila: "+ fila);	
				
		}catch(Exception eee){
			eee.getMessage();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}
				
			}catch (Exception ee) {
				System.out.println(" EventSignUpCheck "+ ee.getMessage());
				return false;
			}

		} 
			
		return fila==1;
	}
	
	@Override
	public int registerVisitorForNewEventDAO(EventSignUp e){

		int affectedRows = 0;

		try{	
			String sql  = databaseHelper.getQuery("registerVisitorToEvent");
			statement = connection.prepareStatement(sql);
			statement.setInt(1, e.getEventId());
			statement.setInt(2, e.getVisitorId());
			
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
			}catch (Exception ee) {
				System.out.println(" registerVisitorForNewEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}

	@Override
	public int updateRestSeatsAvailableEvent(EventSignUp e){
		
		int affectedRows = 0;
		try{	
			String sql  = databaseHelper.getQuery("update_rest_seats_events");

			statement = connection.prepareStatement(sql);
			statement.setInt(1, e.getEventId());
			
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
			}catch (Exception ee) {
				System.out.println(" registerVisitorForNewEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}

	@Override
	public int updateSumSeatsAvailableEvent(EventSignUp e){
		
		int affectedRows = 0;

		try{	
			String sql  = databaseHelper.getQuery("update_sum_seats_events");
			statement = connection.prepareStatement(sql);
			statement.setInt(1,e.getEventId());
			
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
			}catch (Exception ee) {
				System.out.println(" registerVisitorForNewEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}
	
	@Override
	public boolean checkSeatsForRestAvailableDAO(EventSignUp e){

		int seatsAvailables = 0;
		int seatsTotal = 0;
		try{	
			String sql  = databaseHelper.getQuery("event_for_id");
			statement = connection.prepareStatement(sql);
			statement.setInt(1, e.getEventId());

			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				seatsAvailables = resultSet.getInt(1);
				seatsTotal = resultSet.getInt(2);
			}
			
			//System.out.println("Disponibles"+seatsAvailables);
			//System.out.println("Totales"+seatsTotal);
		}catch(Exception eee){
			eee.getMessage();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}
				
			}catch (Exception ee) {
				System.out.println(" EventSignUpCheck "+ ee.getMessage());
				return false;
			}

		} 
			
		return (seatsAvailables>0 && seatsAvailables<=seatsTotal);
	}
	
	@Override
	public boolean checkSeatsForSumAvailableDAO(EventSignUp e){

		int seatsAvailables = 0;
		int seatsTotal = 0;
		try{	
			String sql  = databaseHelper.getQuery("event_for_id");
			statement = connection.prepareStatement(sql);
			statement.setInt(1, e.getEventId());

			resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				seatsAvailables = resultSet.getInt(1);
				seatsTotal = resultSet.getInt(2);
			}
			
			//System.out.println("Disponibles"+seatsAvailables);
			//System.out.println("Totales"+seatsTotal);
		}catch(Exception eee){
			eee.getMessage();
		}finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
					resultSet = null;
				}
				if (statement != null) {
					statement.close(); 
					statement = null;
				}
				
			}catch (Exception ee) {
				System.out.println(" EventSignUpCheck "+ ee.getMessage());
				return false;
			}

		} 
			
		return (seatsAvailables>=0 && seatsAvailables<seatsTotal);
	}
	
	@Override
	public int unregisterVisitorForEventDAO(EventSignUp e){
		int affectedRows = 0;

		try{		    		
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

			}catch (Exception ee) {
				System.out.println(" unregisterVisitorForEvent 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;
	}

	@Override
	public int deleteEventFromEventSignUpDAO(EventSignUp e) {

		int affectedRows = 0;

		try{		    		
			String sql  = databaseHelper.getQuery("deleteEventFromEventSignup");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getEventId());

			affectedRows = statement.executeUpdate();


		} catch (Exception ee) {
			System.out.println("deleteEventFromEventSignUpDAO 1: "+ ee.getMessage());
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
			}catch (Exception ee) {
				System.out.println(" deleteEventFromEventSignUpDAO 2: "+ ee.getMessage());
				return affectedRows;
			}

		} 

		return affectedRows;

	}

	public ArrayList<EventSignUp> showAllEventsUsersDAO() throws ClassNotFoundException,
	SQLException, IOException {
		return requestEventList(databaseHelper.getQuery("eventsusers"));
	}
	
	public ArrayList<Event> showAllEventsForOneUsersDAO(EventSignUp eventSignUp) throws ClassNotFoundException,
	SQLException, IOException{
		return requestEventList2(eventSignUp,databaseHelper.getQuery("events_of_one_user"));
	}
	
	public ArrayList<EventSignUp> requestEventList(String sqlQuery) throws ClassNotFoundException,
	SQLException, IOException {
		statement = connection.prepareStatement(sqlQuery);

		resultSet = statement.executeQuery();
		ArrayList<EventSignUp> eventUserList = new ArrayList<EventSignUp>();

		while (resultSet.next()) {
			EventSignUp eventUser = EventSignUpMapper.map(resultSet);
			eventUserList.add(eventUser); 
		}
		resultSet.close();
		return eventUserList;
	}

	public ArrayList<Event> requestEventList2(EventSignUp eventSignUp,String sqlQuery) throws ClassNotFoundException,
	SQLException, IOException {
		statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1,eventSignUp.getVisitorId() );	
		resultSet = statement.executeQuery();
		ArrayList<Event> eventList = new ArrayList<Event>();

		while (resultSet.next()) {
			Event eventUser = EventMapper.map(resultSet);
			eventList.add(eventUser); 
		}
		resultSet.close();
		return eventList;
	}
	
	@Override
	public List<Event> viewEventsOfUserDAO(EventSignUp e) throws SQLException {
		
		List<Event> events = new ArrayList<Event>();
		
		try{		    		

			//connection = CodingtonConnectToDB.createConnection();
			String sql  = databaseHelper.getQuery("eventsOfUser");
			statement = connection.prepareStatement(sql);

			statement.setInt(1, e.getVisitorId());
		    
		    resultSet =  statement.executeQuery();
		    
		    //events = this.showAllEventsDAO(resultSet);


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
			}catch (Exception ee) {
				System.out.println(" viewEventsOfUser 2: "+ ee.getMessage());
				return events;
			}

		} 

		return events;

	}


}
