package com.newcondington.web.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.Event;

/**
 * Servlet implementation class Pruebaservelt
 */
@WebServlet("/Pruebaservelt")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() { super(); }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         
		try {
			DAOManager daoManager = new DAOManager();
			
//			ArrayList<Event> eventList = daoManager.getEventDAO().showMuseumEvents();
//			System.out.println("ListMuseumEvents:");
//			for(int i=0; i<eventList.size();i++){
//				System.out.println(eventList.get(i).getEventName()+ " en lugar ("+eventList.get(i).getPlace().getName() + ")" );
//			}
//			daoManager.closeConnectionWithCommit();
//			
//			
			PrintWriter out= response.getWriter();
			out.print("ESTO FUNCIONAAAA");
			out.print(daoManager.getConnection());
			
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
			
		}
		
	}

}
