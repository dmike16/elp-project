package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
    static public void main(String [] args){
        LocalTime currentTime = new LocalTime();
        Greeter greeter = new Greeter();
        System.out.println("Time: " + currentTime);
        System.out.println(greeter.sayHello());
    }
}