package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Park;
import com.newcodingtoncity.model.helper.ConvertImage;

public class ParkMapper {

	public static Park map(ResultSet resultSet) throws IOException{
		Park park = new Park();
		PlaceMapper.map(resultSet, park);
		return park;
	}

}
