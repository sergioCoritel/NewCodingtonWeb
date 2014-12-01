package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.places.Stadium;



public class StadiumMapper implements RowMapper<Stadium> {


	@Override
	public Stadium mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Stadium stadium = new Stadium();
		try {
			PlaceMapper.map(resultSet, stadium);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stadium;
	}

}
