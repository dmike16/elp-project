package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.Book;
import web.model.BooksDb;
import web.model.DbPool;
import web.validate.AuthorForm;
import web.validate.AuthorValidate;
import web.validate.Validator;

public class Author implements Controller{

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jsp = "/WEB-INF/jsp/list.jsp";
		
		AuthorForm autf = new AuthorForm();
		
		autf.setName(request.getParameter("autore"));
		Validator<AuthorForm> autv = new AuthorValidate();
		List<String> errors = autv.validate(autf);
		
		if(errors.isEmpty()){
			BooksDb bkdb = null;
			
			try{
				bkdb = new BooksDb(new DbPool());
				List<Book> bks = bkdb.serachByAuthor(autf.getName());
				
				request.setAttribute("books", bks);
				jsp="/WEB-INF/jsp/okay.jsp";
				request.setAttribute("jsp", "cerca.action");
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
			request.setAttribute("errors",errors);
			request.setAttribute("author", autf);
		}
		
		
		return jsp;
	}

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "/WEB-INF/jsp/list.jsp";
	}

}
