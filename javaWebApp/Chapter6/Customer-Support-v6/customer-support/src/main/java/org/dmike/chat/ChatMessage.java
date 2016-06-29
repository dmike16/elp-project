package org.dmike.chat;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * Created by dmike on 29/06/16.
 * @author dmike
 */
public class ChatMessage implements Serializable{
    public static  enum Type{
        STARTED,JOINED,ERROR,LEFT,TEXT
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private OffsetDateTime timestamp;
    private Type type;
    private String user;
    private String content;
}
