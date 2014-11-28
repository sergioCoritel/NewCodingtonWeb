package es.codington.model.domain.places;

import java.io.File;



public class TraditionalMarket extends Place{
	
	public static final int ID_TYPE_OF_PLACE = 7;
	
	public TraditionalMarket(){
		super.setZone(Zone.SOUTH);
	}
	
	public TraditionalMarket(int id,String name, int capacity,
			String placeDescription, String start, String end, Zone zone, File image) {
		super(id,name, capacity, placeDescription, start, end, zone, image);
		super.setZone(Zone.SOUTH);
	}

	@Override
	public void showEvents() {
		
	}

}
