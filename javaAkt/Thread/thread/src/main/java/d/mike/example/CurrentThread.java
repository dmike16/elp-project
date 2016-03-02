package d.mike.example;

public class CurrentThread {
	public static void main(String[] args){
		Thread t = Thread.currentThread();
		
		System.out.println("Current thread" + t);
		t.setName("Pippo");
		System.out.println("Now Thread: " + t);
		
		try{
			for(int i = 5; i >= 0; i--){
				System.out.println(i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println("Thread interrotto");
		}
		
		
	}
}
