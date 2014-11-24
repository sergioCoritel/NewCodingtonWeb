package controllers;

import java.awt.Event;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcodingtoncity.model.daos.DAOManager;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;

@WebServlet(description = "It does the user login from the home page", urlPatterns = { "/ServletLogin" })
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProccess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProccess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String route = getServletContext().getRealPath("");
		User u = new Visitor();
		UserService userservice = new UserService();
		ServletConfig conf = getServletConfig();
		ServletContext context = conf.getServletContext();
		
		userservice.setContext(context);
		
		u.setUserName(username);
		u.setPassword(password);
		
		//COMPROBAR DATABASE
		
		if(userservice.login(u) == 0){
			response.sendRedirect("/NewCodingtonWebPortal/index.jsp");
		}		

		else{
			HttpSession sesion = request.getSession();
			sesion.setAttribute("username", u.getUserName());
			sesion.setAttribute("id_user", u.getUserId());
			sesion.setAttribute("isAdmin", u.getIsAdmin());
			
			if(u.getIsAdmin()){
				response.sendRedirect("/NewCodingtonWebPortal/home.html");
			}
			
			else{
				response.sendRedirect("/NewCodingtonWebPortal/homeadm.html");
			}
		}  
	}
}
