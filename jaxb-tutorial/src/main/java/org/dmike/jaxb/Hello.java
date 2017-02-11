package org.dmike.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.dmike.jaxb.schema.GreetingType;
import org.dmike.jaxb.schema.GreetingTypeList;
import org.dmike.jaxb.schema.ObjectFactory;

public class Hello {
	private ObjectFactory of;
	private GreetingTypeList g_liste;
	
	public Hello(){
		of = new ObjectFactory();
		g_liste = of.createGreetingTypeList();
	}
	
	public void make(String t,String l){
		GreetingType g = new GreetingType();
		g.setText(t);
		g.setLanguage(l);
		g_liste.getGreeting().add(g);
	}
	
	public void marshall(){
		JAXBElement<GreetingTypeList> gl =
				of.createGreetings(g_liste);
		try {
			JAXBContext jbc = JAXBContext.newInstance("org.dmike.jaxb.schema");
			Marshaller m = jbc.createMarshaller();
			m.marshal(gl, System.out);
		} catch (JAXBException e) {
			e.printStackTrace(System.err);
		}
	}
}
