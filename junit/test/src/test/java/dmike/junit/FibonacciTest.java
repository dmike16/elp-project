package dmike.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dmike on 21/04/17.
 * @author dmike
 */
@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameterized.Parameters(name = "{index} : f({0})={1}") public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {0,0},{1,1},{2,1}
        });
    }

    /*public FibonacciTest(int finput,int fexpected){
        this.finput = finput;
        this.fexpected = fexpected;
    }*/

    @Test public void test(){
        Assert.assertEquals(fexpected,Fibonacci.compute(finput));
    }

    @Parameterized.Parameter(0) public int finput;
    @Parameterized.Parameter(1) public int fexpected;

}
