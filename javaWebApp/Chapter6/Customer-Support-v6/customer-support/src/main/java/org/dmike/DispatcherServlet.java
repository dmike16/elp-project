package org.dmike;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 */
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        serverAction(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        serverAction(request,response);
    }

    private void serverAction(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        String view = controllerCaller(request,response);
        if(view.indexOf("redirect:") > -1){
            int index = view.indexOf("redirect:")+1;
            response.sendRedirect(
                    view.substring(index,view.length()).trim());
        }else{
            request.getRequestDispatcher(addPrefixSuffix(view)).forward(request,response);
        }
    }

    private String controllerCaller(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        String jsp = "index";

        if(request.getSession().getAttribute("username") == null){
            return "redirect: ticket.action?action=loginForm";
        }

        String action = (request.getParameter("action") == null)? "list": request.getParameter("action");

        switch (action){
            case "createGet":
                jsp = (new ShowFormController()).handleRequest(request,response);
                break;
            case "createPost":
                jsp = (new CreateController()).handleRequest(request,response);
                break;
            case "download":
                jsp=(new CreateController()).handleRequest(request,response);
                break;
            case "view":
                jsp = (new ViewTicketController()).handleRequest(request,response);
                break;
            case "loginForm":
                jsp = (new LoginController()).handleRequest(request,response);
                break;
            case "login":
                jsp = (new CreateController()).handleRequest(request,response);
                break;
            case "list":
            default:
                jsp = (new ListController()).handleRequest(request,response);
                break;
        }


        return jsp;
    }

    private String addPrefixSuffix(String jsp){
        ServletContext context = this.getServletContext();

        String prefix = (context.getInitParameter("prefix")!= null?
            context.getInitParameter("prefix"):"");
        String suffix = (context.getInitParameter("suffix")!=null?
            context.getInitParameter("suffix"): "");

        return (prefix + jsp + suffix);
    }


}
