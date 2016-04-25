package org.dmike;

/**
 * Created by andrea on 24/04/16.
 * @author dmike
 */
public class Attachment implements Cloneable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    @Override
    public Attachment clone(){
        try{
            Attachment  clone = (Attachment)super.clone();
            return clone;
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    private String  name;
    private byte[] contents;
}
