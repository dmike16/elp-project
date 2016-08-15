/**
 * 
 */
package org.dmike.cuncurrencies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author andrea
 *
 */
class Car {
	private boolean waxOn=false;
	public synchronized void waxed(){
		waxOn = true;
		this.notifyAll();
	}
	public synchronized void buffed(){
		waxOn=false;
		this.notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn == false){
			this.wait();
		}
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn){
			this.wait();
		}
	}
}
class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c){car = c;}
	
	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				System.out.println("[INFO] Wax On!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		}catch(InterruptedException e){
			System.out.println("[INFO] Exit via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
	
}
class WaxOff implements Runnable{
	private Car car;
	public WaxOff(Car c){car = c;}
	
	@Override
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("[INFO] WAX OFF !");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		}catch(InterruptedException e){
			System.out.println("[INFO] Exit via interrupt");
		}
		System.out.println("Ending Wax OFF task");
	}
	
	
	
}
public class WaxOMatic {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();

	}

}
