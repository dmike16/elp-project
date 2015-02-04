package d.mike.example;

import java.nio.*;
import java.util.*;

public class RandomChar implements Readable{
    public RandomChar(int count){
        charNumb = count;
        bytes=new byte[count];
        rand.nextBytes(bytes);
    }
    public int read (CharBuffer cb){
        if(count-- == 0)
            return -1;
        for(int i=0; i<charNumb;i++){
            if(InAsciiCode(bytes[i]))
                cb.append((char)bytes[i]);
        }
        return charNumb;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(new RandomChar(13));
        while(s.hasNext())
            System.out.println(s.next());
    }
    private boolean InAsciiCode(byte bt){
        return (bt>=32 && bt<=126) ? true : false;
    }
    private static Random rand = new Random(87);
    private static int count=1;
    private int charNumb;
    private byte[] bytes;
}