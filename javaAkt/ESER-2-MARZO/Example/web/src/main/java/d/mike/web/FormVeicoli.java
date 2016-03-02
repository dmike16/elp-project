package d.mike.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormVeicoli extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TITLE= "Veicoli Form";

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException
	
	{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		FormVeicoli.head(out);
		out.println("<h1>"+FormVeicoli.TITLE+"</h1>");
		out.println("<p>Targa: "+request.getParameter("targa")+"</p>");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld = LocalDate.parse(request.getParameter("imm"),formatter);
		
		out.println("<p>Immatricolazione: "+ld+"</p>");
		out.println("<p>Cilindrata: "+request.getParameter("cilindrata")+"</p>");
		out.println("<p>KW: "+request.getParameter("kw")+"</p>");
		out.println("<p>Posti: "+request.getParameter("posti")+"</p>");
		out.println("<p>Velocita: "+request.getParameter("velocita")+"</p>");
		out.println("<p>Combustibile: "+request.getParameter("comb")+"</p>");
		out.println("<p>Categoria: "+request.getParameter("cat")+"</p>");
		FormVeicoli.footer(out);
		
	}
	private static void head(PrintWriter out){
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\"/>");
		out.println("<title>"+FormVeicoli.TITLE+"</title>");
		out.print("</head>");
		out.print("<body>");
	}
	private static void footer(PrintWriter out){
		out.println("</body>");
		out.println("</html>");
	}
	

}
