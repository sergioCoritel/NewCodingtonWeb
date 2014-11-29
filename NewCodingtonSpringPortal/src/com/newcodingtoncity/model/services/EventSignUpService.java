package com.newcodingtoncity.model.services;

import java.util.ArrayList;
import java.util.List;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.interfaces.daos.IEventSignUpDAO;
import com.newcodingtoncity.model.interfaces.services.IEventSignUpService;



public class EventSignUpService implements IEventSignUpService{

	public boolean registerVisitorForNewEvent(EventSignUp eventSignUpSession){
		DAOManager manager = null;
		IEventSignUpDAO eventSignUpDAO = null;
		int registrado=0;
		boolean seatsAvailabes=false;
		int seatsUpdate = 0;
		boolean existeRegistro = false;
		
		try {
			manager = new DAOManager();
			eventSignUpDAO = manager.getEventSignUpDAO();
			existeRegistro = eventSignUpDAO.checkEventsofVisitorDAO(eventSignUpSession);
			seatsAvailabes = eventSignUpDAO.checkSeatsForRestAvailableDAO(eventSignUpSession);
			if(!existeRegistro){
				if(seatsAvailabes){
					registrado = eventSignUpDAO.registerVisitorForNewEventDAO(eventSignUpSession);
					seatsUpdate = eventSignUpDAO.updateRestSeatsAvailableEvent(eventSignUpSession);
					System.out.println("PONER MENSAJE EN HTML: You have successfully registered");
					manager.closeConnectionWithCommit();
				}else{
					// PONER MENSAJE EN HTML
					System.out.println("PONER MENSAJE EN HTML: No hay asientos disponibles para este evento");
				}
			}else{
				// PONER MENSAJE EN HTML
				System.out.println("PONER MENSAJE EN HTML:Usted ya esta registrado en este evento");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		} 	
		System.out.println("REG:"+registrado);
		return (((registrado==1)&&(seatsUpdate==1))||(existeRegistro));		
	}
	
	public boolean unregisterVisitorForEvent(EventSignUp eventSignUpSession){

		DAOManager manager = null;
		IEventSignUpDAO eventSignUpDAO = null;
		int registrado=0;
		boolean seatsAvailabes=false;
		int seatsUpdate = 0;
		boolean existeRegistro = false;
		
		try {
			manager = new DAOManager();
			eventSignUpDAO = manager.getEventSignUpDAO();
			existeRegistro = eventSignUpDAO.checkEventsofVisitorDAO(eventSignUpSession);
			seatsAvailabes = eventSignUpDAO.checkSeatsForSumAvailableDAO(eventSignUpSession);
			if(existeRegistro){
				if(seatsAvailabes){
					registrado = eventSignUpDAO.unregisterVisitorForEventDAO(eventSignUpSession);
					seatsUpdate = eventSignUpDAO.updateSumSeatsAvailableEvent(eventSignUpSession);
					System.out.println("BORRAR PONER MENSAJE EN HTML: Usted se ha desregistrado con exito");
					manager.closeConnectionWithCommit();
				}else{
					// PONER MENSAJE EN HTML
					System.out.println("BORRAR PONER MENSAJE EN HTML: No hay asientos disponibles para este evento");
				}
			}else{
				// PONER MENSAJE EN HTML
				System.out.println("BORRAR PONER MENSAJE EN HTML:Usted no esta registrado en este evento");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("EEEHH QUE PASA");
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		} 	
		System.out.println("REG:"+registrado);
		return (((registrado==1)&&(seatsUpdate==1))||(existeRegistro));		
	}
	
	public List<EventSignUp> getAllEventsSignUp(){

		DAOManager manager = null;
		IEventSignUpDAO eventSignUpDAO = null;
		List<EventSignUp> allEventsSignUp = new ArrayList<EventSignUp>();

		try {
			manager = new DAOManager();
			eventSignUpDAO = manager.getEventSignUpDAO();	
			allEventsSignUp = eventSignUpDAO.showAllEventsUsersDAO();
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		} 		
		return allEventsSignUp;		
	}
	
	public List<Event> getAllEventsForOneUser(EventSignUp eventSignUp){
		DAOManager manager = null;
		IEventSignUpDAO eventSignUpDAO = null;
		List<Event> allEventsSignUp = new ArrayList<Event>();

		try {
			manager = new DAOManager();
			eventSignUpDAO = manager.getEventSignUpDAO();
			allEventsSignUp = eventSignUpDAO.showAllEventsForOneUsersDAO(eventSignUp);
			manager.closeConnectionWithCommit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			manager.closeConnectionWithRollback();
			e.printStackTrace();
		} 		
		return allEventsSignUp;		
	}
}
