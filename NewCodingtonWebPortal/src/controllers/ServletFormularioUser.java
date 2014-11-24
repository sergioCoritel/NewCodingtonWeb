package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "It receives the form from a new user and creates a visitor", urlPatterns = { "/ServletFormularioUser" })
public class ServletFormularioUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFormularioUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProccess(request, response);
	}
	
	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("campoNombre");
		String lastname = request.getParameter("campoApellidos");
		String DNI = request.getParameter("campoDNI");
		String address = request.getParameter("campoDomicilio");
		String phone = request.getParameter("campoTelefono");
		String mail = request.getParameter("campoMail");
		String username = request.getParameter("campoUsername");
		String password = request.getParameter("campoPassword");
		
		//GUARDO EN LA BASE DATOS
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registered.jsp?" + "username=" + username);
		dispatcher.forward(request, response);
	}
}
