package org.dmike;

import org.dmike.chat.ChatEndPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmike on 29/06/16.
 * @author dmike
 */
public class ChatListController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("sessions", ChatEndPoint.pendingSession);
        return "chat/list";
    }
}
