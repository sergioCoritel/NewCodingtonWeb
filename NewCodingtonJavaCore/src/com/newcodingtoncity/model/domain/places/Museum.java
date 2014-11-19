package com.newcodingtoncity.model.domain.places;

import java.io.File;


/**
 * MUSEUM class inherits common behavior from BUILDING class
 * and has its own properties "type"
 */
public class Museum extends Building {
	
	public static final int ID_TYPE_OF_PLACE = 2;
	
	public Museum(){
		super.setZone(Zone.NORTH);
	}
	
	public Museum(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.NORTH);
	}

	@Override
	public void showEvents() {
		
	}	
}
