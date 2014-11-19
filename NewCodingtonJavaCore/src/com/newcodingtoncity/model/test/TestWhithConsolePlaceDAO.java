package com.newcodingtoncity.model.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;

public class TestWhithConsolePlaceDAO {
	public static void main(String[] args) throws IOException {
		DAOManager daoManager = new DAOManager();
		testListMuseums(daoManager);
		testListZoos(daoManager);
		testListParks(daoManager);
		testListTheaters(daoManager);
		testListStadiums(daoManager);
		testListLargeBusiness(daoManager);
		testListTouristAttractions(daoManager);
		testListTraditionalMarkets(daoManager);
		daoManager.closeConnectionWithCommit();
	}



//	private static void testInsertMuseum(DAOManager daoManager) {
//		Museum museum = new Museum();
//		museum.setId(1991);
//		museum.setCapacity(100);
//		museum.setName("Museo prueba");
//		museum.setPlaceDescription("desc museo prueba");
//		museum.setStart("2014-01-01");
//		museum.setEnd("2014-02-01");
//		int rowsAffected = daoManager.getPlaceDAO().insertMuseum(museum);
//		System.out.println("InsertEvent: numrRowsAffected");
//		System.out.println(rowsAffected);
//	}



	private static void testListMuseums(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Museum> museumList = daoManager.getPlaceDAO().showMuseums();
			System.out.println("ListMuseums:");
			for(int i=0; i<museumList.size();i++){
				System.out.println(museumList.get(i).getId()+" "+museumList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	private static void testListZoos(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Zoo> zooList = daoManager.getPlaceDAO().showZoos();
			System.out.println("ListZoos:");
			for(int i=0; i<zooList.size();i++){
				System.out.println(zooList.get(i).getId()+" "+zooList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListParks(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Park> parkList = daoManager.getPlaceDAO().showParks();
			System.out.println("ListParks:");
			for(int i=0; i<parkList.size();i++){
				System.out.println(parkList.get(i).getId()+" "+parkList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	private static void testListTheaters(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Theater> theatersList = daoManager.getPlaceDAO().showTheaters();
			System.out.println("ListTheaters:");
			for(int i=0; i<theatersList.size();i++){
				System.out.println(theatersList.get(i).getId()+" "+theatersList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	private static void testListStadiums(DAOManager daoManager) throws IOException {
		try {
			ArrayList<Stadium> stadiumsList = daoManager.getPlaceDAO().showStadiums();
			System.out.println("ListStadiums:");
			for(int i=0; i<stadiumsList.size();i++){
				System.out.println(stadiumsList.get(i).getId()+" "+stadiumsList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	private static void testListLargeBusiness(DAOManager daoManager) throws IOException {
		try {
			ArrayList<LargeBusiness> largeBusinessList = daoManager.getPlaceDAO().showLargeBusiness();
			System.out.println("ListLargeBusiness:");
			for(int i=0; i<largeBusinessList.size();i++){
				System.out.println(largeBusinessList.get(i).getId()+" "+largeBusinessList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	private static void testListTouristAttractions(DAOManager daoManager) throws IOException {
		try {
			ArrayList<TouristAttraction> touristAttractionList = daoManager.getPlaceDAO().showTouristAttractions();
			System.out.println("ListTouristAttractions:");
			for(int i=0; i<touristAttractionList.size();i++){
				System.out.println(touristAttractionList.get(i).getId()+" "+touristAttractionList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	private static void testListTraditionalMarkets(DAOManager daoManager) throws IOException {
		try {
			ArrayList<TraditionalMarket> traditionalMarketList = daoManager.getPlaceDAO().showTraditionalMarkets();
			System.out.println("ListTraditionalMarkets:");
			for(int i=0; i<traditionalMarketList.size();i++){
				System.out.println(traditionalMarketList.get(i).getId()+" "+traditionalMarketList.get(i).getName() );
			}
		} catch (Exception e) {
			e.printStackTrace();
			daoManager.closeConnectionWithRollback();
		}
	}
	
	
	

}
