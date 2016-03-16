package example;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private String name;
	/*@Autowired
	@Qualifier("main")*/
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
	@Resource(name="address1")
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	
	public String toString(){
		return name + "\n"+
				addr;
	}
}
