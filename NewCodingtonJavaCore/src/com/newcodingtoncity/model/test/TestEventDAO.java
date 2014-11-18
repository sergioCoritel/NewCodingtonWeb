package com.newcodingtoncity.model.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Museum;

public class TestEventDAO {
	public static void main(String[] args) throws IOException {
		DAOManager daoManager = new DAOManager();
		testListParkEvents(daoManager);
		testInsertEvent(daoManager);
		daoManager.closeConnectionWithCommit();
	}



	private static void testInsertEvent(DAOManager daoManager) {
		Event insertEvent = new Event();
		insertEvent.setEventName("Evento1");
		insertEvent.setDescription("Descripcion");
		insertEvent.setStart("2014-02-01");
		insertEvent.setEnd("2014-02-01");
		insertEvent.setSeatsAvailable(100);
		insertEvent.setTicketPrice(10);
		Museum museum = new Museum();
		museum.setId(1991);
		museum.setCapacity(100);
		museum.setName("Museo prueba");
		museum.setPlaceDescription("desc museo prueba");
		museum.setStart("2014-01-01");
		museum.setEnd("2014-02-01");
		insertEvent.setPlace(museum);
		int rowsAffected = daoManager.getEventDAO().insertEvent(insertEvent);
		System.out.println("InsertEvent: numrRowsAffected");
		System.out.println(rowsAffected);
	}



	private static void testListParkEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showParkEvents();
			System.out.println("ListParkEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println("primer resultado: "+eventList.get(i).getEventName());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
