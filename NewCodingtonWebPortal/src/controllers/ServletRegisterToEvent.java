package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.exceptions.ServiceException;
import com.newcodingtoncity.model.services.EventService;
import com.newcodingtoncity.model.services.EventSignUpService;
import com.newcodingtoncity.model.services.UserService;

/**
 * Servlet implementation class ServletRegisterToEvent
 */
@WebServlet("/ServletRegisterToEvent")
public class ServletRegisterToEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletRegisterToEvent() {
		super();
	}


	@SuppressWarnings("unchecked")
	protected String proccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		UserService userservice = new UserService();
		EventSignUpService eventSignup = new EventSignUpService();
		EventService eventService = new EventService(null);
		
		//String route = getServletContext().getRealPath("");
		ServletConfig conf = getServletConfig();
		ServletContext context = conf.getServletContext();
		userservice.setContext(context);
		
		HttpSession session = request.getSession();	
		List<Event> eventsOfVisitor = (List<Event>) session.getAttribute("visitorEvents");
		ServletContext servletContext = request.getServletContext();
		//String urlDispatcher = "WEB-INF/views/home.jsp";
		
		int id_event = Integer.parseInt(request.getParameter("id_event"));
		Integer id_visitor =  (Integer) session.getAttribute("visitor");
		EventSignUp eventSignUp = new EventSignUp(id_event, id_visitor);
		
		Event event = eventService.getEventById(id_event);
		
		try {
			//eventService.registerEvent(visitor, event);
			eventSignup.registerVisitorForNewEvent(eventSignUp);
			eventsOfVisitor.add(event);

			servletContext.setAttribute("events", eventService.getAllEvents());

		} catch (ServiceException ex) {
			request.setAttribute("EventError: ", event.getEventId());
			request.setAttribute("Error: ", ex.getMessage());

		}

		response.sendRedirect("/NewCodingtonWebPortal/registered.jsp");
		return null;

	}

}
