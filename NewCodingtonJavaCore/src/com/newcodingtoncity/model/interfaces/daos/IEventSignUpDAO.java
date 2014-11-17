package com.newcodingtoncity.model.interfaces.daos;

import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;

public interface IEventSignUpDAO {
	
	
	public int registerVisitorForNewEvent(EventSignUp e);
	
	
	
	public int unregisterVisitorForEvent(EventSignUp e);
	
	
	
	public boolean deleteEvenSignUp(EventSignUp e);
	
	
	
	public List<Event> viewEvents(EventSignUp e);
	
	
	
	public boolean visitorIsRegisteredToEvent(EventSignUp e);
	
	
}
