package com.newcodingtoncity.model.domain.places;


/**
 * Theater POJO class for domain model 
 */
public class Theater extends Building {

	public Theater(){
		super.setZone(Zone.NORTH);
	}
	
	public Theater(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.NORTH);
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}

	

	
}
