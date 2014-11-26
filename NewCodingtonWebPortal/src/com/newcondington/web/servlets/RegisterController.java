package com.newcondington.web.servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.newcondington.web.servlets.base.IController;

public class RegisterController  implements IController  {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException {

		String urlDispatcher = "WEB-INF/views/register.jsp";	

		return urlDispatcher;

	}
}
