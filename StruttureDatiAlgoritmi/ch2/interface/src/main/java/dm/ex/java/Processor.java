package dm.ex.java;

/**
 * Created by dmike on 08/12/15.
 * @author dmike
 */
public interface Processor {
    String name();
    Object process(Object input);
}
