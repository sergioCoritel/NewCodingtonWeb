package com.newcodingtoncity.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.newcodingtoncity.model.domain.EventSignUp;

public class EventSignUpMapper  implements RowMapper<EventSignUp>{


	@Override
	public EventSignUp mapRow(ResultSet resultSet, int numRow) throws SQLException {
		EventSignUp eventSignUp = new EventSignUp();
		eventSignUp.setEventId(resultSet.getInt("id_events_users"));
		eventSignUp.setEventId(resultSet.getInt("id_event"));
		eventSignUp.setVisitorId(resultSet.getInt("id_user"));
		return eventSignUp;
	}


}
