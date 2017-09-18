package org.dmike.example;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.dmike.example.api.RemoteCalculator;

public class RemoteEJBClient {

	public static void main(String[] args) throws Exception{
		final RemoteCalculator calculator = lookupRemoteCalculator();
		//System.out.println(calculator);
		System.out.println(String.format("[INFO] 12+13 = %d", calculator.add(12, 13)));
	}

	private static RemoteCalculator lookupRemoteCalculator() throws NamingException{
		final Hashtable<String,String> prop = new Hashtable<>();
		prop.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
		final Context context = new InitialContext(prop);
		final String appName = "remote-ejb-1.0";
		final String modulName = "ejb-1.0";
		final String distinctName = "";
		final String beanName = "CalculatorBean";
		final String viewCalssName = RemoteCalculator.class.getName();
		
		return (RemoteCalculator) context.lookup(String.format(EJB_JNDI,appName,modulName,
				distinctName,beanName,viewCalssName));
	}
	
	private static final String EJB_JNDI = "ejb:%s/%s/%s/%s!%s";
}
