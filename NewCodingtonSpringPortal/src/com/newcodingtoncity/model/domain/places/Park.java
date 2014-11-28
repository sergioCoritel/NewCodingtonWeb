package es.codington.model.domain.places;

import java.io.File;


/**
 * POJO class for PARK domain model
 */
public class Park extends Place {
	
	public static final int ID_TYPE_OF_PLACE = 3;
	
	public Park(){
		super.setZone(Zone.SOUTH);
	}
	
	public Park(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.SOUTH);
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
