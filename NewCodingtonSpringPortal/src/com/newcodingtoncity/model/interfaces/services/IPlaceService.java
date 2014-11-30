package com.newcodingtoncity.model.interfaces.services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;

public interface IPlaceService {
	
	public List<LargeBusiness> getLargeBusiness() throws ClassNotFoundException, SQLException, IOException;
	public List<Museum> getMuseums()throws ClassNotFoundException, SQLException, IOException;
	public List<Park> getParks() throws ClassNotFoundException, SQLException, IOException;
	public List<Stadium> getStadiums() throws ClassNotFoundException, SQLException, IOException;
	public List<Theater> getTheaters() throws ClassNotFoundException, SQLException, IOException;
	public List<TouristAttraction> getTouristAttractions() throws ClassNotFoundException, SQLException, IOException;
	public List<TraditionalMarket> getTraditionalMarkets() throws ClassNotFoundException, SQLException, IOException;
	public List<Zoo> getZoos() throws ClassNotFoundException, SQLException, IOException;
	public int insertPlace(Place place,int typeOfPlace) throws ClassNotFoundException, SQLException, IOException;
	public int deletePlace(int placeId) throws ClassNotFoundException, SQLException, IOException;
	public int updatePlace(Place place,int typeOfPlace) throws ClassNotFoundException, SQLException, IOException;
	public void changeImage(int id, File image) throws ClassNotFoundException, SQLException, IOException;

}
