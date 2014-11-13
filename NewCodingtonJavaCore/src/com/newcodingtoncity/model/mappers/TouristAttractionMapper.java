package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.TouristAttraction;

public class TouristAttractionMapper {

	public static TouristAttraction map(ResultSet resultSet){
		TouristAttraction touristAttraction = new TouristAttraction();
		try {
			touristAttraction.setId(resultSet.getInt("id_touristattraction"));
			touristAttraction.setName(resultSet.getString("name"));
			touristAttraction.setCapacity(resultSet.getInt("capacity"));
			touristAttraction.setPlaceDescription(resultSet.getString("description"));
			touristAttraction.setWorkingHours(resultSet.getString("workinghours"));
			touristAttraction.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return touristAttraction;
	}

}
