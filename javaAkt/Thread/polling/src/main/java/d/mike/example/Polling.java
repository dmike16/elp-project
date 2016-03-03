package d.mike.example;

public class Polling {
	public static void main(String[] args){
		Q q = new Q();

		new Producer(q);
		new Consumer(q);
		
		System.out.println("CTRL-C to quit");
	}

}
