package org.dmike.jaxb;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.dmike.jaxb.schema.DateTimeType;
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
    this.make(t, l, new GregorianCalendar());
  }

  public void make(String t,String l,GregorianCalendar istant){
    GreetingType g = of.createGreetingType();
    g.setText(t);
    g.setLanguage(l);
    g.setIstant(this.makeIstant(istant));    
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
  
  private DateTimeType makeIstant(GregorianCalendar istant){
    DateTimeType meta = of.createDateTimeType();
    try {
      DatatypeFactory df = DatatypeFactory.newInstance();
      XMLGregorianCalendar gcDate = df.newXMLGregorianCalendarDate(
          istant.get(Calendar.YEAR)
          ,istant.get(Calendar.MONTH)
          ,istant.get(Calendar.DAY_OF_MONTH)
          ,DatatypeConstants.FIELD_UNDEFINED);
      
      XMLGregorianCalendar gcTime = df.newXMLGregorianCalendarTime(
          istant.get(Calendar.HOUR_OF_DAY)
          ,istant.get(Calendar.MINUTE)
          ,istant.get(Calendar.SECOND)
          ,null
          ,DatatypeConstants.FIELD_UNDEFINED);
      
      meta.setDate(gcDate);
      meta.setTime(gcTime);
      
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace(System.err);
    }
    
    
    return meta;
    
  }
}
