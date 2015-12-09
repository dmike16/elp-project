package dm.ex.java;

/**
 * Created by dmike on 08/12/15.
 * @author dmike
 */
class WaveForm{
    private static long counter;
    private final long id = counter++;
    public String toString(){
        return "WaveForm " + id;
    }
}
class Filter{
    public String name(){
        return getClass().getSimpleName();
    }
    public WaveForm process(WaveForm input){
        return input;
    }
}
class LowPass extends Filter{
    public WaveForm process(WaveForm input){
        return input;
    }
    LowPass(double cutoff){
        this.coutoff = cutoff;
    }
    private double coutoff;
}
class HighPass extends Filter {
    public WaveForm process(WaveForm input){
        return input;
    }
    HighPass(double cutoff){
        this.cutoff = cutoff;
    }
    private double cutoff;
}

class FilterAdapter implements Processor{
    FilterAdapter(Filter filter){
        this.filter = filter;
    }
    @Override
    public String name(){
        return filter.name();
    }
    @Override
    public WaveForm process(Object input){
        return filter.process((WaveForm)input);
    }
    private Filter filter;
}
public class FilterProcessor {
    public static void main(String[] args){
        WaveForm w = new WaveForm();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new HighPass(2.0)),w);
    }
}
