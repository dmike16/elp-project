package org.dmike;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrea on 10/04/16.
 * @author dmike
 */
public class CreateController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("username") == null){
            return "redirect: login.jsp";
        }
        String jsp;
        Ticket ticket = new Ticket();
        ticket.setCustomerName(((Customer)request.getSession().getAttribute("username")).getUsername());
        ticket.setSubject(request.getParameter("subject"));
        ticket.setComment(request.getParameter("comment"));

        Part file = request.getPart("attachment");
        if(file != null && file.getSize() > 0){
            Attachment attachment = upload(file);
            if(attachment != null){
                ticket.addAttachment(attachment);
            }
        }

        int id = (new TicketModel()).store(ticket);
        jsp = "redirect: view.action?action=view&ticketId="+id;
       return jsp;
    }

    private Attachment upload(Part file) throws IOException {
        InputStream input = file.getInputStream();
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int read;
        final byte[] bytes = new byte[1024];

        while((read = input.read(bytes)) != -1){
            output.write(bytes,0,read);
        }

        Attachment attachment = new Attachment();
        attachment.setName(file.getSubmittedFileName());
        attachment.setContents(output.toByteArray());

        return attachment;
    }
}
