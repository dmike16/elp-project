package app02a.catalogo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Top10ItemServlet", urlPatterns = { "/catalogo" })

public class Top10ItemServlet extends HttpServlet {

	private List<Disco> dischi;
	private List<Libro> libri;


	@Override
	public void init() throws ServletException 	{
		dischi = new ArrayList<>();
		dischi.add(new Disco("1", "Sgt. Pepper's Lonely Hearts Club Band", "The Beatles"));
		dischi.add(new Disco("2", "Stairway to Heaven", "Led Zeppelin"));
		dischi.add(new Disco("3", "Songs of Leonard Cohen", "Lonard Cohen"));
		dischi.add(new Disco("4", "La mauvaise réputation", "Georges Brassens"));
		dischi.add(new Disco("5", "Les Flamandes", "Jacques Brel"));
		libri = new ArrayList<>();
		libri.add(new Libro("1", "Flatland", "Edwin Abbot Abbot"));
		libri.add(new Libro("2", "The Road to Eleusis", "Albert Hoffman"));
		libri.add(new Libro("3", "The Antipodes of the Mind", "Benny Shanon"));
		libri.add(new Libro("4", "Hyperspace", "Michio Kaku"));
		libri.add(new Libro("5", "A Leg to Stand on", "Oliver Sacks"));
	}


	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {

		String catalogo = request.getParameter("catalogo");
		if (catalogo != null && 
				(catalogo.equals("libri") || catalogo.equals("dischi"))) {
			showCatalog(response, catalogo);
		} else {
			showMainPage(request, response);
		}

	}

	private void showMainPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>" +
				"<title>Top 10 Items</title>" +
				"</head><body>" + 
				"Please select a catalog:" +
				"<br/><a href='?catalogo=libri'>Libri</a>" +
				"<br/><a href='?catalogo=dischi'>Dischi</a>" +
				"</body></html>");
	}

	private void showCatalog(
			HttpServletResponse response, String catalogo) 
					throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head>" +
				"<title>Catalog</title>" +
				"</head><body>");
		writer.println("<a href='catalogo'>Select Catalog</a><br> ");

		if (catalogo.equals("libri")) {
			for (Libro l: libri) {
				writer.println(l + "<br/>");
			};
		}
		if (catalogo.equals("dischi")) {
			for (Disco d: dischi) {
				writer.println(d + "<br/>");
			};
		}
		writer.println("</body></html>");
	}
}
