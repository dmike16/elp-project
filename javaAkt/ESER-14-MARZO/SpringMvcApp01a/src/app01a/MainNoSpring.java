package app01a;

import java.util.ArrayList;
import java.util.List;

import app01a.bean.Employee;
import app01a.bean.Address;
import app01a.bean.Product;

public class MainNoSpring {
    public static void main(String[] args) {
    	      
    	/*
        System.out.println("product");
        Product product1 = new Product("Ultimate Olive Oil", "The purest olive oil on the market", (float)9.95);        
        System.out.println("product1: " + product1.getName());
        product1.setName("Excellent snake oil");
        System.out.println("product1: " + product1.getName());
        */
        System.out.println("");
        System.out.println("employee1"); 
        Address address =  new Address("151 Corner Street", "", "Albany", "NY", "999999", "US");
        Employee employee1 = new Employee("Junior", "Moore", address);
        System.out.println(employee1.getFirstName() + " " + employee1.getLastName());
        System.out.println(employee1.getHomeAddress());
        
    	/*
        System.out.println("product");
        Product product1 = new Product("Ultimate Olive Oil", "The purest olive oil on the market", (float)9.95);        
        System.out.println("product1: " + product1.getName());
        product1.setName("Excellent snake oil");
        System.out.println("product1: " + product1.getName());

        List<Product> list = new ArrayList<>();
        list.add(product1);
        
        System.out.println("list.get(0): "+list.get(0));
        product1.setDescription("New Oil");
        System.out.println("list.get(0): "+list.get(0));
        */
    }

}
