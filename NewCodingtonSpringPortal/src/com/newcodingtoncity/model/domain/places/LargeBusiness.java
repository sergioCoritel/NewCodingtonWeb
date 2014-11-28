package es.codington.model.domain.places;

import java.io.File;



public class LargeBusiness extends Building{
	
	public static final int ID_TYPE_OF_PLACE = 1;
	
	public LargeBusiness(){
		super.setZone(Zone.NORTH);
	}
	
	public LargeBusiness(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.NORTH);
	}
	
	

	@Override
	public void showEvents() {}

}
