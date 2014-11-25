package com.newcondington.web.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcondington.web.servlets.base.IController;

public class EventsController  implements IController  {

	@Override
	public String process(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String urlDispatcher = "";
//		String action = params[1];
//		if (action.equals("list") || action.equals("new")) {
//			urlDispatcher = "WEB-INF/views/list_events.jsp";
//			System.out.println("elegido listar o new first");
//		}
//		else{
//			int id = Integer.parseInt(params[2]);
//			if (action.equals("show")) {
//				System.out.println("elegido show first con id "+id);
//			}
//			if (action.equals("edit")) {
//				System.out.println("elegido edit first con id "+id);
//				urlDispatcher = "WEB-INF/views/edit_first.jsp";
//			}
//			
//		}
			return urlDispatcher;
	}
}
