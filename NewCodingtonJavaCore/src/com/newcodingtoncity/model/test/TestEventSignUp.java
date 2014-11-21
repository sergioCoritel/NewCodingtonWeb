package com.newcodingtoncity.model.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.services.EventSignUpService;

public class TestEventSignUp extends TestCase{
	
	EventSignUpService eventSignUpService;
	EventSignUp eventSignUpSession;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		eventSignUpService = new EventSignUpService();
		eventSignUpSession = new EventSignUp();
	}

	@After
	protected void tearDown() throws Exception {	
		super.tearDown();		
	}

	@Test
	public void testEventSignUpRegister() throws Exception {
		eventSignUpSession.setEventId(16);
		eventSignUpSession.setVisitorId(16);
		assertTrue(eventSignUpService.registerVisitorForNewEvent(eventSignUpSession));
	}
	
	@Test
	public void testEventSignUpUnRegister() throws Exception {
		eventSignUpSession.setEventId(16);
		eventSignUpSession.setVisitorId(16);
		assertTrue(eventSignUpService.unregisterVisitorForEvent(eventSignUpSession));
	}
	
	@Test
	public void testShowAllEvents() throws ClassNotFoundException, SQLException, IOException {
		
		List<EventSignUp> eventsSignUp = eventSignUpService.getAllEventsSignUp();

		for( int i = 0 ; i < eventsSignUp.size() ; i++ ){
			  System.out.println( "El id devuelto es "+eventsSignUp.get( i ).getId() );
			  System.out.println( "El id_event devuelto es "+eventsSignUp.get( i ).getEventId() );
			  System.out.println( "El id_user devuelto es "+eventsSignUp.get( i ).getVisitorId() );
		}
	}
	
	@Test
	public void testShowAllEventsForOneUser() throws ClassNotFoundException, SQLException, IOException {
		eventSignUpSession.setEventId(16);
		eventSignUpSession.setVisitorId(16);
		List<Event> events=  eventSignUpService.getAllEventsForOneUser(eventSignUpSession);
		for( int i = 0 ; i < events.size() ; i++ ){
			  System.out.println( "PONER EN HTML INGLES: El id_event devuelto es "+events.get( i ).getEventId());
			  System.out.println( "PONER EN HTML INGLES: El nombre es "+events.get(i).getEventName() );
			  System.out.println( "PONER EN HTML INGLES: El tipo devuelto es "+events.get( i ).getEventType() );
			  System.out.println( "PONER EN HTML INGLES: Los asientos disponibles son "+events.get( i ).getSeatsAvailable() );
			  System.out.println( "PONER EN HTML INGLES: Los asientos totales son "+events.get( i ).getSeatsTotal() );
			  System.out.println( "PONER EN HTML INGLES: Horario de apertura "+events.get( i ).getStart() );
			  System.out.println( "PONER EN HTML INGLES: Precio "+events.get( i ).getTicketPrice());
			  System.out.println( "PONER EN HTML INGLES: Nombre del lugar "+events.get( i ).getPlace().getName());
			  System.out.println("");
		}
	}
}
