package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dmike.util.web.Controller;
import dmike.util.web.Validator;
import util.SearchForm;

public class SearchController implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String jsp = "/WEB-INF/jsp/searchForm.jsp";
		SearchForm sch = new SearchForm();
		
		sch.setCode(request.getParameter("code"));
		sch.setDescribe(request.getParameter("describe"));
		
		Validator<SearchForm> valid = new SearchValidate();
		List<String> errors = valid.validate(sch);
		
		errors.add(sch.getDescribe());
		if(errors.isEmpty()){
			
		}else{
			request.setAttribute("errors", errors);
			request.setAttribute("search", sch);
		}
		
		return jsp;
	}

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		return "WEB-INF/jsp/searchForm.jsp";
	}
	

}
