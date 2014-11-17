package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.helper.ConvertImage;

public class ParkMapper {

	public static Park map(ResultSet resultSet) throws IOException{
		Park park = new Park();
		try {
			park.setId(resultSet.getInt("placeId"));
			park.setName(resultSet.getString("name"));
			park.setCapacity(resultSet.getInt("capacity"));
			park.setPlaceDescription(resultSet.getString("description"));
			park.setStart(resultSet.getString("start_time"));
			park.setEnd(resultSet.getString("end_time"));
			park.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return park;
	}

}
