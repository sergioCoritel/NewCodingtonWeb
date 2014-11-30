package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Park;


public class ParkMapper implements RowMapper<Park> {

	@Override
	public Park mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Park park = new Park();
		PlaceMapper.map(resultSet, park);
		return park;
	}

}
