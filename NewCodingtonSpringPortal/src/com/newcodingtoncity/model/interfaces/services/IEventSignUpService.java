package es.codington.model.interfaces.services;

import java.util.List;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;

public interface IEventSignUpService {
	
	public boolean registerVisitorForNewEvent(EventSignUp eventSignUpSession);
	public boolean unregisterVisitorForEvent(EventSignUp eventSignUpSession);
	public List<EventSignUp> getAllEventsSignUp();
	public List<Event> getAllEventsForOneUser(EventSignUp eventSignUp);
}
