package action.db;

public class Users {
	public Users(){}
	
    public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getUserName(){
		return name;
	}
	public void setUserName(String s){
		name = s;
	}
	public String getPassw(){
		return passw;
	}
	public void setPassw(String s){
		passw = s;
	}
	public String getName(){
		return fullname;
	}
	public void setName(String n){
		fullname = n;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String s){
		email = s;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double d){
		salary = d;
	}
	public int getIdType(){
		return idType;
	}
	public void setIdType(int id){
		this.idType = id;
	}
	
	@Override
	public String toString(){
		return "Id:	" + id + "\n"+
				"UserName: " + name + "\n" +
				"Passw: " + passw.replaceAll("[\\w\\d]+", "*") +"\n" +
				"Name: " + fullname + "\n" +
				"Email: " + email + "\n" +
				"Salary: " + String.format("%.2f", salary) + "€\n" +
				"Id Type: " + idType + "\n";
	}
	
	private int id;
	private String name;
	private String passw;
	private String fullname;
	private String email;
	private double salary;
	private int idType;
}
