package com.newcodingtoncity.model.interfaces.services;

import java.sql.SQLException;
import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;

public interface IEventSignUpService {
	
	public boolean registerVisitorForNewEvent(EventSignUp eventSignUpSession);
	
	public boolean unregisterVisitorForEvent(EventSignUp eventSignUpSession);

	public List<Event> getAllEventsForOneUser(EventSignUp eventSignUp) throws SQLException;
	
	public boolean IsRegisteredToEvent(final EventSignUp e);
}
