package com.newcodingtoncity.model.domain.places;

import java.io.File;



/**
 * Zoo class that is composed of SAFARI object
 */
public class Zoo extends Place {
	
	public static final int ID_TYPE_OF_PLACE = 8;

	public Zoo(){
		super.setZone(Zone.SOUTH);
	}

	public Zoo(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.SOUTH);
	}




	// GETTER and SETTER methods for ZOO Data fields

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub

	}

}
