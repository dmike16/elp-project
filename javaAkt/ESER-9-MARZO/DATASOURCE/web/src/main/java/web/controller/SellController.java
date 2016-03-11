package web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dmike.util.web.Controller;
import util.VenditaForm;
import util.Vendite;
import web.db.ArticolDb;

public class SellController implements Controller{
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
		//TODO
		String jsp = "/WEB-INF/jsp/sellForm.jsp";

		VenditaForm vf = new VenditaForm();

		vf.setCode(request.getParameter("code"));
		vf.setQty(request.getParameter("qty"));
		vf.setBill(request.getParameter("bill"));

		VenditaValidator valid = new VenditaValidator();
		List<String> errors = valid.validate(vf);

		if(errors.isEmpty()){
			ArticolDb vdb = null;
			try{
				
				vdb = new ArticolDb();
				
				Vendite ven = new Vendite();
				
				ven.setCode(vf.getCode());
				ven.setNumber(vf.getBill());
				ven.setQty(Integer.parseInt(vf.getQty()));
				
				if(vdb.insert(ven,CacheControll.createCache(request.getSession())) < 0){
					throw new Exception("Non sono state inserite vendite");
				}
				jsp = "/WEB-INF/jsp/okay.jsp";
			}catch(Exception e){
				errors.add(e.getMessage());
			}finally{
				if(vdb != null){
					try{
						vdb.dispose();
					}catch(Exception e){
						errors.add(e.getMessage());
					}
				}
				if(!errors.isEmpty()){
					request.setAttribute("vendita", vf);
					request.setAttribute("errors", errors);
					try{
						request.setAttribute("codes", CacheControll.createCache(request.getSession()).getCache());
					}catch(Exception e){
						errors.add(e.getMessage());
					}
				}
			}

		}else{
			try{
				request.setAttribute("codes", CacheControll.createCache(request.getSession()).getCache());
			}catch(Exception e){
				errors.add(e.getMessage());
			}
			request.setAttribute("errors", errors);
			request.setAttribute("vendita", vf);
		}

		return jsp;
	}

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException
	{
		HttpSession session = request.getSession();

		ArticolDb adb = null;
		List<String> errors = new ArrayList<>();

		try{
			request.setAttribute("codes", CacheControll.createCache(session).getCache());
		}catch(Exception e){
			errors.add(e.getMessage());
			request.setAttribute("errors", errors);
		}finally{
			if(adb != null){
				try{
					adb.dispose();
				}catch(Exception e){
					errors.add(e.getMessage());
					request.setAttribute("errors", errors);
				}

			}
		}

		return "WEB-INF/jsp/sellForm.jsp";
	}
}
