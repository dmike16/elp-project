package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Book;

public class BookServlet extends HttpServlet{
	
	private static final String LIBRARY = "library";
	private List<Book> books = new ArrayList<>();
	
	@Override 
	public void init()
		throws ServletException
	{
		books.add(new Book(1,"The Lord Of The Ring","J.R.K Tolkien"));
		books.add(new Book(2,"The Hobbit","J.R.K Tolkien"));
		books.add(new Book(3,"Java The Complete Refecerency","Shiled"));
		books.add(new Book(4,"Due di Due","Andrea di Carlo"));
		books.add(new Book(5,"Sherlock Holmes","Sir Artur Conan Doyle"));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		String uri = request.getRequestURI();
		
		if(uri.endsWith("/books")){
			listBooks(response);
		}else if(uri.endsWith("/addbook")){
			
		}else if(uri.endsWith("/showlibrary")){
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException
	{
		
	}
	
	private void listBooks(HttpServletResponse response)
		throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}
	
	private static PrintWriter header(PrintWriter out){
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset=\"UTF-8\"/>");
		out.println("<title>List Books</title></head>");
		out.println("<body>");
		
		return out;
	}
	private static PrintWriter footer(PrintWriter out){
		out.println("</body></html>");
		
		return out;
	}
}
