package com.newcondington.web.servlets.base;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    private Map<String,IController> controllers = new HashMap<String,IController>();
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        
	super();  
	controllers.put("/register.do", new RegisterController());
	controllers.put("/validate_register.do", new ValidateRegisterController());
	controllers.put("/welcome.do", new WelcomeController());
	controllers.put("/login.do", new LoginController());
	controllers.put("/list_events.do", new ListEventsController());

	controllers.put("/logout.do", new LogoutController());
	controllers.put("/show_event.do", new ShowEventController());
	controllers.put("/register_to_event.do", new RegisterToEventController());
    
    @Override
    public void init() throws ServletException {
	super.init();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		doProcess(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {		
	String action = request.getServletPath();
	String urlDispatcher = controllers.get(action).process(request, response);	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(urlDispatcher);
	
	requestDispatcher.forward(request, response);
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		doProcess(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
