package com.xmlparser.java;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{
    /** Extra javadoc(ignored). */
    private boolean bFname = false;
    /** Extra javadoc(ignored). */
    private boolean bLname = false;
    /** Extra javadoc(ignored). */
    private boolean bAge = false;
    /** Extra javadoc(ignored). */
    private boolean bSalary = false;
    /**@Override*/
    @Override
    public void startElement(final String uri, final String localName,
            final String qName, final Attributes attributes)
       throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("Id : " + attributes.getValue("ID"));
         } else if (qName.equalsIgnoreCase("firstname")) {
             bFname = true;
         } else if (qName.equalsIgnoreCase("lastname")) {
            bLname = true;
         } else if (qName.equalsIgnoreCase("Age")) {
            bAge = true;
        } else if (qName.equalsIgnoreCase("Salary")) {
            bSalary = true;
         }
    }
    /**@Overide*/
    @Override
    public void endElement(final String uri, final String localName,
            final String qName) throws SAXException {
        if (qName.equalsIgnoreCase("employee")) {
            System.out.println("End element: " + qName);
        }
    }
    /**@Override*/
    @Override
    public void characters(final char[] ch, final int start, final int length)
            throws SAXException {
        if (bFname) {
            System.out.println("First Name: " + new String(ch, start, length));
            bFname = false;
        } else if (bLname) {
            System.out.println("Last Name: " + new String(ch, start, length));
            bLname = false;
        } else if (bAge) {
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        } else if (bSalary) {
            System.out.println("Salary: " + new String(ch, start, length));
            bSalary = false;
        }
    }

}
