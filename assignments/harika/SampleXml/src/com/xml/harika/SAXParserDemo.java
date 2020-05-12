package com.xml.harika;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
 
public class SAXParserDemo {
  public static void main(String[] args) throws Exception {
    SAXParserFactory parserFactor = SAXParserFactory.newInstance();
    SAXParser parser = parserFactor.newSAXParser();
    SAXHandler handler = new SAXHandler();
    parser.parse(ClassLoader.getSystemResourceAsStream("sampleprogram.xml"),handler);    
    for ( Employee emp : handler.empList){
      System.out.println(emp);
    }
  }
}
class SAXHandler extends DefaultHandler { 
  List<Employee> empList = new ArrayList<>();
  Employee emp = null;
  String content = null;
  @Override
  public void startElement(String uri, String localName,String qName, Attributes attributes)throws SAXException {     
    switch(qName){
      case "employee":
        emp = new Employee();
        emp.id = attributes.getValue("id");
        break;
    }
  }
 
  @Override
  public void endElement(String uri, String localName,String qName) throws SAXException {
   switch(qName){
     case "employee":
       empList.add(emp);      
       break;
     case "firstName":
       emp.firstName = content;
       break;
     case "lastName":
       emp.lastName = content;
       break;
     case "location":
       emp.location = content;
       break;
   }
  }
 
  @Override
  public void characters(char[] ch, int start, int length)
          throws SAXException {
    content = String.copyValueOf(ch, start, length).trim();
  }
     
}
 
class Employee2 {
 
  String id;
  String firstName;
  String lastName;
  String location;
 
  @Override
  public String toString() {
    return firstName + " " + lastName + "(" + id + ")" + location;
  }
}
