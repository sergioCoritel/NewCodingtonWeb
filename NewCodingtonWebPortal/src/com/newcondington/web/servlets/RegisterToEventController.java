package com.newcondington.web.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.base.IController;

public class RegisterToEventController  implements IController  {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String urlDispatcher = "WEB-INF/views/register.jsp";	
	return urlDispatcher;
    }
}
