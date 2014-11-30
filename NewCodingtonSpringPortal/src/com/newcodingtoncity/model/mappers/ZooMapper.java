package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Zoo;


public class ZooMapper implements RowMapper<Zoo> {

	@Override
	public Zoo mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Zoo zoo = new Zoo();
		PlaceMapper.map(resultSet, zoo);
		return zoo;
	}

}
