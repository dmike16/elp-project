package org.dmike.example;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloSEI {
	@WebMethod
	public String sayHelloTo(String name);
}
