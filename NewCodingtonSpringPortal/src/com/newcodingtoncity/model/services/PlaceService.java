package es.codington.model.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.interfaces.services.IPlaceService;

public class PlaceService implements IPlaceService{
	
	public List<LargeBusiness> getLargeBusiness(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<LargeBusiness> largeBusiness = new ArrayList<LargeBusiness>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			largeBusiness = placeDAO.showLargeBusiness();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return largeBusiness;		
	}
	
	public List<Museum> getMuseums(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<Museum> museums = new ArrayList<Museum>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			museums = placeDAO.showMuseums();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return museums;		
	}
	
	public List<Park> getParks(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<Park> parks = new ArrayList<Park>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			parks = placeDAO.showParks();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return parks;		
	}
	
	public List<Stadium> getStadiums(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<Stadium> stadiums = new ArrayList<Stadium>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			stadiums = placeDAO.showStadiums();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return stadiums;		
	}
	
	public List<Theater> getTheaters(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<Theater> theaters = new ArrayList<Theater>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			theaters = placeDAO.showTheaters();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return theaters;		
	}
	
	public List<TouristAttraction> getTouristAttractions(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<TouristAttraction> touristAttractions = new ArrayList<TouristAttraction>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			touristAttractions = placeDAO.showTouristAttractions();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return touristAttractions;		
	}
	
	public List<TraditionalMarket> getTraditionalMarkets(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<TraditionalMarket> traditionalMarkets = new ArrayList<TraditionalMarket>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			traditionalMarkets = placeDAO.showTraditionalMarkets();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return traditionalMarkets;		
	}
	
	public List<Zoo> getZoos(){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		List<Zoo> zoos = new ArrayList<Zoo>();
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			zoos = placeDAO.showZoos();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return zoos;		
	}
	
	public int insertPlace(Place place,int typeOfPlace){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		int affectedRows = 0;
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			affectedRows = placeDAO.insertPlace(place, typeOfPlace);
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return affectedRows;		
	}
	
	public int deletePlace(int placeId){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		int affectedRows = 0;
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			affectedRows = placeDAO.deletePlace(placeId);
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return affectedRows;		
	}
	
	public int updatePlace(Place place,int typeOfPlace){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		int affectedRows = 0;
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			affectedRows = placeDAO.updatePlace(place, typeOfPlace);
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}	
		return affectedRows;		
	}
	
	public void changeImage(int id, File image){
		DAOManager manager = null;
		IPlaceDAO placeDAO = null;
		
		try {
			manager = new DAOManager();
			placeDAO = manager.getPlaceDAO();	
			placeDAO.changeImage(id, image);
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		}			
	}
	
	
	
	

}
