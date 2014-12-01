package com.newcodingtoncity.spring.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;


@Controller
public class UsersController{  

	@RequestMapping(value = "/login.htm")
	public String loginController(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		try {
			User userInserted = new Visitor();
			userInserted.setUserName(request.getParameter("username"));
			userInserted.setPassword(request.getParameter("password"));
			UserService userservice = new UserService();
			User userFound = userservice.login(userInserted);
			if(userFound == null){
				request.setAttribute("error", "Login incorrecto.");
				return "index";
			}		

			else{
				request.getSession().setAttribute("user", userFound);
				return "welcome";
			}
		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			return "index";
		}

	}

	@RequestMapping(value = "/logout.htm")
	public String logoutController(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession(true);
		sesion.invalidate();
		return "index";
	}


	@RequestMapping(value = "/register.htm")
	public String registerController() {
		return "register";
	}


	@RequestMapping(value = "/validate_register.htm")
	public String validaterRegisterController(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		boolean created = false;
		
		try {
			
			UserService userservice = new UserService();
			User user = new Visitor();
			String confirm_password = request.getParameter("campoComprobarPassword");
			
			user.setFirstName(request.getParameter("campoNombre"));
			user.setLastName(request.getParameter("campoApellidos"));
			user.setDni(request.getParameter("campoDNI"));
			user.setAddress(request.getParameter("campoDomicilio"));
			user.setPhoneNumber(request.getParameter("campoTelefono"));
			user.setEmail(request.getParameter("campoMail"));
			user.setUserName(request.getParameter("campoUsername"));
			user.setPassword(request.getParameter("campoPassword"));	
			
			if(user.getPassword().equals(confirm_password)) {
				created = userservice.registerNewVisitor(user);

				if(created) {
					request.setAttribute("ok", "User registered successeful.");
					return "index";

				} else {
					request.setAttribute("error", "User was not registered.");
					return "register";

				}

			} else {
				request.setAttribute("error", "Passwords are not equals.");
				return "register";

			}		

		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			return "index";
		}

	}

}