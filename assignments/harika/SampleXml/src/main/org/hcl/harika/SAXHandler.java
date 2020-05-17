package main.org.hcl.harika;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    /** javadoc (ignored). */
    List<Employee> empList = new ArrayList<>();
    /** javadoc (ignored). */
    private Employee emp = null;
    /** javadoc (ignored). */
    private String content = null;
    /** javadoc (ignored). */
    @Override
    public void startElement(final String uri, final String localName,
            final String qName,
            final Attributes attributes) throws SAXException {
        switch (qName) {
        case "employee":
            emp = new Employee();
            emp.id = attributes.getValue("id");
            break;
        default:
            break;
        }

    }

    /** javadoc (ignored). */
    @Override
    public void endElement(final String uri,
            final String localName,
            final String qName) throws SAXException {
        switch (qName) {
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
        default:
            break;
        }
    }
    /** javadoc (ignored). */
    @Override
    public void characters(final char[] ch,
            final int start,
            final int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }
}


