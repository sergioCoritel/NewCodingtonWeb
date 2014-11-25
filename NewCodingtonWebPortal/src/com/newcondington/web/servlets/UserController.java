package com.newcondington.web.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.base.IController;

public class UserController implements IController {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String urlDispatcher = "";
//		String action = params[1];
//		if (action.equals("list") || action.equals("new")) {
//			System.out.println("elegido listar o new user");
//		}
//		else{
//			int id = Integer.parseInt(params[2]);
//			if (action.equals("show")) {
//				System.out.println("elegido show user con id "+id);
//			}
//			if (action.equals("edit")) {
//				System.out.println("elegido edit user con id "+id);
//				urlDispatcher = "WEB-INF/views/edit_user.jsp";
//			}
//			
//		}
			return urlDispatcher;
	}

}
