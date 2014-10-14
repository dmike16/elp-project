package dmike.javaprogramming;

class BankAccount {
	private long number;
	private long balance;
	private int pos =0;
	private Action[] record;
	
	private class Action{
		private String act;
		private long amount;
		
		public Action(String act, long amount){
			this.act =act;
			this.amount =amount;
		}
		
		public String toString(){
			if(act.equals("New Account")){
				return number +": " + act +" " +amount;
			}
			else if(act.equals("withdraw")){
				return number +": " + act +" -"+amount;
			}
			else if(act.equals("deposit")){
				return number +": " + act +" +"+amount;
			}
			else
				return "Operation not permitted";
				
		}
	}
	
	private void reIndexHistory(){
		if(pos >= 10){
			--pos;
			for(int i=0; i<pos; i++){
				record[i] =record[i+1];
			}
		}
	}
	
	final class History{
		public void all(){
			for(int i=0; i<pos; i++)
				System.out.println(record[i]);
		}
	}
	
	public BankAccount(long number){
		this.number =number;
		balance =0;
		record =new Action[10];
		record[pos] = new Action("New Account",0);
		++pos;
	}
	
	public BankAccount(long number, long balance){
		this.number =number;
		this.balance =balance;
		record =new Action[10];
		record[pos] = new Action("New Account",balance);
		++pos;
	}
	
	public void deposit(long amount){
		balance += amount;
		reIndexHistory();
		record[pos] =new Action("deposit",amount);
		++pos;
	}
	
	public void withdraw(long amount){
		balance -= amount;
		reIndexHistory();
		record[pos] =new Action("withdraw",amount);
		++pos;
	}
	
	public History history(){
		return this.new History();
	}
	
	public Object idHistory(final int i){
		class indexHistory {
			public Action next(){
				if(i>=record.length){
					return null;
				}
				else
					return record[i];
			}
		}
		return new indexHistory().next();
	}
	
	public long getNumber(){
		return number;
	}
	
	public long getBalance(){
		return balance;
	}
}
