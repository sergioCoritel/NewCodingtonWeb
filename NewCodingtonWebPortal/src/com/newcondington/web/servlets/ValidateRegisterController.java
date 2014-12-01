package com.newcondington.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.exceptions.DomainException;
import com.newcodingtoncity.model.services.UserService;
import com.newcondington.web.servlets.base.IController;

public class ValidateRegisterController  implements IController  {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {

		User user = new Visitor();
		UserService userservice = new UserService();
		String urlDispatcher = null;
		
		String confirm_password = request.getParameter("campoComprobarPassword");
		
		//System.out.println("confirm_password: "+confirm_password);
		boolean created = false;

		try{

			//HttpSession sesion = request.getSession();
			String name = request.getParameter("campoNombre");
			//System.out.println("campoNombre: "+name);
			String lastname = request.getParameter("campoApellidos");
			String DNI = request.getParameter("campoDNI");
			String address = request.getParameter("campoDomicilio");
			String phone = request.getParameter("campoTelefono");
			String mail = request.getParameter("campoMail");
			String username = request.getParameter("campoUsername");
			String password = request.getParameter("campoPassword");

			ServletContext context = request.getServletContext();

			userservice.setContext(context);
			
			user.setFirstName(name);
			user.setLastName(lastname);
			user.setDni(DNI);
			user.setAddress(address);
			user.setPhoneNumber(phone);
			user.setEmail(mail);
			user.setUserName(username);
			user.setPassword(password);

			if(user.getPassword().equals(confirm_password)) {
				created = userservice.registerNewVisitor(user);


				if(created) {
					//urlDispatcher = "index.jsp";
					urlDispatcher = "WEB-INF/views/welcome.jsp";
					request.setAttribute("ok", "User registered successeful.");

				} else {
					urlDispatcher = "WEB-INF/views/register.jsp";
					request.setAttribute("error", "User was not registered, try it later.");

				}

			} else {
				urlDispatcher = "WEB-INF/views/register.jsp";
				request.setAttribute("error", "Passwords are not equals.");

			}		

		} catch(DomainException ex) {
			urlDispatcher = "WEB-INF/views/register.jsp";
			request.setAttribute("Error: ", ex.getMessage());
		}

		return urlDispatcher;

	}
}
