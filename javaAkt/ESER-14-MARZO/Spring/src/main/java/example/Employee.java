package example;

public class Employee {
	private String name;
	private Address addr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public String toString(){
		return name + "\n"+
				addr;
	}
}
