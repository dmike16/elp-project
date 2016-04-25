package org.dmike;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by andrea on 24/04/16.
 * @author dmike
 */
public class Ticket implements Cloneable{

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Attachment getAttachment(String name) {
        return attachments.get(name);
    }

    public Collection<Attachment> getAttachments(){
        return attachments.values();
    }

    public void addAttachment(Attachment file) {
        attachments.put(file.getName(),file);
    }

    public int getNumberOfAttachments(){
        return attachments.size();
    }

    public Ticket clone(){
        try{
            Ticket clone = (Ticket)  super.clone();
            clone.attachments = new LinkedHashMap<>();
            for(String key: attachments.keySet()){
                clone.attachments.put(key,this.attachments.get(key).clone());
            }
            return clone;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;

        }
    }

    private String customerName;
    private String subject;
    private String comment;
    private Map<String,Attachment> attachments = new LinkedHashMap<>();
}
