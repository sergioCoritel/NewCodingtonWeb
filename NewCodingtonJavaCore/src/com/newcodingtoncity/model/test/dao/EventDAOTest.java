package com.newcodingtoncity.model.test.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import junit.framework.TestCase;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.daos.EventDAO;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Museum;

public class EventDAOTest extends TestCase {

	Connection connection;
	EventDAO eventDAO;       
	Event insertEvent;
	DAOManager daoManager;

	protected void setUp() throws Exception {
		super.setUp();
		daoManager = new DAOManager();
		eventDAO = (EventDAO) daoManager.getEventDAO();
		insertEvent = createNewEvent();
		int rowsAffected = eventDAO.insertEvent(insertEvent);
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
		museum.setId(1991);
		museum.setCapacity(100);
		museum.setName("Museo prueba");
		museum.setPlaceDescription("desc museo prueba");
		museum.setStart("2014-01-01");
		museum.setEnd("2014-02-01");
		return museum;
	}

	public void testShowAllEvents() throws ClassNotFoundException, SQLException, IOException {

		ArrayList<Event> events = eventDAO.showAllEvents();
		Event event1 = events.get(0);
		Event event2 = events.get(1);

		assertEquals(event1, this.insertEvent);

//		try {
//			FERSDataConnection.closeConnection(connection);
//			events = eventDAO.showAllEvents();
//			fail("Conexion cerrada");
//		} catch(DAOException ex) {}
	}


	
}
