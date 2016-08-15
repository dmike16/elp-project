package org.dmike.concurrencies;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable{

	public EvenChecker(IntGenerator g,int id){
		this.gen = g;
		this.id = id;
	}
	
	public static void test(IntGenerator g,int count){
		System.out.println("[INFO] Press C-CTRL to exit");
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < count; i++){
			exec.execute(new EvenChecker(g,i));
		}
		exec.shutdown();
	}
	
	public static void test(IntGenerator g){
		test(g,10);
	}
	
	public void run() {
		while(!gen.isConcelled()){
			int val = gen.next();
			if((val & 1) != 0){
				System.out.println("[INFO] " + val + " not even");
				gen.concel();
			}
		}
	}

	private IntGenerator gen;
	private final int id;
}
