package d.mike.example;
import java.util.*;

public abstract class StringProcessor implements processor{
    public String name(){
        return getClass().getSimpleName();
    }
    public abstract String process(Object input);
    public static String s= "javacomplete";
    public static void main(String[] args){
        Apply.process(new SwapCh(),s);
    }
}


class SwapCh extends StringProcessor{
    public String process(Object input){
        String s = (String) input;
        char[] ac = s.toCharArray();
        char pos1,pos2;
        
        for (int i=0; i<s.length()-1; i=i+2){
            pos1=ac[i];
            pos2=ac[i+1];
            ac[i]=pos2;
            ac[i+1]=pos1;
        }
        return String.valueOf(ac);
    }
}