package com.newcodingtoncity.model.domain.places;


public class TouristAttraction extends Place {
	
	public TouristAttraction(){
		super.setZone(Zone.SOUTH);
	}
	
	public TouristAttraction(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.SOUTH);
		
	}

	@Override
	public void showEvents() {
		
		
	}

}
