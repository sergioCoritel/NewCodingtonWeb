package com.newcodingtoncity.model.domain.places;

import java.io.File;



/**
 * class STADIUM takes properties BUILDING
 */
public class Stadium extends Building {
	
	public Stadium(){
		super.setZone(Zone.NORTH);
	}

	public Stadium(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, File image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.NORTH);
	}
	
	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
