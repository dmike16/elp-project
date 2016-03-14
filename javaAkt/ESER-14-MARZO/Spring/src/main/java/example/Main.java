package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		ApplicationContext  context;
		context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		
		Employee empl = context.getBean("fillEmployee", Employee.class);
		empl.getAddr().setName("Via Guino Antonio Resti");
		empl.getAddr().setCity("Roma");
		empl.getAddr().setNumber("71");
		
		System.out.println(empl);

	}
}	
