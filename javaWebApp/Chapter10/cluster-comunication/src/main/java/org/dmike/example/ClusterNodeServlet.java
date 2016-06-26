package org.dmike.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by dmike on 26/06/16.
 * @author dmike
 */
@ClientEndpoint
public class ClusterNodeServlet  extends HttpServlet
{

    @Override
    public void init()
        throws ServletException
    {
        this.nodeId = this.getInitParameter("nodeId");
        String path = this.getServletContext().getContextPath() +
                "/clusterNodeSocket/" + this.nodeId;
        try{
            URI uri = new URI("ws","localhost:8081",path,null,null);
            this.session = ContainerProvider.getWebSocketContainer()
                    .connectToServer(this,uri);
        }catch (URISyntaxException |IOException | DeploymentException e)
        {
            throw new ServletException("Cannot connect to WebSocket ");
        }
    }

    @Override
    public void destroy(){
        try{
            this.session.close();
        }catch (IOException e){
            e.printStackTrace(System.err);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException
    {
        ClusterMessage message = new ClusterMessage(this.nodeId,"" +
                "request:{ip:\"" + request.getRemoteAddr() +
        "\",queryString:\"" + request.getQueryString() + "\"}");

        try(OutputStream outputStream = this.session.getBasicRemote().getSendStream();
            ObjectOutputStream stream = new ObjectOutputStream(outputStream))
        {
            stream.writeObject(message);
        }
        response.getWriter().append("OK");
    }

    @OnMessage
    public void onMessage(InputStream input)
    {
        try(ObjectInputStream stream = new ObjectInputStream(input))
        {
            ClusterMessage message = (ClusterMessage)stream.readObject();
            System.out.println("INFO(Node " + this.nodeId +
            "): Message Recived from cluster; node = " +
            message.getNodeId() + ", message = " + message.getMessage());
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace(System.err);
        }
    }

    @OnClose
    public void onClose(CloseReason reason)
    {
        CloseReason.CloseCode code = reason.getCloseCode();
        if(code != CloseReason.CloseCodes.NORMAL_CLOSURE){
            System.err.println("ERROR: WebSocket connection closed unexpected;" +
                    " code = " + code + ", reson = " + reason.getReasonPhrase());
        }
    }

    private Session session;
    private String nodeId;
}
