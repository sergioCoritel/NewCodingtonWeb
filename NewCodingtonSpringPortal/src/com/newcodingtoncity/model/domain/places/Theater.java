package es.codington.model.domain.places;

import java.io.File;


/**
 * Theater POJO class for domain model 
 */
public class Theater extends Building {
	
	public static final int ID_TYPE_OF_PLACE = 5;
	
	public Theater(){
		super.setZone(Zone.NORTH);
	}
	
	public Theater(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.NORTH);
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}

	

	
}
