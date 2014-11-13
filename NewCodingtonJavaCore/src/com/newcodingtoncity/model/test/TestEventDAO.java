package com.newcodingtoncity.model.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;

public class TestEventDAO {
	public static void main(String[] args) {
		DAOManager daoManager = new DAOManager();
		testListAllEvents(daoManager);
//		testInsertEvent(daoManager);
		daoManager.closeConnection();
	}



//	private static void testInsertEvent(DAOManager daoManager) {
//		Event insertEvent = new Event();
//		insertEvent.setEventName("Evento1");
//		insertEvent.setDescription("Descripcion");
//		insertEvent.setDuration(50);
//		insertEvent.setSeatsAvailable(100);
//		insertEvent.setTicketPrice(10);
//		int rowsAffected = daoManager.getEventDAO().insertEvent(insertEvent);
//		System.out.println("InsertEvent: numrRowsAffected");
//		System.out.println(rowsAffected);
//	}



	private static void testListAllEvents(DAOManager daoManager) {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showParkEvents();
			System.out.println("ListAllEvents:");
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
