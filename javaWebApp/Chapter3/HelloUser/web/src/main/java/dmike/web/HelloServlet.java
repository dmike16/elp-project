/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletContext;
/**
 *
 * @author dmike
 *
@WebServlet(
    name = "helloServlet",
    urlPatterns = {"/greeting","/salutation","/wazzup"},
    loadOnStartup = 1
)*/
public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
        System.out.println("Servlet " + this.getServletName() + " started");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName()+ " stopped");
    }
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException  
    {
        String user = request.getParameter("user");
        
        if (user == null){
            user = HelloServlet.DEFAULT_USER;
        }
        
        ServletContext sc = this.getServletContext();
        ServletConfig scc = this.getServletConfig();
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("   <head>\r\n")
                .append("       <title>Hello User Appp</title>")
                .append("    </head>\r\n")
                .append("   <body>\r\n")
                .append("       Hello, ").append(user).append("|<br/><br/>\r\n")
                .append("       <form action=\"greeting\" method=\"POST\">\r\n")
                .append("       <label>Enter Your Name:<br/>\r\n")
                .append("           <input type=\"text\" name=\"user\"/>\r\n")
                .append("       </label>\r\n")
                .append("       <button type=\"Submit\">Submit</Button>\r\n")
                .append("       </form>\r\n")
                .append("      <p> Setting One: " + sc.getInitParameter("settingOne")+"</p>")
                .append("      <p> Setting Two: " + sc.getInitParameter("settingTwo")+"</p>")
                .append("      <p> Setting LocalOne: " + scc.getInitParameter("database")+"</p>")
                .append("   </body>\r\n")
                .append("</html>\r\n");
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        this.doGet(request, response);
    }
    
    private static final String DEFAULT_USER = "Guest";
}
