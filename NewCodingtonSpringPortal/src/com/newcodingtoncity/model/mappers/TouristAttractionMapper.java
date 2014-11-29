package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.TouristAttraction;



public class TouristAttractionMapper {

	public static TouristAttraction map(ResultSet resultSet) throws IOException{
		TouristAttraction touristAttraction = new TouristAttraction();
		PlaceMapper.map(resultSet, touristAttraction);
		return touristAttraction;
	}

}
