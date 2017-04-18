package dmike.junit;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dmike on 18/04/17.
 * @author dmike
 */
public class App2Test {
    @Test public void testFalse(){
        Assert.assertFalse("Boolean - not false",false);
    }
}
