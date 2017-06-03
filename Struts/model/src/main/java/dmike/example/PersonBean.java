package dmike.example;

public class PersonBean {
	private int age;
	private String userName;
	private String email;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override public String toString(){
		return String.format("UserName: %s, Email: %s, Age: %s", userName,email,age);
	}
	
}
