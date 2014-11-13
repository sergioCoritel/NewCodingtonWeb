package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Park;

public class ParkMapper {

	public static Park map(ResultSet resultSet){
		Park park = new Park();
		try {
			park.setId(resultSet.getInt("placeId"));
			park.setName(resultSet.getString("name"));
			park.setCapacity(resultSet.getInt("capacity"));
			park.setPlaceDescription(resultSet.getString("description"));
//			park.setWorkingHours(resultSet.getString("workinghours"));
			park.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return park;
	}

}
