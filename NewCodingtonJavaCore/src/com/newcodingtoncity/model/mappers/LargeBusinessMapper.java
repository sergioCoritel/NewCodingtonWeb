package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.LargeBusiness;
import com.newcodingtoncity.model.helper.ConvertImage;

public class LargeBusinessMapper {

	public static LargeBusiness map(ResultSet resultSet) throws IOException{
		LargeBusiness largeBusiness = new LargeBusiness();
		PlaceMapper.map(resultSet, largeBusiness);
		return largeBusiness;
	}

}
