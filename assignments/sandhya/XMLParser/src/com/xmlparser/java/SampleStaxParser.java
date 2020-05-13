package com.xmlparser.java;

import java.io.FileInputStream;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public final class SampleStaxParser {
    private SampleStaxParser() {
        throw new IllegalStateException("Utility class");
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        boolean bFname = false;
        boolean bLname = false;
        boolean bAge = false;
        boolean bSalary = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader xmlEventReader =
            factory.createXMLEventReader(new FileInputStream("sample.xml"));
            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                switch (event.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    if (qName.equalsIgnoreCase("employee")) {
                        System.out.println("Start Element : Employee");
                        Iterator<Attribute> attributes =
                                startElement.getAttributes();
                        System.out.println("Id : "
                                + attributes.next().getValue());
                     } else if (qName.equalsIgnoreCase("firstname")) {
                         bFname = true;
                     } else if (qName.equalsIgnoreCase("lastname")) {
                        bLname = true;
                     } else if (qName.equalsIgnoreCase("Age")) {
                        bAge = true;
                    } else if (qName.equalsIgnoreCase("Salary")) {
                        bSalary = true;
                     }
                    break;
                case  XMLStreamConstants.CHARACTERS:
                    Characters characters = event.asCharacters();
                    if (bFname) {
                        System.out.println("First Name: "
                                + characters.getData());
                        bFname = false;
                    } else if (bLname) {
                        System.out.println("Last Name: "
                                + characters.getData());
                        bLname = false;
                    } else if (bAge) {
                        System.out.println("Age: " + characters.getData());
                        bAge = false;
                    } else if (bSalary) {
                        System.out.println("Salary: " + characters.getData());
                        bSalary = false;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart()
                            .equalsIgnoreCase("employee")) {
                       System.out.println("End Element : student");
                       System.out.println();
                    }
                    break;
                default:
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } // TODO Auto-generated method stub
    }
}
