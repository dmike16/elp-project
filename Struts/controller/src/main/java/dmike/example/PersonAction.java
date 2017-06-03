package dmike.example;

import com.opensymphony.xwork2.ActionSupport;

public class PersonAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PersonBean personBean;

	public PersonBean getPersonBean() {
		return personBean;
	}

	public void setPersonBean(PersonBean personBean) {
		this.personBean = personBean;
	}
	
	@Override public String execute(){
		System.out.println("[INFO] EXECUTE");
		return SUCCESS;
	}
	
	@Override public String input(){
		System.out.println("[INFO] INPUT");
		return INPUT;
	}
	
	@Override public void validate(){
		if(personBean.getUserName().length() == 0){
			addFieldError("personBean.userName", "First Name is required");
		}
		
		if(personBean.getEmail().length() == 0){
			addFieldError("personBean.email", "Email required");
		}
		
		if(personBean.getAge() < 18){
			addFieldError("personBean.age", "Age is required and must be > 18");
		}
	}

}
