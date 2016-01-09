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
/**
 *
 * @author dmike
 */
public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet "+ this.getServletName() + " has started" );
    }
    @Override
    public void destroy(){
        System.out.println("Servlet " + this.getServletName()+ " has stopped");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.getWriter().println("Hello, World");
    }
}
