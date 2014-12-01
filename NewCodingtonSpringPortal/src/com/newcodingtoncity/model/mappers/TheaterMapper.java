package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Theater;


public class TheaterMapper implements RowMapper<Theater>{

	@Override
	public Theater mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Theater theater = new Theater();
		try {
			PlaceMapper.map(resultSet, theater);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theater;
	}

}
