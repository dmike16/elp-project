package org.dmike.example;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int  value;
	App next;
    public static void main( String[] args )
    {
    	try{
    		App a1 = new App();
    		a1.value = 1;
    		App a = new App();
    		a.value = 17;
    		a.next = a1;
    		ByteArrayOutputStream o = new ByteArrayOutputStream();
    		ObjectOutputStream out = new ObjectOutputStream(o);
    		out.writeObject(a);
    		out.flush();
    		int i = 1;
    		for(byte bb : o.toByteArray()){
    			System.out.print(String.format("%02X", bb) + " ");
    			if(i%10 == 0){
    				System.out.println();
    			}
    		}
    		System.out.println();
    		o.close();
    		out.close();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
}
