package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.Book;
import web.model.BooksDb;
import web.model.DbPool;
import web.validate.SearchForm;
import web.validate.SearchValidator;
import web.validate.Validator;

public class Search implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsp = "/WEB-INF/jsp/search.jsp";

		SearchForm schf = new SearchForm();
		schf.setId(request.getParameter("idlibro"));

		Validator<SearchForm> schv = new SearchValidator();
		List<String> errors = schv.validate(schf);

		if(errors.isEmpty()){
			BooksDb bkdb = null;
			try{
				bkdb = new BooksDb(new DbPool());

				Book bk = bkdb.serachById(Integer.parseInt(schf.getId()));

				
				jsp = "/WEB-INF/jsp/okay.jsp";
				request.setAttribute("book", bk);
				request.setAttribute("jsp","consulta.action");
			}catch(Exception e){
				errors.add(e.getMessage());
			}finally{

				if(bkdb != null){
					try{
						bkdb.dispose();
					}catch(Exception e){
						errors.add(e.getMessage());
					}
				}

				if(!errors.isEmpty()){
					request.setAttribute("errors", errors);
				}
			}
		}else{
			request.setAttribute("errors", errors);
			request.setAttribute("search", schf);
		}
		return jsp;
	}

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/WEB-INF/jsp/search.jsp";
	}

}
