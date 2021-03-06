package com.newcodingtoncity.spring.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newcodingtoncity.model.domain.Event;
import com.newcodingtoncity.model.domain.EventSignUp;
import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.EventSignUpService;
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
				request.setAttribute("error", "Login incorrect.");
				return "index";
			}		

			else{
				request.getSession().setAttribute("user", userFound);
				//request.setAttribute("ok", "");
				return "welcome";
			}
		} catch (Exception e) {
			request.setAttribute("error", "Login incorrect.");
			return "index";
		}

	}

	@RequestMapping(value = "/logout.htm")
	public String logoutController(HttpServletRequest request, HttpServletResponse response) {
		HttpSession sesion = request.getSession(true);
		sesion.invalidate();
		return "index";
	}

	@RequestMapping(value = "/profile.htm")
	public String profileController(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		try {

			User userSelected = new Visitor();
			userSelected = (User) request.getSession().getAttribute("user");
			UserService userservice = new UserService();
			User userFound = userservice.login(userSelected);
			if(userFound == null){
				request.setAttribute("error", "Profile incorrect.");
				return "welcome";
			}		

			else{
				request.getSession().setAttribute("user", userFound);
				return "profile";
			}
		} catch (Exception e) {
			request.setAttribute("error", "Login incorrecto."+ e.getMessage());
			return "welcome";
		}
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
			user.setFirstName(request.getParameter("campoNombre"));
			user.setLastName(request.getParameter("campoApellidos"));
			user.setDni(request.getParameter("campoDNI"));
			user.setAddress(request.getParameter("campoDomicilio"));
			user.setPhoneNumber(request.getParameter("campoTelefono"));
			user.setEmail(request.getParameter("campoMail"));
			user.setUserName(request.getParameter("campoUsername"));
			user.setPassword(request.getParameter("campoPassword"));	
			created = userservice.registerNewVisitor(user);

			if(created) {
				request.setAttribute("ok", "User registered successeful.");
				return "index";

			} else {
				request.setAttribute("error", "User was not registered.");
				return "register";

			}

		} catch (Exception e) {
			System.out.println("ERROR: "+e.getMessage());
			request.setAttribute("error", "Unexpected error.");
			return "register";
		}

	}


	@RequestMapping(value = "/change_info.htm")
	public String change_infoController(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		return "change_info";
	}

	@RequestMapping(value = "/change_pass.htm")
	public String change_passController(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		return "change_password";
	}

	@RequestMapping(value = "/update_info_user.htm")
	public String update_info_userController(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		boolean result_update=false;
		try {

			User userUpdated = new Visitor();
			userUpdated.setFirstName(request.getParameter("campoNombre"));
			userUpdated.setLastName(request.getParameter("campoApellidos"));
			userUpdated.setDni(request.getParameter("campoDNI"));
			userUpdated.setAddress(request.getParameter("campoDomicilio"));
			userUpdated.setPhoneNumber(request.getParameter("campoTelefono"));
			userUpdated.setEmail(request.getParameter("campoMail"));
			userUpdated.setUserId(Integer.parseInt(request.getParameter("id")));
			UserService userservice = new UserService();
			result_update = userservice.updateInfo(userUpdated);
			if(result_update == false){
				request.setAttribute("error", "Update Info incorrect.");
				return "change_info";
			}		

			else{
				request.setAttribute("ok", "Profile update succesfully");
				return "redirect:/profile.htm";
			}

		} catch (Exception e) {
			request.setAttribute("error", "Update Infor incorrect."+ e.getMessage());
			return "change_info";
		}

	}

	@RequestMapping(value = "/update_pass_user.htm")
	public String update_pass_userController(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {

		boolean result_update=false;
		try {

			User userpassUpdated = new Visitor();
			userpassUpdated.setUserId(Integer.parseInt(request.getParameter("id")));
			String nw_pass = request.getParameter("campoPassword");
			UserService userservice = new UserService();
			result_update = userservice.updatePassword(userpassUpdated, nw_pass);
			if(result_update == false){
				request.setAttribute("error", "Update Pass incorrect.");
				return "change_password";
			}		

			else{
				request.setAttribute("ok", "Pass updated, loggin again.");
				return "redirect:/login.htm";
			}




		} catch (Exception e) {
			request.setAttribute("error", "Update Pass incorrect."+ e.getMessage());
			return "change_password";
		}

	}
	
	@RequestMapping(value = "/myevents.htm")
	public ModelAndView listMyEventsController(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		EventSignUp eventSignUp = new EventSignUp(0,user.getUserId());
		EventSignUpService eventSignUpService = new EventSignUpService();
		ArrayList<Event> myEvents = new ArrayList<Event>();
		myEvents = (ArrayList<Event>) eventSignUpService.getAllEventsForOneUser(eventSignUp);
		modelAndView.addObject("events", myEvents);
		modelAndView.setViewName("list_events");
		return modelAndView;
	}

}