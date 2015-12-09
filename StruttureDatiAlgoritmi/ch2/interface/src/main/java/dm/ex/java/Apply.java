package dm.ex.java;

/**
 * Created by dmike on 08/12/15.
 * @author dmike
 */
public class Apply {
    public static void process(Processor p , Object s){
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
