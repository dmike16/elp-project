package dmike.junit;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmike on 18/04/17.
 * @author dmike
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class App2Test {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test public void testFalse(){
        Assert.assertFalse("Boolean - not false",false);
    }

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
}
