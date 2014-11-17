package com.newcodingtoncity.model.daos;


import java.util.List;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;

public class EventSignUpDAO implements IEventSignUpDAO{

	@Override
	public int registerVisitorForNewEvent(EventSignUp e){
		
		return 0;
	}
	
	@Override
	public int unregisterVisitorForEvent(EventSignUp e){
		return 0;
	}

	@Override
	public boolean deleteEvenSignUp(EventSignUp e) {
		
		return false;
	}

	@Override
	public List<Event> viewEvents(EventSignUp e) {
	
		return null;
	}

	@Override
	public List<Event> showEvents(EventSignUp e) {
	
		return null;
	}
	
	@Override
	public boolean visitorIsRegisteredToEvent(EventSignUp e) {
		
		return false;
	}
	
}
