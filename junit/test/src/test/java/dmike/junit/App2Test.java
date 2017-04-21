package dmike.junit;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.junit.*;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmike on 18/04/17.
 * @author dmike
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class App2Test {
    public static String log;
    @Rule
    public Timeout global = Timeout.seconds(10);
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test public void testFalse(){
        Assert.assertFalse("Boolean - not false",false);
    }

    @Ignore("Test ignored for demostration")
    @Test public void testA(){
        System.out.println("[INFO] First");
    }

    @Test public void testB(){
        System.out.println("[INFO] Second");
    }

    @Test public void testC(){
        System.out.println("[INFO] Third");
    }

    @Test
    public void testArrayIndex(){
        List<Integer> out = new ArrayList<>();
        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index: 0, Size: 0");

        out.get(0);
    }

    @Test public void sleepToLong()throws Exception{
        log += "ran1";
        //TimeUnit.SECONDS.sleep(100);
    }

    @Test public void testBlockForever() throws Exception {
        log += "ran2";
        //latch.await();
    }

    private CountDownLatch latch = new CountDownLatch(1);
}
