package web.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.controller.SearchController;
import web.controller.SellController;
import web.controller.UploadController;

public class ArticolController extends HttpServlet{
	 private static final long serialVersionUID = 5210116106169182509L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String dispTo = this.dispatcher(request, response);
		request.getRequestDispatcher(dispTo).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String dispTo = this.dispatcher(response, request);
		request.getRequestDispatcher(dispTo).forward(request, response);
	}
	
	private String dispatcher(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String forwardTo = "index.html";
		
		String[] uri = request.getRequestURI().split("/");
		String callee = uri[uri.length -1];
		
		switch(callee){
		
		case "upload.action":
			UploadController upc = new UploadController();
			forwardTo = upc.handlerResponse(request, response);
			break;
		case "sell.action":
			SellController slc = new SellController();
			forwardTo = slc.handlerResponse(request, response);
			break;
		case "search.action":
			SearchController shc = new SearchController();
			forwardTo = shc.handlerResponse(request, response);
			break;
		default:
			break;
		}
		
		return forwardTo;
	}
	
	private String dispatcher(HttpServletResponse response,HttpServletRequest request)
			throws ServletException, IOException
		{
			String forwardTo = "index.html";
			
			String[] uri = request.getRequestURI().split("/");
			String callee = uri[uri.length -1];
			
			switch(callee){
			
			case "upload.action":
				UploadController upc = new UploadController();
				forwardTo = upc.handlerRequest(request, response);
				break;
			case "sell.action":
				SellController slc = new SellController();
				forwardTo = slc.handlerRequest(request, response);
				break;
			case "search.action":
				SearchController shc = new SearchController();
				forwardTo = shc.handlerRequest(request, response);
				break;
			default:
				break;
			}
			
			return forwardTo;
		}
}
