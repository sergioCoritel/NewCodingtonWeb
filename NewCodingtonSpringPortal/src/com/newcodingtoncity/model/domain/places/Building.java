package es.codington.model.domain.places;

import java.io.File;


/**
 * Abstract class that governs behavior of STADIUM, THEATER and MUSEUM objects
 */
public abstract class Building extends Place {
	
	public Building(){}

	public Building(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param size
	 * method to calculate and showArea of different buildings
	 * that extends behavior from BUILDING classs
	 */
	
	
}
