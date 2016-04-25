package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class LogoutController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String resp;

        if(request.getParameter("logout") != null){
            session.invalidate();
            resp = "redirect: login.jsp";
        }else if(session.getAttribute("username") != null){
            resp = "redirect: tickets.action";
        }else {
            resp = "login";
        }

        return resp;
    }
}
