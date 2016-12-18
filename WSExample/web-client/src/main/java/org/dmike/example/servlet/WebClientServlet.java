package org.dmike.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import org.dmike.example.HelloSEI;
import org.dmike.example.HelloSEIImplService;

@WebServlet(name = "WebClientServlet", urlPatterns = { "/WebClientServlet" })
public class WebClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@WebServiceRef(wsdlLocation = "http://localhost:8080/webserver/HelloSEIImplService?wsdl")
	private HelloSEIImplService service = new HelloSEIImplService();
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws IOException,ServletException
	{
		processRequest(request,response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html;charset-UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<title>Servlet HelloServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
		out.println("<p>" + sayHello("world") + "</p>");
		out.println("</body>");
		out.println("</html>");

	}

	private String sayHello(String message) {
		HelloSEI port = service.getHelloSEIImplPort();

		return port.sayHelloTo(message);
	}
}
