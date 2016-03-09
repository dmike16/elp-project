package web.app;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.app.VeicoloForm;
import web.controller.Controller;

public class StoreData implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response){
		
		String jspForwardTo;
		VeicoloForm vf = new VeicoloForm();

		vf.setTarga(request.getParameter("targa"));
		vf.setModello(request.getParameter("modello"));
		vf.setImmatricolazione(request.getParameter("imm"));
		vf.setKw(request.getParameter("kw"));
		vf.setCilindrata(request.getParameter("cilindrata"));
		vf.setVelocita(request.getParameter("velocita"));
		vf.setPosti(request.getParameter("posti"));
		vf.setCat(request.getParameter("categoria"));
		vf.setComb(request.getParameter("combustibile"));
		

		VeicoloValidator vv = new VeicoloValidator();
		if(vv.validate(vf).isEmpty()){
			Veicolo v = new Veicolo();
			
			v.setTarga(vf.getTarga());
			v.setModello(vf.getModello());
			v.setKw(Float.parseFloat(vf.getKw()));
			v.setCilindrata(Float.parseFloat(vf.getCilindrata()));
			v.setVelocita(Float.parseFloat(vf.getVelocita()));
			v.setPosti(Integer.parseInt(vf.getPosti()));
			v.setCat(vf.getCat());
			v.setComb(vf.getComb());
			v.setImmatricolazione(LocalDate.parse(vf.getImmatricolazione()));

			
			try{
				VeicoloDb vdb = new VeicoloDb();
				
				if(vdb.addVeicolo(v) < 0){
					throw new Exception("Veicolo non Inserito al data base");
				}
				
				request.setAttribute("veicolo", v);
				jspForwardTo = "WEB-INF/jsp/storedVeicolo.jsp";
				vdb.getDbConnection().dispose();
			}catch(Exception e){
				vv.getErrors().add(e.getMessage());
				request.setAttribute("errors", vv.getErrors());
				request.setAttribute("form", vf);
				jspForwardTo = "WEB-INF/jsp/veicoloForm.jsp";
			}
			
		} else{
			request.setAttribute("errors", vv.getErrors());
			request.setAttribute("form", vf);
			jspForwardTo = "WEB-INF/jsp/veicoloForm.jsp";
		}
		
		return jspForwardTo;
	}
}
