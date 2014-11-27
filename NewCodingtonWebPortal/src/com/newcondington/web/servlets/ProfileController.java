package com.newcondington.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.base.IController;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController implements IController  {
	private static final long serialVersionUID = 1L;
       
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String urlDispatcher = "WEB-INF/views/profile.jsp";
	
	return urlDispatcher;
    }

}
