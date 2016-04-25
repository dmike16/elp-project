package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class LoginController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("username")!= null){
            return "redirect: ticket.action";
        }
        String resp;

        Customer cust = new Customer();
        cust.setUsername(request.getParameter("username"));
        cust.setPassword(request.getParameter("password"));

        Map<String,String> errors = new HashMap<>();
        CustomerModel model = new CustomerModel();

        if(model.checkUserCredentials(cust,errors)){
            session.setAttribute("username",cust);
            request.changeSessionId();
            resp = "redirect: ticket.action";
        }else{
            request.setAttribute("errors",errors);
            request.setAttribute("inValue",cust.getUsername());
            resp = "login";
        }

        return resp;
    }
}
