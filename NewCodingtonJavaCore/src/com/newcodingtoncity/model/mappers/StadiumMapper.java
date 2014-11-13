package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Stadium;

public class StadiumMapper {

	public static Stadium map(ResultSet resultSet){
		Stadium stadium = new Stadium();
		try {
			stadium.setId(resultSet.getInt("id_stadium"));
			stadium.setName(resultSet.getString("name"));
			stadium.setCapacity(resultSet.getInt("capacity"));
			stadium.setPlaceDescription(resultSet.getString("description"));
			stadium.setWorkingHours(resultSet.getString("workinghours"));
			stadium.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stadium;
	}

}
