package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException
	{
		//TODO
		String jsp = this.dispatcher(request, response);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
			//TODO
		String jsp = this.dispatcher(response, request);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	private String dispatcher(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException
	{
		//TODO
		String jsp = "index.html";
		
		String[] uri = request.getRequestURI().split("/");
		String callee = uri[uri.length -1];
		
		switch(callee){
		case "inserisci.action":
			Insert ins = new Insert();
			jsp = ins.handlerResponse(request, response);
			break;
		case "consulta.action":
			Search sch = new Search();
			jsp = sch.handlerResponse(request, response);
			break;
		case "cerca.action":
			Author aut = new Author();
			jsp = aut.handlerResponse(request, response);
			break;
		default:
			break;
		}
		
		
		return jsp;
	}
	
	private String dispatcher(HttpServletResponse response, HttpServletRequest request)
		throws ServletException, IOException
	{
		//TODO
		String jsp = "index.html";
		
		String[] uri = request.getRequestURI().split("/");
		String callee = uri[uri.length -1];
		
		switch(callee){
		case "inserisci.action":
			Insert ins = new Insert();
			jsp = ins.handlerRequest(request, response);
			break;
		case "consulta.action":
			Search sch = new Search();
			jsp = sch.handlerRequest(request, response);
			break;
		case "cerca.action":
			Author aut = new Author();
			jsp = aut.handlerRequest(request, response);
			break;
		default:
			break;
		}
		
		
		return jsp;
	}

}
