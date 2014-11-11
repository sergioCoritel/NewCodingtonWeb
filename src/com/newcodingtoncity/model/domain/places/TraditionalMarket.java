package com.newcodingtoncity.model.domain.places;



public class TraditionalMarket extends Place{
	
	public TraditionalMarket(){
		super.setZone(Zone.SOUTH);
	}
	
	public TraditionalMarket(int id,String name, int capacity,
			String placeDescription, String workingHours, Zone zone, String image) {
		super(id,name, capacity, placeDescription, workingHours, zone, image);
		super.setZone(Zone.SOUTH);
	}

	@Override
	public void showEvents() {
		
	}

}
