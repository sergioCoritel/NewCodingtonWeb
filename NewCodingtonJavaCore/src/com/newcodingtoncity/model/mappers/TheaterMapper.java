package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Theater;
import com.newcodingtoncity.model.helper.ConvertImage;

public class TheaterMapper {

	public static Theater map(ResultSet resultSet) throws IOException{
		Theater theater = new Theater();
		try {
			theater.setId(resultSet.getInt("id_theater"));
			theater.setName(resultSet.getString("name"));
			theater.setCapacity(resultSet.getInt("capacity"));
			theater.setPlaceDescription(resultSet.getString("description"));
			theater.setWorkingHours(resultSet.getString("workinghours"));
			theater.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theater;
	}

}
