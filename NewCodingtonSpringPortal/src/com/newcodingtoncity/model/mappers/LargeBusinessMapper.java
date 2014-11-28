package es.codington.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;

import com.newcodingtoncity.model.domain.places.LargeBusiness;

public class LargeBusinessMapper {

	public static LargeBusiness map(ResultSet resultSet) throws IOException{
		LargeBusiness largeBusiness = new LargeBusiness();
		PlaceMapper.map(resultSet, largeBusiness);
		return largeBusiness;
	}

}
