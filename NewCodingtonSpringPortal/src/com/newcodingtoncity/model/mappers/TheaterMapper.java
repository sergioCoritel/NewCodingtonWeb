package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Theater;


public class TheaterMapper implements RowMapper<Theater>{

	@Override
	public Theater mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Theater theater = new Theater();
		PlaceMapper.map(resultSet, theater);
		return theater;
	}

}
