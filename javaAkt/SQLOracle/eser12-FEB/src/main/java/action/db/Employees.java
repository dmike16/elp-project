package action.db;

import java.util.Date;

public class Employees {
	public Employees(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public float getPct() {
		return pct;
	}
	public void setPct(float pct) {
		this.pct = pct;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public int getDepID() {
		return depID;
	}
	public void setDepID(int depID) {
		this.depID = depID;
	}
	@Override
	public String toString(){
		return "ID: " + getId() +"\n"+
				"Name: " + getName() + "\n"+
				"Surname: " +getSurname()+"\n"+
				"Email: " +getEmail()+"\n"+
				"Phone: " +getPhone()+"\n"+
				"Hire_Date: " +getHireDate()+"\n"+
				"JobID: " +getJobID()+"\n"+
				"Salary: " +String.format("%.2f", getSalary())+"\n"+
				"PCT: " +getPct()+"\n"+
				"ManagerID: " +getManagerID()+"\n"+
				"DepID: " +getDepID();
	}

	private int id;
	private String name;
	private String surname;
	private String email;
	private String phone;
	private Date hireDate;
	private String jobID;
	private double salary;
	private float pct;
	private int managerID;
	private int depID;
	
}
