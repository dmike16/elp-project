package web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dmike.util.web.Controller;
import util.Articol;
import util.ArticolForm;
import web.db.ArticolDb;

public class UploadController implements Controller {
	@Override
	public String handlerRequest(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		String jsp="/WEB-INF/jsp/formUpload.jsp";
		
		ArticolForm af = new ArticolForm();
		af.setCode(request.getParameter("code"));
		af.setDescribe(request.getParameter("describe"));
		af.setInstock(request.getParameter("instock"));
		af.setPrice(request.getParameter("price"));

		ArticolValidate valid = new ArticolValidate();
		List<String> problems = valid.validate(af);

		if(problems.isEmpty()){
			
			HttpSession session = request.getSession();
			
			CacheControll codes = (CacheControll) session.getAttribute("codes"); 
			

			ArticolDb adb = null;

			try{
				adb = new ArticolDb();
				Articol art = new Articol();
				
				if(codes == null){
					codes = new CacheControll();
					codes.fillCache(adb.findAll());
					session.setAttribute("codes", codes);
				}
				
				//problems.add(codes.toString());
				//problems.add(ArticolDb.getCodsCached().toString());
				
				art.setCode(af.getCode());
				art.setDescription(af.getDescribe());
				art.setPrice(Float.parseFloat(af.getPrice()));
				art.setInstock(Integer.parseInt(af.getInstock()));
				
				if(adb.insertOrUpdate(art,codes) < 0){
					throw new Exception("Non inserito al database");
				}
				
				jsp = "/WEB-INF/jsp/okay.jsp";
			}catch(Exception e){
				problems.add(e.getMessage());
				request.setAttribute("errors", problems);
			}finally{
				try{
					adb.dispose();
				}catch(SQLException e){
					problems.add(e.getMessage());
				}
			}

		}else{
			request.setAttribute("articolo", af);
			request.setAttribute("errors", problems);
		}

		return jsp;
	}

	@Override
	public String handlerResponse(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		return "WEB-INF/jsp/formUpload.jsp";
	}
}
