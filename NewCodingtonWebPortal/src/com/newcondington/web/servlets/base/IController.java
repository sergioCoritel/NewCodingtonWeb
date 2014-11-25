package com.newcondington.web.servlets.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {

	String process(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
