package action.db;

public class LabGroupComponenti {
	public LabGroupComponenti(){}
	
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString(){
		return "Lab: " + getCod() +"\n" +
				"Ncomp: " + getCount();
	}

	private String cod;
	private int count;
}
