package org.dmike.concurrencies;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new Timer().schedule(new TimerTask(){

			@Override
			public void run() {
				System.out.println("[INFO] Aborting...");
				System.exit(0);
				
			}
    		
    	}, 5000);
        System.out.println("[INFO] Start " + Thread.currentThread());
        //EvenChecker.test(new EvenGenerator());
        //EvenChecker.test(new SynchronizedEvenGenerator());
        //EvenChecker.test(new MutexEvenGenerator());
        EvenChecker.test(new AtomicEvenGenerator());
        System.out.println("[INFO] End" + Thread.currentThread());
    }
}
