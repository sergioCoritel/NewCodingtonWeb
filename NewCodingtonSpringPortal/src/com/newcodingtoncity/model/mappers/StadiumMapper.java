package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Stadium;



public class StadiumMapper implements RowMapper<Stadium> {


	@Override
	public Stadium mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Stadium stadium = new Stadium();
		PlaceMapper.map(resultSet, stadium);
		return stadium;
	}

}
