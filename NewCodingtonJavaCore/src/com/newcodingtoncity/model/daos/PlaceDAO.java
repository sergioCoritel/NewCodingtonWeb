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
import com.newcodingtoncity.model.mappers.PlaceMapper;



public class PlaceDAO implements IPlaceDAO {

	// JDBC API classes for data persistence
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;

	public PlaceDAO(Connection connection) {
		this.connection = connection;
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


	public ArrayList<?> requestPlaceList(String sqlQuery, Place place) throws ClassNotFoundException,
	SQLException, IOException {
		statement = connection.prepareStatement(sqlQuery);

		resultSet = statement.executeQuery();
		ArrayList<Place> placeList = new ArrayList<Place>();

		while (resultSet.next()) {
			placeList.add(PlaceMapper.map(resultSet,place)); 
		}
		resultSet.close();
		return placeList;
	}

	public ArrayList<Museum> showMuseums() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<Museum>) requestPlaceList(DatabaseHelper.getQuery("selectmuseums"), new Museum());
	}

	public ArrayList<Zoo> showZoos() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<Zoo>) requestPlaceList(DatabaseHelper.getQuery("selectzoos"),new Zoo());
	}

	public ArrayList<Park> showParks() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<Park>) requestPlaceList(DatabaseHelper.getQuery("selectparks"), new Park());
	}

	public ArrayList<Theater> showTheaters() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<Theater>) requestPlaceList(DatabaseHelper.getQuery("selectteathers"), new Theater());
	}

	public ArrayList<Stadium> showStadiums() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<Stadium>) requestPlaceList(DatabaseHelper.getQuery("selectstadiums"), new Stadium());
	}

	public ArrayList<LargeBusiness> showLargeBusiness() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<LargeBusiness>) requestPlaceList(DatabaseHelper.getQuery("selectlargeBusiness"), new LargeBusiness());
	}

	public ArrayList<TouristAttraction> showTouristAttractions() throws ClassNotFoundException,SQLException, IOException {
		return (ArrayList<TouristAttraction>) requestPlaceList(DatabaseHelper.getQuery("selecttouristattractions"), new TouristAttraction());
	}

	public ArrayList<TraditionalMarket> showTraditionalMarkets() throws ClassNotFoundException,
	SQLException, IOException {
		return (ArrayList<TraditionalMarket>) requestPlaceList(DatabaseHelper.getQuery("selecttraditionalarkets"), new TraditionalMarket()); 
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

}

