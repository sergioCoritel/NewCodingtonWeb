package com.newcodingtoncity.model.interfaces.daos;

<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Place;

public interface IPlaceDAO {
	
	public void changeImage(int id, File image) throws FileNotFoundException, SQLException;
=======
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.helper.DatabaseHelper;

public interface IPlaceDAO {
	
	public ArrayList<Museum> showMuseums() throws ClassNotFoundException,SQLException, IOException ;
	public ArrayList<Zoo> showZoos() throws ClassNotFoundException,SQLException, IOException ;
	public ArrayList<Park> showParks() throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<Theater> showTheaters() throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<Stadium> showStadiums() throws ClassNotFoundException,SQLException, IOException ;
	public ArrayList<LargeBusiness> showLargeBusiness() throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<TouristAttraction> showTouristAttractions() throws ClassNotFoundException,SQLException, IOException;
	public ArrayList<TraditionalMarket> showTraditionalMarkets() throws ClassNotFoundException,SQLException, IOException;
	public int deletePlace(int placeId, int typeId) ;

>>>>>>> eventDao y placeDao
}
