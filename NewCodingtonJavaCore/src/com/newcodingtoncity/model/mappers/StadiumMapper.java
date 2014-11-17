package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.helper.ConvertImage;

public class StadiumMapper {

	public static Stadium map(ResultSet resultSet) throws IOException{
		Stadium stadium = new Stadium();
		try {
			stadium.setId(resultSet.getInt("id_stadium"));
			stadium.setName(resultSet.getString("name"));
			stadium.setCapacity(resultSet.getInt("capacity"));
			stadium.setPlaceDescription(resultSet.getString("description"));
			stadium.setStart(resultSet.getString("start_time"));
			stadium.setEnd(resultSet.getString("end_time"));
			stadium.setImage(ConvertImage.blobToImage(resultSet.getBlob("image")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stadium;
	}

}
