package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		return "WEB-INF/jsp/searchForm.jsp";
	}
	

}
