package d.mike.example;

class NewThread implements Runnable{
	private String name;
	Thread t;

	NewThread(String name){
		this.name = name;
		t = new Thread(this,this.name);
		System.out.println("New Thread " + t);
		t.start();
	}
	@Override
	public void run(){
		try{
			for(int i = 5; i >= 0; i--){
				System.out.println(name +":"+ i);
				Thread.sleep(200);
			}
		}catch(InterruptedException e){
			System.out.println("Interrpted thread: " + name);
		}
	}
}
class Clicker implements Runnable{
	long click = 0;
	Thread t;
	private volatile boolean running = true;

	Clicker(int p){
		t = new Thread(this);
		t.setPriority(p);
	}
	@Override
	public void run(){
		while(running){
			click++;
		}
	}
	public void stop(){
		running = false;
	}
	public void start(){
		t.start();
	}
}

class Callme{
	/*
	synchronized void call(String msg){
		System.out.print("[ "+ msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Interruped");
		}
		System.out.println("]");
	}
	 */
	void call(String msg){
		System.out.print("[ "+ msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Interruped");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable{
	String msg;
	Callme target;
	Thread t;

	Caller(Callme targ, String s){
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	@Override
	public void run(){
		synchronized(target){
			target.call(msg);
		}
	}
}

public class CurrentThread {
	public static void main(String[] args){
		/*NewThread t1 = new NewThread("Uno");
		NewThread t2 = new NewThread("Due");
		NewThread t3 = new NewThread("Tre");

		System.out.println("Thread one is alive:" + t1.t.isAlive());
		System.out.println("Thread two is alive:" + t2.t.isAlive());
		System.out.println("Thread three is alive:" + t3.t.isAlive());

		try{
			t1.t.join();
			t2.t.join();
			t3.t.join();
			System.out.println("Main thread derminated");
		}catch(InterruptedException e){
			System.out.println("Thread interrotto");
		}*/

		/*
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hc = new Clicker(Thread.NORM_PRIORITY +2);
		Clicker lc = new Clicker(Thread.NORM_PRIORITY -2);

		lc.start();
		hc.start();

		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}

		lc.stop();
		hc.stop();

		try{
			lc.t.join();
			hc.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}

		System.out.println("Low Thread : " + lc.click);
		System.out.println("High Thread : " + hc.click);
		 */

		Callme target = new Callme();
		Caller t1 = new Caller(target,"Hello");
		Caller t2 = new Caller(target,"Syncr");
		Caller t3 = new Caller(target,"World");

		try{
			t1.t.join();
			t2.t.join();
			t3.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}

	}

}
