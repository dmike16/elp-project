package app01a;

import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app01a.bean.Employee;
import app01a.bean.Product;
import app01a.bean.File;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
        	new ClassPathXmlApplicationContext("spring-config.xml");
            // new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
        
        /*
        System.out.println("product");
        Product product = context.getBean("product", Product.class);
        System.out.println("product: " + product);
        
        
        System.out.println("product1");
        Product product1 = context.getBean("featuredProduct", Product.class);
        product1.setName("Excellent snake oil");
        System.out.println("product1: " + product1.getName());
               
        System.out.println("");
        System.out.println("product2");
        Product product2 = context.getBean("featuredProduct", Product.class);
        System.out.println("product2: " + product2.getName());
        */
        /*
        System.out.println("");
        System.out.println("product3");
        product1.setName("Elbow oil");
        Product product3 = context.getBean("product", Product.class);
        System.out.println("product3: " + product3.getName());
        
        /*
        System.out.println("");
        System.out.println("featuredProduct a");        
        Product featuredProduct = context.getBean("featuredProduct", Product.class);
        //Product featuredProduct = (Product)context.getBean("featuredProduct");
        //Product featuredProduct = context.getBean(Product.class);
        System.out.println(featuredProduct.getName() + ", " + featuredProduct.getDescription()
                + ", " + featuredProduct.getPrice());
        /*
        System.out.println("");
        System.out.println("featuredProduct b");  
        featuredProduct.setName("AnotherProduct");
        Product featuredProductB = context.getBean("featuredProduct", Product.class);
        //Product featuredProduct = (Product)context.getBean("featuredProduct");
        //Product featuredProduct = context.getBean(Product.class);
        System.out.println(featuredProductB.getName() + ", " + featuredProductB.getDescription()
                + ", " + featuredProductB.getPrice());
        
        System.out.println("");
        System.out.println("featuredProduct2");        
        Product featuredProduct2 = context.getBean("featuredProduct2", Product.class);
        System.out.println(featuredProduct2.getName() + ", " + featuredProduct2.getDescription()
                + ", " + featuredProduct2.getPrice()); 
        
        
        System.out.println("");
        System.out.println("calendar");      
        Calendar calendar = context.getBean("calendar", java.util.Calendar.class);
        //Calendar calendar = context.getBean(java.util.Calendar.class);
        System.out.println(calendar.getTime());
        */
        System.out.println("");
        System.out.println("employee5");      
        Employee employee5 = context.getBean("employee5", Employee.class);
        System.out.println(employee5.getFirstName() + " " + employee5.getLastName());
        System.out.println(employee5.getHomeAddress());
        /*
        System.out.println("");
        System.out.println("employee2");      
        Employee employee2 = context.getBean("employee2", Employee.class);
        System.out.println(employee2.getFirstName() + " " + employee2.getLastName());
        System.out.println(employee2.getHomeAddress());
        
        System.out.println("");
        System.out.println("file");      
        File file = (File)context.getBean("file");
        System.out.println(file.getDoc().getName());
        
		*/
        
    }

}
