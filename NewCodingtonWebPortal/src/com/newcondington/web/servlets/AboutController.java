package com.newcondington.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.base.IController;

/**
 * Servlet implementation class AboutController
 */
@WebServlet("/AboutController")
public class AboutController implements IController  {
	private static final long serialVersionUID = 1L;
       
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String urlDispatcher = "WEB-INF/views/about.jsp";
	
	return urlDispatcher;
    }

}