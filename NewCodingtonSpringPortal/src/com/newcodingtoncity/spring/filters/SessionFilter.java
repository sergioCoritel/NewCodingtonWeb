package com.newcodingtoncity.spring.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newcodingtoncity.model.domain.users.User;


public class SessionFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public SessionFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		String action = ((HttpServletRequest) request).getServletPath();
		User user = (User) session.getAttribute("user");

		boolean login = action.equals("/index.htm");
		boolean validate_login = action.equals("/login.htm");
		boolean register = action.equals("/register.htm");
		boolean registerValidation = action.equals("/validate_register.htm");

		if (user == null && !login && !register && !validate_login && !registerValidation) {
			((HttpServletResponse) response).sendRedirect("index.htm");

		} else {
			chain.doFilter(request, response);

		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

	}
}