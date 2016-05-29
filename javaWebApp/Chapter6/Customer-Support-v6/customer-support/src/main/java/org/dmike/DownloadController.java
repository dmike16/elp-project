package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class DownloadController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsp = "listTickets";
        TicketModel elements = new TicketModel();
        String idS = request.getParameter("ticketId");

        try{
            Ticket tikt = elements.retrive(Integer.parseInt(idS));
            String name = request.getParameter("attachment");
            if(tikt != null && name != null){
                Attachment atch = tikt.getAttachment(name);
                if(atch != null){
                    response.setHeader("Content-Disposition","attachment; filename="
                    + atch.getName());
                    response.setContentType("application/octet-stream");

                    ServletOutputStream stream = response.getOutputStream();
                    stream.write(atch.getContents());
                }
            }
        }catch(Exception e){
            e.printStackTrace(System.err);
        }
        request.setAttribute("ticketDataBase",elements.retrive());
        return jsp;
    }
}
