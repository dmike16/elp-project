

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import d.mike.test.SomeTest;

public class runTest {
  public static void main(String[] args){
     Result result=JUnitCore.runClasses(SomeTest.class);
     for (Failure failure : result.getFailures()){
         System.out.println(failure.toString());
      }
      
      System.out.println(result.wasSuccessful());
  }
}
    