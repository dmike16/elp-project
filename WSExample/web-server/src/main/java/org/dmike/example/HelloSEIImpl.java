package org.dmike.example;

import javax.jws.WebService;

@WebService(endpointInterface="org.dmike.example.HelloSEI",
serviceName="HelloSEIImplService")
public class HelloSEIImpl implements HelloSEI{
	public HelloSEIImpl(){
		
	}

	public String sayHelloTo(String name) {
		
		return "[INFO] HELLO "+ name +" !!!";
	}
	
	
}
