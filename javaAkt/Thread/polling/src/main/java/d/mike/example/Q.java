package d.mike.example;

public class Q {
	private int n;
	private boolean value = false;
	
	synchronized int get(){
		while(!value){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		}
		System.out.println("Get: " + n);
		value = false;
		notify();
		return n;
	}
	
	synchronized void put(int i){
		while(value){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("Interrupted");
			}
		}
		this.n = i;
		value = true;
		System.out.println("Put: "+ n);
		notify();
	}
}
