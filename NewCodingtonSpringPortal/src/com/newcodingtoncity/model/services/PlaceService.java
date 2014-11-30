package com.newcodingtoncity.model.services;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.domain.places.TouristAttraction;
import com.newcodingtoncity.model.domain.places.TraditionalMarket;
import com.newcodingtoncity.model.domain.places.Zoo;
import com.newcodingtoncity.model.interfaces.daos.IEventDAO;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.interfaces.services.IPlaceService;

public class PlaceService implements IPlaceService{
	private IPlaceDAO placeDAO;

	public PlaceService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(  "beans.xml");  
		DAOManager daoManager = (DAOManager) ctx.getBean("daoManager");
		this.placeDAO = daoManager.getPlaceDAO();
	}
	public List<LargeBusiness> getLargeBusiness() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showLargeBusiness();

	}

	public List<Museum> getMuseums() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showMuseums();

	}

	public List<Park> getParks() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showParks();

	}

	public List<Stadium> getStadiums() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showStadiums();

	}

	public List<Theater> getTheaters() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showTheaters();

	}

	public List<TouristAttraction> getTouristAttractions() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showTouristAttractions();

	}

	public List<TraditionalMarket> getTraditionalMarkets() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showTraditionalMarkets();

	}

	public List<Zoo> getZoos() throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.showZoos();

	}

	public int insertPlace(Place place,int typeOfPlace){
		return placeDAO.insertPlace(place, typeOfPlace);

	}

	public int deletePlace(int placeId){
		return placeDAO.deletePlace(placeId);

	}

	public int updatePlace(Place place,int typeOfPlace) throws ClassNotFoundException, SQLException, IOException{
		return placeDAO.updatePlace(place, typeOfPlace);

	}
	@Override
	public void changeImage(int id, File image) throws ClassNotFoundException,
			SQLException, IOException {
//		return placeDAO.changeImage(id, image);
		
	}


}
