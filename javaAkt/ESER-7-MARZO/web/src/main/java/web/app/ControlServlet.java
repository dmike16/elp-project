package web.app;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.app.VeicoloForm;

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
			dispatcher = "WEB-INF/jsp/veicoloForm.jsp";
			Veicolo tmp = new Veicolo();
			tmp.setImmatricolazione(LocalDate.now());
			request.setAttribute("veicolo", tmp);
		} else if(callee.equals("store_veicolo.action")){
			dispatcher = "WEB-INF/jsp/storedVeicolo.jsp";
			
			VeicoloForm vf = new VeicoloForm();
			
			vf.setTarga(request.getParameter("targa"));
			vf.setModello(request.getParameter("modello"));
			vf.setImmatricolazione(request.getParameter("imm"));
			vf.setKw(request.getParameter("kw"));
			
			// Possible Check on Data
			Veicolo v = new Veicolo();
			
			if(!this.controlData(vf, v)){
				dispatcher = "WEB-INF/jsp/veicoloForm.jsp";
				request.setAttribute("veicoloForm", vf);
			}
			
			request.setAttribute("veicolo", v);
		}
		
		if(dispatcher != null){
			request.getRequestDispatcher(dispatcher).forward(request, response);
		}
	}
	
	private boolean controlData(VeicoloForm vf, Veicolo v){
		
		v.setTarga(vf.getTarga());
		v.setModello(vf.getModello());
		
		try{
			v.setKw(Float.parseFloat(vf.getKw()));
			
			LocalDate tmp = LocalDate.parse(vf.getImmatricolazione());
			v.setImmatricolazione(tmp);
			
			return true;
		
		}catch(NumberFormatException e){
			v.setKw(0.0F);
		}catch(DateTimeParseException e){
			v.setImmatricolazione(null);
		}
		
		return false;
	}
}
