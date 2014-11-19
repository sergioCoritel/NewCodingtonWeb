package com.newcodingtoncity.model.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Museum;

public class TestWhithConsoleEventDAO {
	public static void main(String[] args) throws IOException {
		DAOManager daoManager = new DAOManager();
		testInsertEvent(daoManager);
		testListMuseumEvents(daoManager);
		testListZooEvents(daoManager);
		testListParkEvents(daoManager);
		testListTheaterEvents(daoManager);
		testListStadiumEvents(daoManager);
		testListLargeBusinessEvents(daoManager);
		testListTouristAttractionEvents(daoManager);
		testListTraditionalMarketEvents(daoManager);
		daoManager.closeConnectionWithCommit();
	}



	private static void testInsertEvent(DAOManager daoManager) {
		Event insertEvent = new Event();
		insertEvent.setEventName("Evento1991");
		insertEvent.setDescription("Descripcion 1991");
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
		System.out.println(insertEvent);
	}



	private static void testListMuseumEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showMuseumEvents();
			System.out.println("ListMuseumEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListZooEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showZooEvents();
			System.out.println("ListZooEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}

	
	private static void testListParkEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showParkEvents();
			System.out.println("ListParkEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	
	private static void testListTheaterEvents(DAOManager daoManager) throws IOException {
		try {
			System.out.println("E1");
			ArrayList<Event> eventList = daoManager.getEventDAO().showTheaterEvents();
			System.out.println("E2");
			System.out.println("ListTheaterEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListStadiumEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showStadiumEvents();
			System.out.println("ListStadiumEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListLargeBusinessEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showLargeBusinessEvents();
			System.out.println("ListLargeBusinessEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListTouristAttractionEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showTouristAttractionEvents();
			System.out.println("ListTouristAttractionEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListTraditionalMarketEvents(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Event> eventList = daoManager.getEventDAO().showTraditionalMarketEvents();
			System.out.println("ListTraditionalMarketEvents:");
			for(int i=0; i<eventList.size();i++){
				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
			}
		} catch (ClassNotFoundException e) {
			daoManager.closeConnectionWithRollback();
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	
	

}
