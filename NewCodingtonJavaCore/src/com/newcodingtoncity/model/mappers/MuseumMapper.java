package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Museum;

public class MuseumMapper {

	public static Museum map(ResultSet resultSet){
		Museum museum = new Museum();
		try {
			museum.setId(resultSet.getInt("id_museum"));
			museum.setName(resultSet.getString("name"));
			museum.setCapacity(resultSet.getInt("capacity"));
			museum.setPlaceDescription(resultSet.getString("description"));
			museum.setWorkingHours(resultSet.getString("workinghours"));
			museum.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return museum;
	}

}