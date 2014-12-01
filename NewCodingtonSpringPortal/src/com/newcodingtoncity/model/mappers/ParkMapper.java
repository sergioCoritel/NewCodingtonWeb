package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Park;


public class ParkMapper implements RowMapper<Park> {

	@Override
	public Park mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Park park = new Park();
		try {
			PlaceMapper.map(resultSet, park);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return park;
	}

}
