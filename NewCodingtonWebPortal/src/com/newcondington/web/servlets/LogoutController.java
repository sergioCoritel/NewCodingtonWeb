package com.newcondington.web.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcondington.web.servlets.base.IController;

public class LogoutController  implements IController  {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession sesion = request.getSession(true);
        sesion.invalidate();
		String urlDispatcher = "index.jsp";
		return urlDispatcher;
	}
}
