package example;

import java.util.List;
import java.util.Map;

public class Employes {
	private List<Employee> emps;
	private Map<String,Employee> pair;
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Map<String, Employee> getPair() {
		return pair;
	}
	public void setPair(Map<String, Employee> pair) {
		this.pair = pair;
	}
	@Override
	public String toString(){
		return "List: " + emps +"\n"+
				"Map: " + pair;
	}
	
}
