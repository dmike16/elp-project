package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Book;
import utils.LibraryItem;

public class BookServlet extends HttpServlet{

	private static final long serialVersionUID = 1286831990485508131L;
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
			this.listBooks(response);
		}else if(uri.endsWith("/addbook")){
			this.addBook(request,response);
		}else if(uri.endsWith("/library")){
			this.showLib(request, response);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException
	{
		int qty = 0;
		
		try{
			qty = Integer.parseInt(request.getParameter("qty"));
		}catch(NumberFormatException e){
			throw new RuntimeException(e);
		}

		int id = Integer.parseInt(request.getParameter("id"));
		Book b = books.get(books.indexOf(new Book(id,"prova","prova")));

		if(b != null && qty >= 0){
			LibraryItem item = new LibraryItem(b,qty);
			HttpSession session = request.getSession();

			List<LibraryItem> library = (List<LibraryItem>) session.getAttribute(LIBRARY);
			if(library == null){
				library = new ArrayList<LibraryItem>();
				session.setAttribute(LIBRARY, library);
			}
			
			
			if(library.contains(item)){
				LibraryItem item1 = library.get(library.indexOf(item));
				item1.setQty(item1.getQty()+qty);
			}else{
				library.add(item);
			}
			
		}
		response.sendRedirect("books");
	}

	private void listBooks(HttpServletResponse response)
			throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BookServlet.header(out);

		out.append("<section>\n");
		out.append("<h1>List Books</h1>\n");

		for(Book b: books){
			out.append("<p>"+b.getTitle() +": " + b.getAuthor());
			out.append("(<a href=\"addbook?id="+ b.getId() +"\">Add</a>)</p>\n");
		}
		out.append("<a href=\"library\">Show Library</a>\n");
		out.append("</section>\n");
		BookServlet.footer(out);

	}

	private void addBook(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BookServlet.header(out);

		int id = 0;

		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch(NumberFormatException e){
			throw new RuntimeException(e);
		}

		out.append("<section>\n");
		out.append("<h1>Add Book</h1>\n");

		Book b = books.get(books.indexOf(new Book(id,"prova","prova")));

		out.append("<p>"+b.getTitle() +": " + b.getAuthor()+"</p>\n");

		out.append("<section>\n");
		out.append("<h2>Form Add Book</h2>\n");
		out.append("<form action=\"addbook\" method=\"post\">\n");
		out.append("<p><label for=\"qty\">Quantity</label>\n");
		out.append("<input name=\"qty\" id=\"qty\" type=\"number\" placehoder=\"quantity\"/></p>\n");
		out.append("<input name=\"id\" hidden value=\""+ id +"\"/>\n");
		out.append("<p><button type=\"submit\">Add</button></p>\n");
		out.append("</form>\n");
		out.append("</section>\n");

		out.append("</section>\n");
		BookServlet.footer(out);
	}

	@SuppressWarnings("unchecked")
	private void showLib(HttpServletRequest request, HttpServletResponse response)
			throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		BookServlet.header(out);

		HttpSession session = request.getSession();
		List<LibraryItem> library = (List<LibraryItem>) session.getAttribute(LIBRARY);
		
		if(library != null){
			out.append("<section><h1>Library</h1>\n");
			out.append("<ul>\n");
			for(LibraryItem lib: library){
				Book b = lib.getBook();
				int qty = lib.getQty();

				out.append("<li>"+b.getTitle()+" "+ b.getAuthor()+ " :qty " + qty);
				out.append("</li>\n");
			}
			out.append("</ul>\n");
			out.append("</section>\n");
		}else{
			out.append("<p>No Books </p>");
		}
		
		BookServlet.footer(out);

	}

	private static PrintWriter header(PrintWriter out){
		out.append("<!DOCTYPE html>\n");
		out.append("<html><head><meta charset=\"UTF-8\"/>\n");
		out.append("<title>List Books</title></head>\n");
		out.append("<body>\n");

		return out;
	}
	private static PrintWriter footer(PrintWriter out){
		out.append("</body></html>");

		return out;
	}
}
