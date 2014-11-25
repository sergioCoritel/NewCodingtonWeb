package com.newcondington.web.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;
import com.newcondington.web.servlets.base.IController;

public class LoginController  implements IController  {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	String urlDispatcher = null; 
    	try{
    	HttpSession sesion = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new Visitor();
		UserService userservice = new UserService();
		ServletContext context = request.getServletContext();
		
		userservice.setContext(context);
		
		u.setUserName(username);
		u.setPassword(password);

			if(userservice.login(u) == 0){
				 urlDispatcher = "WEB-INF/views/welcome.jsp";
			}		

			else{
				sesion.setAttribute("username", u.getUserName());
				sesion.setAttribute("id_user", u.getUserId());
				sesion.setAttribute("isAdmin", u.getIsAdmin());
				if(u.getIsAdmin()){
					 urlDispatcher = "WEB-INF/views/welcome.jsp";
				}
				else{
					request.setAttribute("error", "Login incorrecto.");
					 urlDispatcher = "WEB-INF/views/welcome.jsp";
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", "Login incorrecto.");
			 urlDispatcher = "index.jsp";
		}		
    	return urlDispatcher;
    }
}
