package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.helper.ConvertImage;


public class PlaceMapper {

	public static Place map(ResultSet resultSet, Place place) throws SQLException, IOException{
			place.setId(resultSet.getInt("id_place"));
			place.setName(resultSet.getString("name_place"));
			place.setCapacity(resultSet.getInt("capacity"));
			place.setPlaceDescription(resultSet.getString("description_place"));
			place.setStart(resultSet.getString("start_time"));
			place.setEnd(resultSet.getString("end_time"));
			place.setImage(ConvertImage.blobToImage(resultSet.getBlob("image"), place.getId()));
		return place;
	}

}
