package org.dmike;

import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dmike on 29/06/16.
 * @author dmike
 */
public class ChatController implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Expires","Thu, 1 Jan 1970 12:00:00 GMT");
        response.setHeader("Cache-Control","max-age=0,must-revalidate,no-cache");

        String type = request.getParameter("type");
        switch (type){
            case "new":
                request.setAttribute("chatSessionId",0);
                return "chat/chat";
            case "join":
                String id = request.getParameter("chatSessionId");
                if(id == null || !NumberUtils.isDigits(id))
                {
                    return "chat/list";
                }else
                {
                    request.setAttribute("chatSessionId",Long.parseLong(id));
                    return "chat/chat";
                }
                default:
                    return "tickets";
        }

    }
}
