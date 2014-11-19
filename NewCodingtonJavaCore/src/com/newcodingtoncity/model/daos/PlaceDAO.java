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



public class PlaceDAO implements IPlaceDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public PlaceDAO(Connection connection) {
		this.connection = connection;
	}
	

	public ArrayList<Museum> showMuseums() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placemuseum"));

		resultSet = statement.executeQuery();
		ArrayList<Museum> placeList = new ArrayList<Museum>();

		while (resultSet.next()) {
			placeList.add(MuseumMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<Zoo> showZoos() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placezoo"));

		resultSet = statement.executeQuery();
		ArrayList<Zoo> placeList = new ArrayList<Zoo>();

		while (resultSet.next()) {
			placeList.add(ZooMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<Park> showParks() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placepark"));

		resultSet = statement.executeQuery();
		ArrayList<Park> placeList = new ArrayList<Park>();

		while (resultSet.next()) {
			placeList.add(ParkMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	}

	public ArrayList<Theater> showTheaters() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placetheater"));

		resultSet = statement.executeQuery();
		ArrayList<Theater> placeList = new ArrayList<Theater>();

		while (resultSet.next()) {
			placeList.add(TheaterMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	
	}

	public ArrayList<Stadium> showStadiums() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placestadium"));

		resultSet = statement.executeQuery();
		ArrayList<Stadium> placeList = new ArrayList<Stadium>();

		while (resultSet.next()) {
			placeList.add(StadiumMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;	
	}

	public ArrayList<LargeBusiness> showLargeBusiness() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placelargebusiness"));

		resultSet = statement.executeQuery();
		ArrayList<LargeBusiness> placeList = new ArrayList<LargeBusiness>();

		while (resultSet.next()) {
			placeList.add(LargeBusinessMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
		
	}

	public ArrayList<TouristAttraction> showTouristAttractions() throws ClassNotFoundException,SQLException, IOException {
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placetouristattraction"));

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
		statement = connection.prepareStatement(DatabaseHelper.getQuery("placetraditionalmarkets"));

		resultSet = statement.executeQuery();
		ArrayList<TraditionalMarket> placeList = new ArrayList<TraditionalMarket>();

		while (resultSet.next()) {
			placeList.add(TraditionalMarketMapper.map(resultSet)); 
		}
		resultSet.close();
		return placeList;
	}

	public int insertPlace(Place place, String sqlQuery) {
		int affectedRows = 0;	
		PreparedStatement preparedStatement = null;			 			
		try {
			preparedStatement = connection.prepareStatement(DatabaseHelper.getQuery(sqlQuery));
			preparedStatement.setString(1, place.getName());
			affectedRows = preparedStatement.executeUpdate();

		} catch(SQLException ex) {}
		return affectedRows;
	}

	
	public int deletePlace(int placeId, int typeId) {

		return 0;
	}
	
	
	@Override
	public void changeImage(int id, File image) throws FileNotFoundException,
			SQLException {
		FileInputStream fin = new FileInputStream(image);
		int tam = (int) image.length();

//		if (VACIO) {
			connection = CodingtonConnectToDB.createConnection();
			String ins = DatabaseHelper.getQuery("insert_image");
			statement = connection.prepareStatement(ins);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}

//		else {
			connection = CodingtonConnectToDB.createConnection();
			String upd = DatabaseHelper.getQuery("update_image");
			statement = connection.prepareStatement(upd);

			statement.setBlob(1, fin, tam);
			statement.setInt(2, id);
			statement.executeUpdate();
//		}
	}
	
	

}

