package d.mike.example;

public class Apply{
    public static void process(processor p, Object s){
        System.out.println("Using Processor"+ p.name());
        System.out.println(p.process(s));
    }
}