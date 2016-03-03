package d.mike.example;

public class Producer implements Runnable{
	private Q q;
	
	Producer(Q q){
		this.q = q;
		(new Thread(this,"Producer")).start();
	}
	
	public void run(){
		int i = 0;
		
		while(true){
			q.put(i++);
		}
	}
}
