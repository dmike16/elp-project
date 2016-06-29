package org.dmike.chat;

import org.dmike.Customer;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by dmike on 29/06/16.
 * @author dmike
 */
@ServerEndpoint(value="/chat/{sessionId}",
    encoders = ChatMessageCodec.class,
    decoders = ChatMessageCodec.class,
    configurator = ChatEndPoint.EndPointConfigurator.class)
@WebListener
public class ChatEndPoint implements HttpSessionListener {

    public static final List<ChatSession> pendingSession = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("sessionId")long sessionId)
    {
        HttpSession httpSession = (HttpSession)session.getUserProperties()
                .get(ChatEndPoint.HTTP_SESSION_PROPERTY);
        try
        {
            if(httpSession == null || httpSession.getAttribute("username") == null)
            {
                session.close(new CloseReason(
                        CloseReason.CloseCodes.VIOLATED_POLICY,
                        "You ara not logged in !"
                ));
                return;
            }
            String username = ((Customer)httpSession.getAttribute("username")).toString();
            session.getUserProperties().put("username",username);
            ChatMessage message = new ChatMessage();
            message.setTimestamp(OffsetDateTime.now());
            message.setUser(username);
            ChatSession chatSession;
            if(sessionId < 1)
            {
                message.setType(ChatMessage.Type.STARTED);
                message.setContent(username + " started the chat session");
                chatSession = new ChatSession();
                synchronized (ChatEndPoint.sessionIdSequenceLock)
                {
                    chatSession.setSessionId(ChatEndPoint.sessionIdSequence++);
                }
                chatSession.setCustomer(session);
                chatSession.setCustomerUsername(username);
                chatSession.setCreationMessage(message);
                ChatEndPoint.pendingSession.add(chatSession);
                ChatEndPoint.chatSessions.put(chatSession.getSessionId(),chatSession);
            }else
            {
                message.setType(ChatMessage.Type.JOINED);
                message.setContent(username+ " joined the chat session. ");
                chatSession = ChatEndPoint.chatSessions.get(sessionId);
                chatSession.setRepresentative(session);
                chatSession.setRepresentativeUsername(username);
                ChatEndPoint.pendingSession.remove(chatSession);
                session.getBasicRemote().sendObject(chatSession.getCreationMessage());
                session.getBasicRemote().sendObject(message);
            }

            ChatEndPoint.sessions.put(session,chatSession);
            ChatEndPoint.httpSessions.put(session,httpSession);
            this.getSessionFor(httpSession).add(session);
            chatSession.log(message);
            chatSession.getCustomer().getBasicRemote().sendObject(message);

        }catch (IOException | EncodeException e)
        {
            e.printStackTrace(System.err);
            this.onError(session,e);
        }
    }

    @OnMessage
    public void onMessage(Session session, ChatMessage message)
    {
        ChatSession c = ChatEndPoint.sessions.get(session);
        Session other = this.getOtherSession(c,session);

        if(c != null && other != null)
        {
            c.log(message);
            try
            {
                session.getBasicRemote().sendObject(message);
                other.getBasicRemote().sendObject(message);
            }catch (IOException | EncodeException e)
            {
                this.onError(session,e);
            }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason reason)
    {
        if(reason.getCloseCode() == CloseReason.CloseCodes.NORMAL_CLOSURE)
        {
            ChatMessage message = new ChatMessage();
            message.setUser((String)session.getUserProperties().get("username"));
            message.setType(ChatMessage.Type.LEFT);
            message.setTimestamp(OffsetDateTime.now());
            message.setContent(message.getUser() + " left the chat.");
            try
            {
                Session other = this.close(session,message);
                if(other != null)
                {
                    other.close();
                }
            }catch (IOException e)
            {
                e.printStackTrace(System.err);
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable e)
    {
        ChatMessage message = new ChatMessage();
        message.setUser((String)session.getUserProperties().get("username"));
        message.setType(ChatMessage.Type.ERROR);
        message.setTimestamp(OffsetDateTime.now());
        message.setContent(message.getUser() + " left the chat due to error");
        try
        {
            Session other = this.close(session,message);
            if(other != null)
            {
                other.close(new CloseReason(
                        CloseReason.CloseCodes.UNEXPECTED_CONDITION,e.toString()
                ));
            }
        }catch (IOException ignore){ /* Ignore Exception*/}
        finally
        {
            try
            {
                session.close(new CloseReason(
                        CloseReason.CloseCodes.UNEXPECTED_CONDITION,e.toString()
                ));
            }catch (IOException ignore){/* Ignore Exception*/}
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        /* Do Nothing*/
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent evt) {
        HttpSession httpSession = evt.getSession();
        if(httpSession.getAttribute(WS_SESSION_PROPERTY) != null)
        {
            ChatMessage message = new ChatMessage();
            message.setUser((String)httpSession.getAttribute("username"));
            message.setType(ChatMessage.Type.LEFT);
            message.setTimestamp(OffsetDateTime.now());
            message.setContent(message.getUser() + " logged out.");
            for(Session session: new ArrayList<>(this.getSessionFor(httpSession)))
            {
                try
                {
                    session.getBasicRemote().sendObject(message);
                    Session other = this.close(session,message);
                    if(other != null)
                    {
                        other.close();
                    }

                }catch (IOException | EncodeException e){
                    e.printStackTrace(System.err);
                }finally
                {
                    try
                    {
                        session.close();
                    }catch (IOException ignore){/* Ignore Exception*/}
                }
            }
        }
    }

    public static class EndPointConfigurator extends ServerEndpointConfig.Configurator
    {
        @Override
        public void modifyHandshake(ServerEndpointConfig config,
                                    HandshakeRequest request,
                                    HandshakeResponse response)
        {
            super.modifyHandshake(config,request,response);
            config.getUserProperties().put(
                    ChatEndPoint.HTTP_SESSION_PROPERTY,
                    request.getHttpSession()
            );
        }
    }
    @SuppressWarnings("unchecked")
    private synchronized ArrayList<Session> getSessionFor(HttpSession session)
    {
        try
        {
            if(session.getAttribute(WS_SESSION_PROPERTY) ==  null)
            {
                session.setAttribute(WS_SESSION_PROPERTY,new ArrayList<>());
            }
            return (ArrayList<Session>)session.getAttribute(WS_SESSION_PROPERTY);
        }catch (IllegalStateException e)
        {
            return new ArrayList<>();
        }
    }

    private Session close(Session s, ChatMessage message)
    {
        ChatSession c = ChatEndPoint.sessions.get(s);
        Session other = this.getOtherSession(c,s);
        ChatEndPoint.sessions.remove(s);
        HttpSession h = ChatEndPoint.httpSessions.get(s);
        if(h != null)
        {
            this.getSessionFor(h).remove(s);
        }
        if(c != null)
        {
            c.log(message);
            ChatEndPoint.pendingSession.remove(c);
            ChatEndPoint.chatSessions.remove(c.getSessionId());
            try
            {
                c.writeChatLog(new File("chat." + c.getSessionId() + ".log"));
            }catch (Exception e)
            {
                System.err.println("Could not write chat log.");
                e.printStackTrace(System.err);
            }
        }

        if(other != null)
        {
            ChatEndPoint.sessions.remove(other);
            h = ChatEndPoint.httpSessions.get(other);
            if(h != null)
            {
                this.getSessionFor(h).remove(s);
            }
            try
            {
                other.getBasicRemote().sendObject(message);
            }catch (IOException | EncodeException e)
            {
                e.printStackTrace(System.err);
            }
        }
        return other;
    }

    private Session getOtherSession(ChatSession c, Session s)
    {
        return c == null ? null:
                (s == c.getCustomer()? c.getRepresentative(): c.getCustomer());
    }

    private static final String HTTP_SESSION_PROPERTY = "org.dmike.HTTP_SESSION";
    private static final String WS_SESSION_PROPERTY = "org.dmike.WS_SESSION";
    private static long sessionIdSequence = 1L;
    private static final Object sessionIdSequenceLock = new Object();
    private static final Map<Long,ChatSession> chatSessions = new Hashtable<>();
    private static final Map<Session,ChatSession> sessions = new Hashtable<>();
    private static final Map<Session,HttpSession> httpSessions =
            new Hashtable<>();

}

