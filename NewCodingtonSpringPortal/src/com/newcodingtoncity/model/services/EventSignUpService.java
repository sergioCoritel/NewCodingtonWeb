package com.newcodingtoncity.model.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.interfaces.services.IEventSignUpService;



public class EventSignUpService implements IEventSignUpService{

	private IEventSignUpDAO eventSignUpDAO;

	public EventSignUpService(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(  "beans.xml");  
		DAOManager daoManager = (DAOManager) ctx.getBean("daoManager");
		this.eventSignUpDAO = daoManager.getEventSignUpDAO();
	}
	
	public boolean registerVisitorForNewEvent(EventSignUp eventSignUpSession){
		int registrado=0;
		boolean availableSeats=false;
		int seatsUpdate = 0;
		boolean existeRegistro = false;
	
			existeRegistro = eventSignUpDAO.IsRegisteredToEvent(eventSignUpSession);
			availableSeats = eventSignUpDAO.checkSeatsAvailableDAO(eventSignUpSession);
			if(!existeRegistro){
				if(availableSeats){
					registrado = eventSignUpDAO.registerVisitorForNewEventDAO(eventSignUpSession);
					seatsUpdate = eventSignUpDAO.updateRestSeatsAvailableEvent(eventSignUpSession);
				}
			}
		return (((registrado==1)&&(seatsUpdate==1))||(existeRegistro));		
	}
	
	public boolean unregisterVisitorForEvent(EventSignUp eventSignUpSession){
		int registrado=0;
		int seatsUpdate = 0;
		boolean existeRegistro = false;
			existeRegistro = eventSignUpDAO.IsRegisteredToEvent(eventSignUpSession);
			if(existeRegistro){
					registrado = eventSignUpDAO.unregisterVisitorForEventDAO(eventSignUpSession);
					seatsUpdate = eventSignUpDAO.updateSumSeatsAvailableEvent(eventSignUpSession);
			}
		return (((registrado==1)&&(seatsUpdate==1))||(existeRegistro));		
	}
	

	public List<Event> getAllEventsForOneUser(EventSignUp eventSignUp) throws SQLException{
		return eventSignUpDAO.viewEventsOfUserDAO(eventSignUp);
	}
}
