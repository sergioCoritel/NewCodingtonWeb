package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Museum;


public class MuseumMapper implements RowMapper<Museum>{

	@Override
	public Museum mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Museum museum = new Museum();
		PlaceMapper.map(resultSet, museum);
		return museum;
	}

}