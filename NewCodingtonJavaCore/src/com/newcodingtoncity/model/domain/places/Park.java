package com.newcodingtoncity.model.domain.places;


/**
 * POJO class for PARK domain model
 */
public class Park extends Place {
	
	public Park(){
		super.setZone(Zone.SOUTH);
	}
	
	public Park(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.SOUTH);
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
