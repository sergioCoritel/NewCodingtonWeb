package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.users.Visitor;

public class VisitorMapper implements RowMapper<Visitor>{

	@Override
	public Visitor mapRow(ResultSet resultSet, int numRow) throws SQLException {
		Visitor visitor = new Visitor();
			visitor.setUserId(resultSet.getInt("id_user"));
			visitor.setUserName(resultSet.getString("username"));
			visitor.setPassword(resultSet.getString("password"));
			visitor.setFirstName(resultSet.getString("firstname"));
			visitor.setLastName(resultSet.getString("lastname"));
			visitor.setDni(resultSet.getString("dni"));
			visitor.setEmail(resultSet.getString("email"));
			visitor.setPhoneNumber(resultSet.getString("phone_number"));
			visitor.setAddress(resultSet.getString("address"));
			visitor.setIsAdmin(resultSet.getBoolean("is_admin"));
		return visitor;
	}

}
