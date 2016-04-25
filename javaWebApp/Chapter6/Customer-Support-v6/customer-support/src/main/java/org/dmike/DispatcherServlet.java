package org.dmike;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
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

        if(view.contains("redirect:")){
            int index = view.lastIndexOf(":")+ 1;
            response.sendRedirect(view.substring(index,view.length()).trim());
        }else{
            System.out.println(addPrefixSuffix(view));
            request.getRequestDispatcher(addPrefixSuffix(view)).forward(request,response);
        }
    }

    private String controllerCaller(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        String jsp;


        String action = (request.getParameter("action") == null)? "list": request.getParameter("action");

        switch (action){
            case "createGet":
                jsp = (new ShowFormController()).handleRequest(request,response);
                break;
            case "createPost":
                jsp = (new CreateController()).handleRequest(request,response);
                break;
            case "download":
                jsp=(new DownloadController()).handleRequest(request,response);
                break;
            case "view":
                jsp = (new ViewTicketController()).handleRequest(request,response);
                break;
            case "logout":
                jsp = (new LogoutController()).handleRequest(request,response);
                break;
            case "login":
                jsp = (new LoginController()).handleRequest(request,response);
                break;
            case "list":
            default:
                jsp = (new ListController()).handleRequest(request,response);
                break;
        }


        return jsp;
    }

    private String addPrefixSuffix(String jsp){
        ServletConfig config = this.getServletConfig();

        String prefix = (config.getInitParameter("prefix")!= null?
            config.getInitParameter("prefix"):"");
        String suffix = (config.getInitParameter("suffix")!=null?
            config.getInitParameter("suffix"): "");

        return (prefix + jsp + suffix);
    }


}
