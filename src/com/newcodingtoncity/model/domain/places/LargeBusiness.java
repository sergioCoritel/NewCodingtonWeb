package com.newcodingtoncity.model.domain.places;



public class LargeBusiness extends Building{
	
	public LargeBusiness(){
		super.setZone(Zone.NORTH);
	}
	
	public LargeBusiness(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.NORTH);
	}
	
	

	@Override
	public void showEvents() {}

}
