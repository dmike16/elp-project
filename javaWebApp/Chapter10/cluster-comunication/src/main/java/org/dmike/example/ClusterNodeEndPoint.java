package org.dmike.example;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by dmike on 26/06/16.
 * @author dmike
 */
@ServerEndpoint("/clusterNodeSocket/{nodeId}")
public class ClusterNodeEndPoint {

    @OnOpen
    public void onOpen(Session session, @PathParam("nodeId")String nodeId)
    {
        System.out.println("INFO: Node ["+ nodeId + "] connected to cluster.");
        ClusterMessage message = new ClusterMessage(nodeId,"Joined the cluster");

        try{
            byte[] bytes = ClusterNodeEndPoint.toByteArray(message);
            for(Session node : ClusterNodeEndPoint.nodes){
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        }catch (IOException e){
            System.err.println("ERROR: Exception when notifying new node");
            e.printStackTrace(System.err);
        }
        ClusterNodeEndPoint.nodes.add(session);
    }

    @OnMessage
    public void onMessage(Session session, byte[] message){
        try{
            for(Session node: ClusterNodeEndPoint.nodes)
            {
                if(node != session){
                    node.getBasicRemote().sendBinary(ByteBuffer.wrap(message));
                }
            }
        }catch (IOException e){
            System.err.println("ERROR: Exception when handling message on server");
            e.printStackTrace(System.err);
        }
    }

    @OnClose
    public void onClose(Session session, @PathParam("nodeId")String nodeId)
    {
        System.out.println("INFO: Node [" + nodeId + "] disconnected");
        ClusterNodeEndPoint.nodes.remove(session);

        ClusterMessage message = new ClusterMessage(nodeId,"Left the cluster");
        try{
            byte[] bytes = ClusterNodeEndPoint.toByteArray(message);
            for(Session node: ClusterNodeEndPoint.nodes)
            {
                node.getBasicRemote().sendBinary(ByteBuffer.wrap(bytes));
            }
        } catch (IOException e) {
            System.err.println("ERROR: Exception when notify of left cluster");
            e.printStackTrace(System.err);
        }
    }
    private static byte[] toByteArray(ClusterMessage message)
        throws IOException
    {
        try(ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream stream = new ObjectOutputStream(output))
        {
            stream.writeObject(message);
            return output.toByteArray();
        }
    }
    private static  final List<Session> nodes = new ArrayList<>(2);
}
