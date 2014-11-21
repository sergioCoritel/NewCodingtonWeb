package com.newcodingtoncity.model.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import com.newcodingtoncity.model.mappers.LargeBusinessMapper;
import com.newcodingtoncity.model.mappers.MuseumMapper;
import com.newcodingtoncity.model.mappers.ParkMapper;
import com.newcodingtoncity.model.mappers.StadiumMapper;
import com.newcodingtoncity.model.mappers.TheaterMapper;
import com.newcodingtoncity.model.mappers.TouristAttractionMapper;
import com.newcodingtoncity.model.mappers.TraditionalMarketMapper;
import com.newcodingtoncity.model.mappers.ZooMapper;
import com.mysql.jdbc.Statement;


public class PlaceDAO implements IPlaceDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DatabaseHelper databaseHelper;

	public PlaceDAO(Connection connection, DatabaseHelper databaseHelper) {
		this.connection = connection;
		this.databaseHelper = databaseHelper;
	}
	

	public ArrayList<Museum> showMuseums() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_museum"));

		resultSet = statement.executeQuery();
		ArrayList<Museum> placeList = new ArrayList<Museum>();

		while (resultSet.next()) {
			placeList.add(MuseumMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<Zoo> showZoos() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_zoo"));

		resultSet = statement.executeQuery();
		ArrayList<Zoo> placeList = new ArrayList<Zoo>();

		while (resultSet.next()) {
			placeList.add(ZooMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<Park> showParks() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_park"));

		resultSet = statement.executeQuery();
		ArrayList<Park> placeList = new ArrayList<Park>();

		while (resultSet.next()) {
			placeList.add(ParkMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	}

	public ArrayList<Theater> showTheaters() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_theater"));

		resultSet = statement.executeQuery();
		ArrayList<Theater> placeList = new ArrayList<Theater>();

		while (resultSet.next()) {
			placeList.add(TheaterMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	
	}

	public ArrayList<Stadium> showStadiums() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_stadium"));

		resultSet = statement.executeQuery();
		ArrayList<Stadium> placeList = new ArrayList<Stadium>();

		while (resultSet.next()) {
			placeList.add(StadiumMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	}

	public ArrayList<LargeBusiness> showLargeBusiness() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_large_business"));

		resultSet = statement.executeQuery();
		ArrayList<LargeBusiness> placeList = new ArrayList<LargeBusiness>();

		while (resultSet.next()) {
			placeList.add(LargeBusinessMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
		
	}

	public ArrayList<TouristAttraction> showTouristAttractions() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_tourist_attraction"));

		resultSet = statement.executeQuery();
		ArrayList<TouristAttraction> placeList = new ArrayList<TouristAttraction>();

		while (resultSet.next()) {
			placeList.add(TouristAttractionMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<TraditionalMarket> showTraditionalMarkets() throws ClassNotFoundException,
	SQLException, IOException {
		statement = connection.prepareStatement(databaseHelper.getQuery("place_traditional_market"));

		resultSet = statement.executeQuery();
		ArrayList<TraditionalMarket> placeList = new ArrayList<TraditionalMarket>();

		while (resultSet.next()) {
			placeList.add(TraditionalMarketMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public int insertPlace(Place place,int typeOfPlace) {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("insert_places"),Statement.RETURN_GENERATED_KEYS);
			String secondQuery = getSecondQuery(typeOfPlace);
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
			
			affectedRows = preparedStatement.executeUpdate();
			ResultSet resultSetGenerated = preparedStatement.getGeneratedKeys();
			connection.commit();	
			
			int lastInsertedId = -1;
            if(resultSetGenerated.next()){
                lastInsertedId = resultSetGenerated.getInt(1);
            }
			preparedStatement = connection.prepareStatement(secondQuery);
			preparedStatement.setInt(1, lastInsertedId);
			preparedStatement.executeUpdate();
			
		} catch(SQLException ex) {}
		return affectedRows;
	}


	private String getSecondQuery(int typeOfPlace) {
		String secondSqlQuery = "";
		switch (typeOfPlace) {
		case LargeBusiness.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case Museum.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case Park.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case Stadium.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case Theater.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case TouristAttraction.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;
		case TraditionalMarket.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
		case Zoo.ID_TYPE_OF_PLACE:
			secondSqlQuery = databaseHelper.getQuery("insert_large_business");
			break;

		default:
			break;
		}
		return secondSqlQuery;
	}

	
	public int deletePlace(int placeId) {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("delete_places"));
		    preparedStatement.setInt(1, placeId);	 
		    affectedRows = preparedStatement.executeUpdate();   
		} catch(SQLException ex) {
		}
		return affectedRows;
	}
	
	
	@Override
	public void changeImage(int id, File image) throws FileNotFoundException,
			SQLException {
		FileInputStream fin = new FileInputStream(image);
		int tam = (int) image.length();

//		if (VACIO) {
			connection = CodingtonConnectToDB.createConnection();
			String ins = databaseHelper.getQuery("insert_image");
			statement = connection.prepareStatement(ins);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}

//		else {
			connection = CodingtonConnectToDB.createConnection();
			String upd = databaseHelper.getQuery("update_image");
			statement = connection.prepareStatement(upd);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}
	}


	@Override
	public int updatePlace(Place place, int typeOfPlace) throws ClassNotFoundException,
			SQLException, IOException {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(databaseHelper.getQuery("update_infoplaces"));
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
		    affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedRows;
	}

	
	

}

