package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Stadium;
import com.newcodingtoncity.model.helper.ConvertImage;

public class StadiumMapper {

	public static Stadium map(ResultSet resultSet) throws IOException{
		Stadium stadium = new Stadium();
		PlaceMapper.map(resultSet, stadium);
		return stadium;
	}

}
