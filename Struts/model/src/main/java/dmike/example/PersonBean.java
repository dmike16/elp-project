package dmike.example;

public class PersonBean {
	private int age;
	private String userName;
	private String email;
	private String sport;
	private String residency;
	private String gender;
	private boolean over21;
	private String[] carModels;
	
	
	
	public String[] getCarModels() {
    return carModels;
  }
  public void setCarModels(String[] carModels) {
    this.carModels = carModels;
  }
  public boolean isOver21() {
    return over21;
  }
  public void setOver21(boolean over21) {
    this.over21 = over21;
  }
  public String getSport() {
    return sport;
  }
  public void setSport(String sport) {
    this.sport = sport;
  }
  public String getResidency() {
    return residency;
  }
  public void setResidency(String residency) {
    this.residency = residency;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
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
