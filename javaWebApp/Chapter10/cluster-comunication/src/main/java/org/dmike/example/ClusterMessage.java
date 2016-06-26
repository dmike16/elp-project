package org.dmike.example;

import java.io.Serializable;

/**
 * Created by dmike on 26/06/16.
 * @author dmike
 */
public class ClusterMessage implements Serializable{
    public ClusterMessage() {
    }

    public ClusterMessage(String nodeId, String message) {
        this.nodeId = nodeId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    private String nodeId;
    private String message;
}
