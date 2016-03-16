package example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args){
		ConfigurableApplicationContext  context;
		context = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		
		context.registerShutdownHook();
		
		Employee emp = context.getBean("employee", Employee.class);
		Employee empl = context.getBean("fillEmployee", Employee.class);
		empl.getAddr().setName("Via Guino Antonio Resti");
		empl.getAddr().setCity("Roma");
		empl.getAddr().setNumber("71");
		
		System.out.println(empl);
		
		Employes empls = context.getBean("employees", Employes.class);
		
		System.out.println(empls);
		
		System.out.println("Annotation: " + emp);
		
		
		context.close();
	}
}	
