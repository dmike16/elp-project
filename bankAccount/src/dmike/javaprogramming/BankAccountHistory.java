package dmike.javaprogramming;

public class BankAccountHistory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount mario = new BankAccount(130,0);
		
		mario.deposit(1000);
		mario.deposit(5000);
		mario.withdraw(1323);
		mario.withdraw(1323);
		mario.withdraw(1323);
		mario.deposit(1000);
		mario.deposit(1000);
		mario.deposit(1000);
		mario.deposit(1000);
		mario.deposit(1000);
		mario.withdraw(1323);
		mario.withdraw(6323);
		
		mario.history().all();
		System.out.println("Balance "+mario.getBalance());
		System.out.println(mario.idHistory(0));
		System.out.println(mario.idHistory(5));
	}
}
