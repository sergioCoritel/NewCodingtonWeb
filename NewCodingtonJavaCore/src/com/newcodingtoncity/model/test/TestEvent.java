package com.newcodingtoncity.model.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.places.Place;
import com.newcodingtoncity.model.exceptions.DomainException;


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
	
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		event = new Event(EVENT_ID, EVENT_NAME, DESCRIPTION,
				START, END, EVENT_TYPE, TICKET_PRICE,
				SEATSAVAILABLE, SEATSTOTAL, PLACE);
	}
	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	@Test
	public void testGetEventId() {
		assertEquals(EVENT_ID, event.getEventId());
	}
	
	
	@Test
	public void testSetEventId() {
		event.setEventId(0123456);
		assertEquals("Update ok", 0123456, event.getEventId());
	}
	
	
	@Test
	public void testGetEventName() {
		assertEquals(EVENT_NAME, event.getEventName());
	}
	
	
	@Test
	public void testSetEventName() {
		event.setEventName("Zoo");
		assertEquals("Update ok", "Zoo", event.getEventName());
	}
	
	
	/**
	 * Test for null and bad format of eventName
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetEventNameTestException() throws DomainException {
		try{
			String eventName;
			//Check eventName length out of maximum range.
			eventName = "acdefghacdefghacdefghacdefghacdefghacdefghacdefgh";
			event.setEventName(eventName);
			
			//Check eventName length out of minimum range.
			eventName = "";
			event.setEventName(eventName);
			
			//Check eventName is NULL.
			eventName = null;
			event.setEventName(eventName);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
	
	@Test
	public void testGetDescription() {
		assertEquals(DESCRIPTION, event.getDescription());
	}
	
	
	@Test
	public void testSetDescription() {
		event.setDescription("Visita el parque de atracciones de la ciudad");
		assertEquals("Update ok", "Visita el parque de atracciones de la ciudad", event.getDescription());
	}
	
	
	/**
	 * Test for null and bad format of description
	 * @throws DomainException
	 */
	@Test (expected = DomainException.class)
	public void testSetEventDescriptionTestException() throws DomainException {
		try{
			String description;
			//Check description length out of maximum range.
			description = "acdefghacdefghacdefghacdefghacdefghacdefghacdefgh";
			event.setDescription(description);
			
			//Check description length out of minimum range.
			description = "";
			event.setDescription(description);
			
			//Check description is NULL.
			description = null;
			event.setDescription(description);
		}catch(DomainException ex){
			System.err.println(ex.getMessage());
			}
	}
	
	
	@Test
	public void testGetStart() {
		assertEquals(START, event.getStart());
	}
	
	
	@Test
	public void testSetStart() {
		event.setStart("9:00");
		assertEquals("Update ok", "9:00", event.getStart());
	}
	
	
	@Test
	public void testGetEnd() {
		assertEquals(END, event.getEnd());
	}
	
	
	@Test
	public void testSetEnd() {
		event.setEnd("20:00");
		assertEquals("Update ok", "20:00", event.getEnd());
	}
	
	
	@Test
	public void testGetEventType() {
		assertEquals(EVENT_TYPE, event.getEventType());
	}
	
	
	@Test
	public void testSetEventType() {
		event.setEventType("Deportivo");
		assertEquals("Update ok", "Deportivo", event.getEventType());
	}
	
	
	@Test
	public void testGetTicketPrice() {
		assertEquals(TICKET_PRICE, event.getTicketPrice());
	}
	
	
	@Test
	public void testSetTicketPrice() {
		event.setTicketPrice(14);
		assertEquals("Update ok", 14, event.getTicketPrice());
	}
	
	
	@Test
	public void testGetSeatsAvailable() {
		assertEquals(SEATSAVAILABLE, event.getSeatsAvailable());
	}
	
	
	@Test
	public void testSetSeatsAvailable() {
		event.setSeatsAvailable(850);
		assertEquals("Update ok", 850, event.getSeatsAvailable());
	}
	
	
	@Test
	public void testGetSeatsTotal() {
		assertEquals(SEATSTOTAL, event.getSeatsTotal());
	}
	
	
	@Test
	public void testSetSeatsTotal() {
		event.setSeatsTotal(850);
		assertEquals("Update ok", 850, event.getSeatsTotal());
	}
	
	
	@Test
	public void testGetPlace() {
		assertEquals(PLACE, event.getPlace());
	}
	
	
}
