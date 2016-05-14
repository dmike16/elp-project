package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class ViewTicketController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username") == null){
            return "redirect: login.jsp";
        }
        String idString = request.getParameter("ticketId");
        Ticket ticket = null;
        String jsp;
        try{
            if(idString == null || idString.isEmpty()){
                jsp = "redirect: index.jsp";
            }else{
                ticket = (new TicketModel()).retrive(Integer.parseInt(idString));
                if(ticket == null){
                    jsp = "redirect: index.jsp";
                }else{
                    jsp = "viewTicket";
                    request.setAttribute("ticketId",idString);
                    request.setAttribute("ticket",ticket);
                }
            }
        }catch (Exception e){
            jsp ="redirect: index.jsp";
        }
        return jsp;
    }
}
