package dmike.junit;


import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test public void evalutaroTest(){
        App eval = new App();
        int sum = eval.evalutaror("1+2+3");
        Assert.assertEquals(sum,6);
    }

    @Test public void testArrayEquals(){
        byte[] one = "trial".getBytes();
        byte[] two = "trial".getBytes();
        Assert.assertArrayEquals("Failure - byte array not the same",one,two);
    }

    @Test public void testEqual(){
        Assert.assertEquals("String - not equals","Test","Test");
    }

    @Test public void testNull(){
        Assert.assertNull("Object - Not null",null);
    }

    @Test(timeout = 1000) public void bothContainsString(){
        Assert.assertThat("albumen", CoreMatchers.both(CoreMatchers.containsString("a"))
        .and(CoreMatchers.containsString("b")));
    }

    @Test public void testAssume(){
        Assume.assumeThat(File.separatorChar,CoreMatchers.is('/'));
        Assert.assertFalse("Is always false",false);
    }
}
