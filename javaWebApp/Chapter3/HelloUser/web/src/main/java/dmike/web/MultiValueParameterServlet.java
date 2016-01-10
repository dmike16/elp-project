/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmike
 *
@WebServlet(
        name = "multiValue",
        urlPatterns = {"/checkboxes"}
)*/
public class MultiValueParameterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("   <head>\r\n")
                .append("       <title>Hello User Appp</title>")
                .append("    </head>\r\n")
                .append("   <body>\r\n")
                .append("       <form action=\"checkboxes\" method=\"POST\">\r\n")
                .append("<fieldset>").append("<legend>Select Your Fruits</legend>\r\n")
                .append("<p><label><input type=\"checkbox\" name=\"fruit\" value=\"Banana\"/>")
                .append(" Banana</label></p>\r\n")
                .append("<p><label><input type=\"checkbox\" name=\"fruit\" value=\"Apple\"/>")
                .append(" Apple</label></p>\r\n")
                .append("<p><label><input type=\"checkbox\" name=\"fruit\" value=\"Orange\"/>")
                .append(" Orange</label></p>\r\n")
                .append("<p><label><input type=\"checkbox\" name=\"fruit\" value=\"Guava\"/>")
                .append(" Guava</label></p>\r\n")
                .append("<p><label><input type=\"checkbox\" name=\"fruit\" value=\"Kiwi\"/>")
                .append(" Kiwi</label></p>\r\n")
                .append("        </fieldset>\r\n")
                .append("       <button type=\"Submit\">Submit</Button>\r\n")
                .append("       </form>\r\n")
                .append("   </body>\r\n")
                .append("</html>\r\n");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String[] fruits = request.getParameterValues("fruit");
        
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        
        PrintWriter writer = response.getWriter();
        
        writer.append("<!DOCTYPE html>\r\n")
                .append("<html>\r\n")
                .append("   <head>\r\n")
                .append("       <title>Hello User Appp</title>")
                .append("    </head>\r\n")
                .append("   <body>\r\n")
                .append("        <h2>Your Selection</h2>\r\n");
        
        if (fruits == null){
            writer.append("         <p>You dìd not select any fruits</p>\r\n");
        } else {
            writer.append("     <ul>\r\n");
            for(String fruit: fruits){
                writer.append("     <li>").append(fruit).append("</li>\r\n");
            }
            writer.append("     </ul>\r\n");
        }
        
        writer.append("     </body>\n")
                .append("</htnm>\r\n");
        
    }
    
}
