package controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newcodingtoncity.model.domain.users.User;
import com.newcodingtoncity.model.domain.users.Visitor;
import com.newcodingtoncity.model.services.UserService;

@WebServlet(description = "It receives the form from a new user and creates a visitor", urlPatterns = { "/ServletFormularioUser" })
public class ServletFormularioUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletFormularioUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProccess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProccess(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doProccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		String name = request.getParameter("campoNombre");
		String lastname = request.getParameter("campoApellidos");
		String DNI = request.getParameter("campoDNI");
		String address = request.getParameter("campoDomicilio");
		String phone = request.getParameter("campoTelefono");
		String mail = request.getParameter("campoMail");
		String username = request.getParameter("campoUsername");
		String password = request.getParameter("campoPassword");
		
		//GUARDO EN LA BASE DATOS
		
		UserService userservice = new UserService();
		ServletConfig conf = getServletConfig();
		ServletContext context = conf.getServletContext();
		userservice.setContext(context);
		User u = new Visitor();
		
		u.setFirstName(name);
		u.setLastName(lastname);
		u.setDni(DNI);
		u.setAddress(address);
		u.setPhoneNumber(phone);
		u.setEmail(mail);
		u.setUserName(username);
		u.setPassword(password);
		
		userservice.registerNewVisitor(u);		
		
		response.sendRedirect("/NewCodingtonWebPortal/registered.jsp");
	}
}
