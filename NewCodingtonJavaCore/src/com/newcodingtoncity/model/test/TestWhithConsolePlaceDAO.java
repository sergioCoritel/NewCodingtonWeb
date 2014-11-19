package com.newcodingtoncity.model.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Zoo;

public class TestWhithConsolePlaceDAO {
	public static void main(String[] args) throws IOException {
		DAOManager daoManager = new DAOManager();
		testListMuseums(daoManager);
		testListZoos(daoManager);
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

}
