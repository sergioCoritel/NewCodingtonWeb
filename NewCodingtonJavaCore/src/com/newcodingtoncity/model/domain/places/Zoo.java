package com.newcodingtoncity.model.domain.places;



/**
 * Zoo class that is composed of SAFARI object
 */
public class Zoo extends Place {

	public Zoo(){
		super.setZone(Zone.SOUTH);
	}

	public Zoo(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.SOUTH);
	}




	// GETTER and SETTER methods for ZOO Data fields

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub

	}

}
