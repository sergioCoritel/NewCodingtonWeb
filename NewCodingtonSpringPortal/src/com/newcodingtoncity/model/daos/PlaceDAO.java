package com.newcodingtoncity.model.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;

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
import com.newcodingtoncity.model.helper.CodingtonConnectToDB;
import com.newcodingtoncity.model.helper.DatabaseHelper;
import com.newcodingtoncity.model.interfaces.daos.IPlaceDAO;
import com.newcodingtoncity.model.mappers.EventMapper;
import com.newcodingtoncity.model.mappers.LargeBusinessMapper;
import com.newcodingtoncity.model.mappers.MuseumMapper;
import com.newcodingtoncity.model.mappers.ParkMapper;
import com.newcodingtoncity.model.mappers.StadiumMapper;
import com.newcodingtoncity.model.mappers.TheaterMapper;
import com.newcodingtoncity.model.mappers.TouristAttractionMapper;
import com.newcodingtoncity.model.mappers.TraditionalMarketMapper;
import com.newcodingtoncity.model.mappers.ZooMapper;


public class PlaceDAO implements IPlaceDAO {

	private JdbcTemplate jdbcTemplateObject;
	private Properties queryProperties;
	
	
	public PlaceDAO(JdbcTemplate jdbcTemplateObject,Properties queryProperties ) {
	    this.jdbcTemplateObject = jdbcTemplateObject;
	    this.queryProperties = queryProperties;
	} 

	public ArrayList<Museum> showMuseums() throws ClassNotFoundException,SQLException, IOException {
	
		ArrayList<Museum> placeList =  (ArrayList<Museum>) jdbcTemplateObject.query(queryProperties.getProperty("place_museum"), 
                new MuseumMapper());
		return placeList;
	}

	public ArrayList<Zoo> showZoos() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<Zoo> placeList =  (ArrayList<Zoo>) jdbcTemplateObject.query(queryProperties.getProperty("place_zoo"), 
                new ZooMapper());
		return placeList;
	}

	public ArrayList<Park> showParks() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<Park> placeList =  (ArrayList<Park>) jdbcTemplateObject.query(queryProperties.getProperty("place_zoo"), 
                new ParkMapper());
		return placeList;	
	}

	public ArrayList<Theater> showTheaters() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<Theater> placeList =  (ArrayList<Theater>) jdbcTemplateObject.query(queryProperties.getProperty("place_theater"), 
                new TheaterMapper());
		return placeList;	
	
	}

	public ArrayList<Stadium> showStadiums() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<Stadium> placeList =  (ArrayList<Stadium>) jdbcTemplateObject.query(queryProperties.getProperty("place_stadium"), 
                new StadiumMapper());
		return placeList;	
	}

	public ArrayList<LargeBusiness> showLargeBusiness() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<LargeBusiness> placeList =  (ArrayList<LargeBusiness>) jdbcTemplateObject.query(queryProperties.getProperty("place_large_business"), 
                new LargeBusinessMapper());
		return placeList;
		
	}

	public ArrayList<TouristAttraction> showTouristAttractions() throws ClassNotFoundException,SQLException, IOException {
		ArrayList<TouristAttraction> placeList =  (ArrayList<TouristAttraction>) jdbcTemplateObject.query(queryProperties.getProperty("place_tourist_attraction"), 
                new TouristAttractionMapper());
		return placeList;
	}

	public ArrayList<TraditionalMarket> showTraditionalMarkets() throws ClassNotFoundException,
	SQLException, IOException {
		ArrayList<TraditionalMarket> placeList =  (ArrayList<TraditionalMarket>) jdbcTemplateObject.query(queryProperties.getProperty("place_traditional_market"), 
                new TraditionalMarketMapper());
		return placeList;
	}

	public int insertPlace(final Place place,final int typeOfPlace) {
		int affectedRows = 0;	
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("update_infoplaces"), 
				 new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement)
						throws SQLException {
					preparedStatement.setInt(1,typeOfPlace);
					preparedStatement.setString(2,place.getName());
					preparedStatement.setInt(3,place.getCapacity());
					preparedStatement.setString(4,place.getPlaceDescription());
					preparedStatement.setString(5,place.getStart());
					preparedStatement.setString(6,place.getEnd());
					preparedStatement.setString(7,place.getZone().name());
					//HAY QUE CAMBIAR LO DE LA IMAGEN!!!!!!!!!!!!!!!!
					preparedStatement.setInt(8,11);
					preparedStatement.setBoolean(9,false);
				}	
			},keyHolder);		 
		int lastInsertedId =  keyHolder.getKey().intValue();
		affectedRows = jdbcTemplateObject.update(getSecondQuery(typeOfPlace),lastInsertedId);	
		return affectedRows;
	}


	private String getSecondQuery(int typeOfPlace) {
		String secondSqlQuery = "";
		switch (typeOfPlace) {
		case LargeBusiness.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case Museum.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case Park.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case Stadium.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case Theater.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case TouristAttraction.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;
		case TraditionalMarket.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
		case Zoo.ID_TYPE_OF_PLACE:
			secondSqlQuery = queryProperties.getProperty("insert_large_business");
			break;

		default:
			break;
		}
		return secondSqlQuery;
	}

	
	public int deletePlace(int placeId) {
		return jdbcTemplateObject.update(queryProperties.getProperty("delete_places"), placeId);
	}
	
	
	@Override
	public void changeImage(int id, File image) throws FileNotFoundException,
			SQLException {
//		FileInputStream fin = new FileInputStream(image);
//		int tam = (int) image.length();
//
////		if (VACIO) {
//			connection = CodingtonConnectToDB.createConnection();
//			String ins = queryProperties.getProperty("insert_image");
//			statement = connection.prepareStatement(ins);
//
//			statement.setBlob(1, fin, tam);
//			statement.setInt(2, id);
//			statement.executeUpdate();
////		}
//
////		else {
//			connection = CodingtonConnectToDB.createConnection();
//			String upd = queryProperties.getProperty("update_image");
//			statement = connection.prepareStatement(upd);
//
//			statement.setBlob(1, fin, tam);
//			statement.setInt(2, id);
//			statement.executeUpdate();
////		}
	}


	@Override
	public int updatePlace(final Place place, final int typeOfPlace) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		affectedRows = jdbcTemplateObject.update(queryProperties.getProperty("update_infoplaces"), 
				 new PreparedStatementSetter(){
				@Override
				public void setValues(PreparedStatement preparedStatement)
						throws SQLException {
					preparedStatement.setInt(1,typeOfPlace);
					preparedStatement.setString(2,place.getName());
					preparedStatement.setInt(3,place.getCapacity());
					preparedStatement.setString(4,place.getPlaceDescription());
					preparedStatement.setString(5,place.getStart());
					preparedStatement.setString(6,place.getEnd());
					preparedStatement.setString(7,place.getZone().name());
					//HAY QUE CAMBIAR LO DE LA IMAGEN!!!!!!!!!!!!!!!!
					preparedStatement.setInt(8,11);
					preparedStatement.setBoolean(9,false);
					preparedStatement.setInt(10,place.getId());
				}	
			});
			
		return affectedRows;
	}

	
	

}

