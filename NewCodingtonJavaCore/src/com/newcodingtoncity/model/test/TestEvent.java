package com.newcodingtoncity.model.test;

import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Place;

public class TestEvent extends TestCase {
    private static final int EVENT_ID = 100158;
    private static final String EVENT_NAME = "Museo";
    private static final String DESCRIPTION = "Visita al museo";
    private static final String START = "10:00";
    private static final String END = "14:00";
    private static final String EVENT_TYPE = "Historico";
    private static final int TICKET_PRICE = 7;
    private static final int SEATSAVAILABLE = 180;
    private static final int SEATSTOTAL = 7;
    private static final Place PLACE = null;
    
	private Event event;
	
	protected void setUp() throws Exception {
		super.setUp();
		event = new Event(EVENT_ID, EVENT_NAME, DESCRIPTION,
				START, END, EVENT_TYPE, TICKET_PRICE,
				SEATSAVAILABLE, PLACE);
	}
	
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testGetAtributos() {
		assertEquals("eventID ok", EVENT_ID, event.getEventId());
		assertEquals("eventName ok", EVENT_NAME, event.getEventName());
		assertEquals("description ok", DESCRIPTION, event.getDescription());
		assertEquals("duration ok", START, event.getStart());
		assertEquals("duration ok", END, event.getEnd());
		assertEquals("eventType ok", EVENT_TYPE, event.getEventType());
		assertEquals("ticketPrice ok", TICKET_PRICE, event.getTicketPrice());
		assertEquals("seatsAvailable ok", SEATSAVAILABLE, event.getSeatsAvailable());
		assertEquals("seatsTotal ok", SEATSTOTAL, event.getSeatsTotal());
	}
	
	@Test
	public void testEventIntStringStringIntStringStringIntIntPlace() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetEventName() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testSetEventName() {
		event.setEventName("Zoo");
		assertEquals("Update ok", "Zoo", event.getEventName());
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		event.setDescription("Visita el gran parque de atracciones de la ciudad");
		assertEquals("Update ok", "Visita el gran parque de atracciones de la ciudad", event.getDescription());
	}

	@Test
	public void testGetStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDuration() {
		event.setStart("9:00");
		assertEquals("Update ok", 5, event.getStart());
	}
	
	@Test
	public void testGetEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnd() {
		event.setStart("9:00");
		assertEquals("Update ok", 5, event.getStart());
	}
	
	@Test
	public void testGetEventType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEventType() {
		event.setEventType("Deportivo");
		assertEquals("Update ok", "Deportivo", event.getEventType());
	}

	@Test
	public void testGetTicketPrice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetTicketPrice() {
		event.setTicketPrice(14);
		assertEquals("Update ok", 14, event.getTicketPrice());
	}

	@Test
	public void testGetEventId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEventId() {
		event.setEventId(0123456);
		assertEquals("Update ok", 0123456, event.getEventId());
	}

	@Test
	public void testGetSeatsAvailable() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeatsAvailable() {
		event.setSeatsAvailable(850);
		assertEquals("Update ok", 850, event.getSeatsAvailable());
	}
	
	@Test
	public void testGetSeatsTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSeatsTotal() {
		event.setSeatsAvailable(850);
		assertEquals("Update ok", 850, event.getSeatsTotal());
	}
	
	@Test
	public void testGetPlace() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPlace() {
		fail("Not yet implemented");
	}

}
