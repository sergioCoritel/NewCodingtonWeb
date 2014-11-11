package com.newcodingtoncity.model.domain.places;


/**
 * MUSEUM class inherits common behavior from BUILDING class
 * and has its own properties "type"
 */
public class Museum extends Building {
	
	public Museum(){
		super.setZone(Zone.NORTH);
	}
	
	public Museum(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.NORTH);
	}

	@Override
	public void showEvents() {
		
	}	
}
