package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.Theater;

public class TheaterMapper {

	public static Theater map(ResultSet resultSet) throws IOException{
		Theater theater = new Theater();
		PlaceMapper.map(resultSet, theater);
		return theater;
	}

}
