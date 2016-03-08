package web.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControlServlet extends HttpServlet{
	
	private static final long serialVersionUID = 8954202846995403420L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException
	{
		this.process(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		this.process(request,response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String dispatcher = null;
		String uri = request.getRequestURI();
		
		int index = uri.lastIndexOf('/');
		String callee = uri.substring(index + 1);
		
		//request.setAttribute("debug", uri);
		//request.getRequestDispatcher("WEB-INF/jsp/debug.jsp").forward(request, response);
		
		if(callee.equals("aggiungi_veicolo.action")){
			InputData in = new InputData();
			dispatcher = in.handlerRequest(request, response);
			
		} else if(callee.equals("store_veicolo.action")){
			StoreData st = new StoreData();
			dispatcher = st.handlerRequest(request, response);			
			
		}
		
		if(dispatcher != null){
			request.getRequestDispatcher(dispatcher).forward(request, response);
		}
	}
	
}
