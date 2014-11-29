package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.Museum;


public class MuseumMapper {

	public static Museum map(ResultSet resultSet) throws IOException{
		Museum museum = new Museum();
		PlaceMapper.map(resultSet, museum);
		return museum;
	}

}