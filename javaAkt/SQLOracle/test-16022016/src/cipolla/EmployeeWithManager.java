package cipolla;

import java.util.Date;

public class EmployeeWithManager {
	public EmployeeWithManager(){}
	
	
	
	public String getEmplName() {
		return emplName;
	}
	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}
	public String getEmplLast() {
		return emplLast;
	}
	public void setEmplLast(String emplLast) {
		this.emplLast = emplLast;
	}
	public String getManaName() {
		return manaName;
	}
	public void setManaName(String manaName) {
		this.manaName = manaName;
	}
	public String getManaLast() {
		return manaLast;
	}
	public void setManaLast(String manaLast) {
		this.manaLast = manaLast;
	}
	public Date getManaHireDate() {
		return manaHireDate;
	}
	public void setManaHireDate(Date manaHireDate) {
		this.manaHireDate = manaHireDate;
	}
	@Override
	public String toString(){
		return "Employee Name: " + getEmplName()+"\n"+
				"Employee Last Name: " + getEmplLast()+"\n"+
				"Manager Name: " +getManaName()+"\n"+
				"Manager Last: " +getManaLast()+"\n"+
				"Manager Hire Date. " +getManaHireDate()+ "\n";
	}



	private String emplName;
	private String emplLast;
	private String manaName;
	private String manaLast;
	private Date manaHireDate;
}
