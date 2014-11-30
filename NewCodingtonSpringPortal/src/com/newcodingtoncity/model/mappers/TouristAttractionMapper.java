package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.TouristAttraction;


public class TouristAttractionMapper implements RowMapper<TouristAttraction>{

	

	@Override
	public TouristAttraction mapRow(ResultSet resultSet, int numRow)
			throws SQLException {
		TouristAttraction touristAttraction = new TouristAttraction();
		PlaceMapper.map(resultSet, touristAttraction);
		return touristAttraction;
	}

}
