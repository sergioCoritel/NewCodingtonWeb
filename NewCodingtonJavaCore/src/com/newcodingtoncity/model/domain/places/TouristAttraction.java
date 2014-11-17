package com.newcodingtoncity.model.domain.places;

import java.io.File;


public class TouristAttraction extends Place {
	
	public TouristAttraction(){
		super.setZone(Zone.SOUTH);
	}
	
	public TouristAttraction(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.SOUTH);
		
	}

	@Override
	public void showEvents() {
		
		
	}

}
