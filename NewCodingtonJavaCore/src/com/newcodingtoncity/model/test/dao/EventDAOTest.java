package com.newcodingtoncity.model.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.daos.EventDAO;
import com.newcodingtoncity.model.daos.PlaceDAO;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Museum;


public class EventDAOTest extends TestCase {

	Connection connection;
	EventDAO eventDAO;
	PlaceDAO placeDAO;
	Event event1;
	DAOManager daoManager;
	
	
	protected void setUp() throws Exception {
		super.setUp();
		daoManager = new DAOManager();
		eventDAO = (EventDAO) daoManager.getEventDAO();
		placeDAO = (PlaceDAO) daoManager.getPlaceDAO();
		
		event1 = new Event();
		event1.setEventName("Event1");
		event1.setDescription("Description");
		event1.setStart("2014-02-01");
		event1.setEnd("2014-02-01");
		event1.setSeatsAvailable(100);
		event1.setTicketPrice(10);
		event1.setPlace(createMuseum());
		daoManager.getEventDAO().insertEvent(event1);				//Insert the event in DB
	}
	
	
	protected void tearDown() throws Exception {	
		super.tearDown();		
		daoManager.closeConnectionWithCommit();
	}
	
	
	public Event createNewEvent() {
		Event insertEvent = new Event();
		insertEvent.setEventName("Evento1");
		insertEvent.setDescription("Descripcion");
		insertEvent.setStart("2014-02-01");
		insertEvent.setEnd("2014-02-01");
		insertEvent.setSeatsAvailable(100);
		insertEvent.setTicketPrice(10);
		Museum museum = createMuseum();
		insertEvent.setPlace(museum);
		return insertEvent;
	}
	
	
	
	
	private Museum createMuseum() {
		Museum museum = new Museum();
		museum.setId(1);
		museum.setCapacity(100);
		museum.setName("Museo prueba");
		museum.setPlaceDescription("desc museo prueba");
		museum.setStart("2014-01-01");
		museum.setEnd("2014-02-01");
		return museum;
	}
	
	
	/**
	 * Find last event inserted in DB
	 * @return the last event inserted
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	private Event lastEventInserted() throws ClassNotFoundException, SQLException, IOException{
		Event lastEvent = null;
		try {
			ArrayList<Event> events = eventDAO.showAllEvents();
			lastEvent = events.get(events.size()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastEvent;
	}
	
	
	@Test
	public void testShowAllEvents() throws ClassNotFoundException, SQLException, IOException {
		Event event1 = lastEventInserted();
			
		assertEquals(event1.getEventName(), this.event1.getEventName());
		assertEquals(event1.getDescription(), this.event1.getDescription());
	}
	
	/*
	@Test
	public void testShowMuseumEvents() throws ClassNotFoundException, SQLException, IOException{
		
		
		ArrayList<Event> eventList = daoManager.getEventDAO().showMuseumEvents();
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			System.out.println(eventList.get(i).getPlace().getPlaceDescription());
			}
	}*/
	
	
	@Test
	public void testUpdateEvent() {	
		try {
			Event updateEvent = createNewEvent();
			updateEvent.setEventId(1);
			eventDAO.updateEvent(updateEvent);
			daoManager.getEventDAO().updateEvent(event1);
			int rowsAffected = daoManager.getEventDAO().updateEvent(updateEvent);
			assertEquals(1, rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testDeleteEvent() throws ClassNotFoundException, SQLException, IOException {
		Event event1 = lastEventInserted();
		int rowsAffected = daoManager.getEventDAO().deleteEvent(event1.getEventId());		//Delete the last Event inserted
		assertEquals(1, rowsAffected);
	}
	
	
	@Test
    public void testUpdateSeatsEventDec() throws ClassNotFoundException, SQLException, IOException {
		int rowsAffected = daoManager.getEventDAO().updateSeatsEventDec(15);
		assertEquals(1, rowsAffected);
	}
    
	
	@Test
    public void testUpdateSeatsEventInc() throws ClassNotFoundException, SQLException, IOException {
		int rowsAffected = daoManager.getEventDAO().updateSeatsEventInc(15);
		assertEquals(1, rowsAffected);
	}
	
	
	
}
