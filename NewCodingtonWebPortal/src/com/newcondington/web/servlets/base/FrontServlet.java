package com.newcondington.web.servlets.base;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.ListEventsController;
import com.newcondington.web.servlets.WelcomeController;
import com.newcondington.web.servlets.LoginController;
import com.newcondington.web.servlets.RegisterController;

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
	controllers.put("/welcome.do", new WelcomeController());
	controllers.put("/login.do", new LoginController());
	controllers.put("/list_events.do", new ListEventsController());
    }

    
    @Override
    public void init() throws ServletException {
	super.init();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
    System.out.println("SERVLET PATH: "+request.getServletPath());
	String action = request.getServletPath();
	System.out.println("SERVLET PATH: "+request.getServletPath());
	System.out.println("CONTEXT PATH:  "+request.getContextPath());
	System.out.println("ACTION:"+action);
	String urlDispatcher = controllers.get(action).process(request, response);	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher(urlDispatcher);
	
	requestDispatcher.forward(request, response);
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doProcess(request, response);
    }
}
