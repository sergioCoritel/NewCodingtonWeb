package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.LargeBusiness;

public class LargeBusinessMapper implements RowMapper<LargeBusiness>{

	@Override
	public LargeBusiness mapRow(ResultSet resultSet, int numRow) throws SQLException {
		LargeBusiness largeBusiness = new LargeBusiness();
		try {
			PlaceMapper.map(resultSet, largeBusiness);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return largeBusiness;
	}

}
