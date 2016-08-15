/**
 * 
 */
package org.dmike.concurrencies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author andrea
 *
 */
class Count{
	private int count = 0;
	private Random rand = new Random(47);
	public synchronized int increment(){
		int temp = count;
		if(rand.nextBoolean()){
			Thread.yield();
		}
		return (count = ++temp);
	}
	public synchronized int getValue(){return count;}
}

class Entrance implements Runnable{

	private static Count count = new Count();
	private static List<Entrance> entrance = new ArrayList<Entrance>();
	private int number = 0;
	private final int id;
	private static volatile boolean cancelled = false;
	public static void cancel(){cancelled = true;}
	public Entrance(int id){
		this.id = id;
		entrance.add(this);
	}
	
	@Override
	public void run() {
		while(!cancelled){
			synchronized(this){
				++number;
			}
			System.out.println("[INFO] Total: " + count.increment());
			try{
				TimeUnit.MILLISECONDS.sleep(100);
			}catch(InterruptedException e){
				System.out.println("[ERROR] Interrpted: " + e.getMessage());
			}
		}
		System.out.println("[INFO] Stopping");
	}
	public synchronized int getValue(){return number;}
	
	@Override
	public String toString(){
		return "Entrance " + id + ": "+ getValue();
	}
	public static int getTotalCount(){return count.getValue();}
	public static int sumEntrance(){
		int sum = 0;
		for(Entrance e: entrance){
			sum += e.getValue();
		}
		return sum;
	}
	
}
public class OrnamentGarden {
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++){
			exec.execute(new Entrance(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println("[INFO] Some Tasks were not terminated");
		}
		System.out.println("[INFO] Total: " + Entrance.getTotalCount());
		System.out.println("[INFO] Sum :" + Entrance.sumEntrance()); 
		
	}
}
