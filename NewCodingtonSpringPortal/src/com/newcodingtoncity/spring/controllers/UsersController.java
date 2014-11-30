package com.newcodingtoncity.spring.controllers;

import java.io.IOException;
import java.sql.SQLException;

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

	@RequestMapping(value = "/register.htm")
	public String registerController() {
		return "register";
	}

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
			request.setAttribute("error", "Login incorrecto."+ e.getMessage());
			return "index";
		}
		
	}
	
	@RequestMapping(value = "/logout.htm")
	public String logoutController(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession(true);
        sesion.invalidate();
		return "index";
	}


}