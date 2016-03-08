package web.app;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.app.VeicoloForm;
import web.controller.Controller;

public class StoreData implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response){

		VeicoloForm vf = new VeicoloForm();

		vf.setTarga(request.getParameter("targa"));
		vf.setModello(request.getParameter("modello"));
		vf.setImmatricolazione(request.getParameter("imm"));
		vf.setKw(request.getParameter("kw"));

		VeicoloValidator vv = new VeicoloValidator();
		if(vv.validate(vf).isEmpty()){
			Veicolo v = new Veicolo();
			
			v.setTarga(vf.getTarga());
			v.setModello(vf.getModello());
			v.setKw(Float.parseFloat(vf.getKw()));

			LocalDate tmp = LocalDate.parse(vf.getImmatricolazione());
			v.setImmatricolazione(tmp);
			request.setAttribute("veicolo", v);
			
			return "WEB-INF/jsp/storedVeicolo.jsp";
		} else{
			request.setAttribute("errors", vv.getErrors());
			request.setAttribute("form", vf);
			return "WEB-INF/jsp/veicoloForm.jsp";
		}
	}
}
