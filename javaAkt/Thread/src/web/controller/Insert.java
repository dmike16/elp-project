package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.Book;
import web.model.BooksDb;
import web.model.DbPool;
import web.validate.BookForm;
import web.validate.BookValidator;
import web.validate.Validator;

public class Insert implements Controller{

	@Override
	public String handlerResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO
		return "/WEB-INF/jsp/insert.jsp";
	}
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO
		String jsp = "/WEB-INF/jsp/insert.jsp";
		BookForm bf = new BookForm();

		bf.setId(request.getParameter("idlibro"));
		bf.setTitle(request.getParameter("titolo"));
		bf.setAuthor(request.getParameter("autore"));
		bf.setPrice(request.getParameter("prezzo"));

		Validator<BookForm> bv = new BookValidator();
		List<String> errors = bv.validate(bf);

		if(errors.isEmpty()){
			BooksDb bkdb = null;
			try{
				Book bk = new Book();

				bk.setId(Integer.parseInt(bf.getId()));
				bk.setTitle(bf.getTitle());
				bk.setAuthor(bf.getAuthor());
				bk.setPrice(Integer.parseInt(bf.getPrice()));

				bkdb = new BooksDb(new DbPool());

				if(bkdb.insert(bk) < 0){
					throw new Exception("Libro non inserito al data base");
				}
				jsp="/WEB-INF/jsp/okay.jsp";
				request.setAttribute("book", bf);
				request.setAttribute("jsp", "inserisci.action");
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
			request.setAttribute("book", bf);
			request.setAttribute("errors", errors);
		}

		return jsp;
	}

}
