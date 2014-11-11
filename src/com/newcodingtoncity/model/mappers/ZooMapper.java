package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.places.Zoo;

public class ZooMapper {

	public static Zoo map(ResultSet resultSet){
		Zoo zoo = new Zoo();
		try {
			zoo.setId(resultSet.getInt("id_zoo"));
			zoo.setName(resultSet.getString("name"));
			zoo.setCapacity(resultSet.getInt("capacity"));
			zoo.setPlaceDescription(resultSet.getString("description"));
			zoo.setWorkingHours(resultSet.getString("workinghours"));
			zoo.setImage(resultSet.getString("image"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return zoo;
	}

}
