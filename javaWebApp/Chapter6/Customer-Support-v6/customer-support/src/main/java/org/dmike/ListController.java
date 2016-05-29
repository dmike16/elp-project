package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class ListController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("ticketDataBase",(new TicketModel()).retrive());

        return "listTickets";
    }
}
