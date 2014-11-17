package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Museum;
import com.newcodingtoncity.model.helper.ConvertImage;

public class MuseumMapper {

	public static Museum map(ResultSet resultSet) throws IOException{
		Museum museum = new Museum();
		try {
			museum.setId(resultSet.getInt("id_museum"));
			museum.setName(resultSet.getString("name"));
			museum.setCapacity(resultSet.getInt("capacity"));
			museum.setPlaceDescription(resultSet.getString("description"));
			museum.setWorkingHours(resultSet.getString("workinghours"));
			museum.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return museum;
	}

}