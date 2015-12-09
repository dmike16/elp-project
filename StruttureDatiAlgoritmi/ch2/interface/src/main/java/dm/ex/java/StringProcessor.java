package dm.ex.java;

import java.util.Arrays;

/**
 * Created by dmike on 08/12/15.
 * @author dmike
 */
public abstract class StringProcessor implements Processor{
    @Override
    public String name(){
        return getClass().getSimpleName();
    }
    @Override
    public abstract String process(Object input);
    public static String s = "If she weighs the same as a duck, she's made of wood";
    public static void main(String[] args){
        Apply.process(new Upcase(),s);
        Apply.process(new DownCase(),s);
        Apply.process(new Splitter(),s);
        Apply.process(new Swaps(),s);
    }
}

class Upcase extends StringProcessor{
    @Override
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}

class DownCase extends StringProcessor{
    @Override
    public String process(Object input){
        return ((String)input).toLowerCase();
    }
}

class Splitter extends StringProcessor{
    @Override
    public String process(Object input){
        return Arrays.toString(((String)input).split(" "));
    }
}

class Swaps extends StringProcessor{
    public String process(Object input){
        String s = ((String)input);
        char[] t = new char[s.length()];

        for(int i = 0; i < t.length; i= i+2) {
            t[i] = s.charAt(i + 1);
            t[i + 1] = s.charAt(i);
        }
        return new String(t);
    }
}
