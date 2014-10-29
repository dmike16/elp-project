package dmike.javaprogramming;
import dmike.javaprogramming.TrafficLightColor;
import dmike.javaprogramming.Color;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


// Eser 6.1
/* 
enum TrafficLightColor {
	RED, YELLOW, GREEN,
} */
//Ese 6.1.1
/*
enum TrafficLightColor {
	RED, YELLOW, GREEN;
	
	public static int getSize (){return 3;}
}*/
 
// Ese 6.4
/*enum TrafficLightColor {
	RED(new Color("RED")),
	YELLOW(new Color("Yellow")),
	GREEN(new Color("Green"));
	
	Color lightColor;
	TrafficLightColor(Color color){
		lightColor =color;
	}
	
	public Color getColor(){ return lightColor;}
	
}*/
// Ese 6.5

public class SomeTest {
	@Test 
	public  void sample() {
		// TODO Auto-generated method stub
		
		TrafficLightColor sem =TrafficLightColor.RED ;
		
		System.out.println("Traffic Light: "+ sem);
		System.out.println("Traffic Light Color: "+ sem.getColor().toString());
		sem = TrafficLightColor.GREEN;
		//assertNotNull("shouldnotbeNull",sem);
		//assertEquals("failure not equal",sem.toString(),sem.getColor().getName());
		System.out.println("Traffic Light: "+ sem);
		System.out.println("Traffic Light Color: "+ sem.getColor().toString());
		System.out.println("Number of enum constant= "+ TrafficLightColor.values().length);
		System.out.println("Member GREEN: "+ TrafficLightColor.valueOf("GREEN"));
	}

}
