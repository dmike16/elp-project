package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handlerRequest(
			HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException;
	
	String handlerResponse(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException;
}
