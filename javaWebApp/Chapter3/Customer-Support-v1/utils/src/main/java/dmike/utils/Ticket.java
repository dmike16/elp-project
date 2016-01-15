/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmike.utils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author dmike
 */
public class Ticket {
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    public String getSubject(){
        return subject;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getBody(){
        return body;
    }
    public void setBody(String body){
        this.body = body;
    }
    public Attachment getAttachment(String name){
        return this.attachemnts.get(name);
    }
    public Collection<Attachment> getAttachments(){
        return this.attachemnts.values();
    }
    public void addAttachment(Attachment a){
        this.attachemnts.put(a.getName(), a);
    }
    public int getNumberOfAttachments(){
        return this.attachemnts.size();
    }
    private String customerName;
    private String subject;
    private String body;
    private final Map<String,Attachment> attachemnts = new LinkedHashMap<>();
}
