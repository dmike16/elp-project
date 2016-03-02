package modulo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormDueServlet", urlPatterns = { "/formdue" })
public class FormDueServlet extends HttpServlet {
    private static final long serialVersionUID = 54L;
    private static final String TITLE = "Order Form";

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>" + TITLE + "</title></head>");
        writer.println("</head>");
        writer.println("<body><h1>" + TITLE + "</h1>");
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>Nome:</td>");
        writer.println("<td>" + request.getParameter("nome")
                + "</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Cognome:</td>");
        writer.println("<td>" + request.getParameter("cognome")
                + "</td>");
        writer.println("</tr>");
        writer.println("<tr>");
        writer.println("<td>Sesso:</td>");
        writer.println("<td>" + request.getParameter("sesso")
                + "</td>");
        writer.println("</tr>");
                
        writer.println("</table>");
        writer.println("<div style='border:1px solid #ddd;" +
        		"margin-top:40px;font-size:90%'>");

        writer.println("Debug Info<br/>");
        Enumeration<String> parameterNames = request
                .getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            writer.println(paramName + ": ");
            String[] paramValues = request
                    .getParameterValues(paramName);
            for (String paramValue : paramValues) {
                writer.println(paramValue + "<br/>");
            }
        }
  
        writer.println("</div>");
            
        writer.println("<br>");
        writer.println("<a href='OrderDueForm.html' >Modulo anagrafico </a>");
      
        writer.println("</body>");
        writer.println("</html>");
    }
}