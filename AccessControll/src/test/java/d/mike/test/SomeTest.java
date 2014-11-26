package d.mike.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import d.mike.example.ConnectionManager;
import d.mike.example.Connection;
/**
 * Created by dmike on 25/11/14.
 */
public class SomeTest {
    @Test
    public void sample(){
        Connection co1=ConnectionManager.getConn();
        for(;co1 != null;co1=ConnectionManager.getConn())
            System.out.println("Connection : " + co1.getType() +
            " id: " + co1.getId());
    }
}
