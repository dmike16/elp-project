package cipolla;

public class NumberEmployeeDepartment {
	public NumberEmployeeDepartment(){}
	
	
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getNumberEmployees() {
		return numberEmployees;
	}
	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}
	
	@Override
	public String toString(){
		return "Dep ID: " + getDepartmentID() +"\n"+
				"Toatl Employess: "+ getNumberEmployees()+"\n";
	}


	private int departmentID;
	private int numberEmployees;
}
