package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.LargeBusiness;

public class LargeBusinessMapper {

	public static LargeBusiness map(ResultSet resultSet){
		LargeBusiness largeBusiness = new LargeBusiness();
		try {
			largeBusiness.setId(resultSet.getInt("id_largebusiness"));
			largeBusiness.setName(resultSet.getString("name"));
			largeBusiness.setCapacity(resultSet.getInt("capacity"));
			largeBusiness.setPlaceDescription(resultSet.getString("description"));
			largeBusiness.setWorkingHours(resultSet.getString("workinghours"));
			largeBusiness.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return largeBusiness;
	}

}
