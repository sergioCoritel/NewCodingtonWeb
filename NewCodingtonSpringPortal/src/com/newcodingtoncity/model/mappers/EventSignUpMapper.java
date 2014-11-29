package com.newcodingtoncity.model.mappers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newcodingtoncity.model.domain.EventSignUp;

public class EventSignUpMapper {
	public static EventSignUp map(ResultSet resultSet) throws IOException{
		EventSignUp eventSignUp = new EventSignUp();
		
		try {
			eventSignUp.setEventId(resultSet.getInt("id_event"));
			eventSignUp.setVisitorId(resultSet.getInt("id_user"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventSignUp;
	}


}
