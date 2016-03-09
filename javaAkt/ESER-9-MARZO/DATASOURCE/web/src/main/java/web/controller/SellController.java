package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SellController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException
	{
		//TODO
		return " ";
	}
	
	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException
	{
		return "WEB-INF/jsp/sellForm.jsp";
	}
}
