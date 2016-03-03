package d.mike.example;

class NewThread implements Runnable{
	String name;
	Thread t;
	private boolean suspend;
	
	public NewThread(String name){
		this.name = name;
		t = new Thread(this,name);
		suspend = false;
		t.start();
	}
	@Override
	public void run(){
		try{
			for(int i = 15; i >= 0; i--){
				System.out.println(name + ": " + i);
				Thread.sleep(200);
				synchronized(this){
					while(suspend){
						wait();
					}
				}
			}
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		System.out.println("Exting");
	}
	void mySuspend(){
		 suspend = true;
	 }
	synchronized void resume(){
		suspend = false;
		notify();
	}
}

public class Suspend {
	public static void main(String[] args){
		NewThread t1 = new NewThread("One");
		NewThread t2 = new NewThread("Two");
		
		try{
			Thread.sleep(1000);
			t1.mySuspend();
			System.out.println("Suspending One");
			Thread.sleep(1000);
			t1.resume();
			System.out.println("Resuming One");
			t2.mySuspend();
			System.out.println("Suspending Two");
			Thread.sleep(1000);
			t2.resume();
			System.out.println("Resuming Two");
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		
		try{
			System.out.println("Join");
			t1.t.join();
			t2.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		
		System.out.println("Main thread bye");
	}
}
