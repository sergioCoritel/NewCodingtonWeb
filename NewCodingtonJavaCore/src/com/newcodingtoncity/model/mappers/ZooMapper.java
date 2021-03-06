package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.Zoo;

public class ZooMapper {

	public static Zoo map(ResultSet resultSet) throws IOException{
		Zoo zoo = new Zoo();
		PlaceMapper.map(resultSet, zoo);
		return zoo;
	}

}
