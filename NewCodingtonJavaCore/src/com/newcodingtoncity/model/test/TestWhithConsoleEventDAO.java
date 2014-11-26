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
//		testInsertEvent(daoManager);
//		testUpdateEvent(daoManager);
//		testUpdateSeatsEventInc(daoManager);
//		testUpdateSeatsEventDec(daoManager);
//		testDeleteEvent(daoManager);
		testEventId(daoManager);
//		testListMuseumEvents(daoManager);
//		testListZooEvents(daoManager);
//		testListMuseumEvents(daoManager);
//		testListZooEvents(daoManager);
//		testListParkEvents(daoManager);
//		testListTheaterEvents(daoManager);
//		testListStadiumEvents(daoManager);
//		testListLargeBusinessEvents(daoManager);
//		testListTouristAttractionEvents(daoManager);
//		testListTraditionalMarketEvents(daoManager);
		daoManager.closeConnectionWithCommit();
	}

	private static void testEventId(DAOManager daoManager) {
		 try {
			Event event = daoManager.getEventDAO().showEventById(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Event getFakeMuseumEvent(){
		Event insertEvent = new Event();
		insertEvent.setEventName("EventoPruebaaaa");
		insertEvent.setDescription("Descripcion 1991");
		insertEvent.setStart("2014-02-0+1");
		insertEvent.setEnd("2014-02-01");
		insertEvent.setEventType("SPORTS");
		insertEvent.setSeatsAvailable(100);
		insertEvent.setSeatsTotal(100);
		insertEvent.setTicketPrice(100);
		insertEvent.setTicketPrice(10);
		Museum museum = new Museum();
		museum.setId(9);
		museum.setCapacity(100);
		museum.setName("Museo prueba");
		museum.setPlaceDescription("desc museo prueba");
		museum.setStart("2014-01-01");
		museum.setEnd("2014-02-01");
		insertEvent.setPlace(museum);
		return insertEvent;
	}
	

	private static void testInsertEvent(DAOManager daoManager) {
		int rowsAffected = daoManager.getEventDAO().insertEvent(getFakeMuseumEvent());
		System.out.println("InsertEvent: numrRowsAffected");
		System.out.println(rowsAffected);
	}

	
	private static void testUpdateEvent(DAOManager daoManager) {	
		try {
			Event updateEvent = getFakeMuseumEvent();
			updateEvent.setEventId(1);
			int rowsAffected;
			rowsAffected = daoManager.getEventDAO().updateEvent(updateEvent);
			System.out.println("UpdateEvent: numrRowsAffected");
			System.out.println(rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private static void testUpdateSeatsEventInc(DAOManager daoManager) {
		try {
			int rowsAffected = daoManager.getEventDAO().updateSeatsEventInc(1);
			System.out.println("UpdateSeatsEventInc: numrRowsAffected");
			System.out.println(rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testUpdateSeatsEventDec(DAOManager daoManager) {
		try {
			int rowsAffected = daoManager.getEventDAO().updateSeatsEventDec(22);
			System.out.println("UpdateSeatsEventDec: numrRowsAffected");
			System.out.println(rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testDeleteEvent(DAOManager daoManager) {
		try {
			int rowsAffected = daoManager.getEventDAO().deleteEvent(22);
			System.out.println("DeleteEvent: numrRowsAffected");
			System.out.println(rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
