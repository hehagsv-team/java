package com.domparser.java;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SampleDomParser {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder build;
        try {
            build = factory.newDocumentBuilder();
            Document doc = build.parse(new File("sample.xml"));
            NodeList empList = doc.getElementsByTagName("Employee");
            for (int i = 0; i < empList.getLength(); i++) {
                Node n = empList.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element employee = (Element) n;
                    String id = employee.getAttribute("ID");
                    NodeList details = employee.getChildNodes();
                    System.out.println("Employee" + " " + id + ":");
                    for (int j = 0; j < details.getLength(); j++) {
                        Node m = details.item(j);
                        if (m.getNodeType() == Node.ELEMENT_NODE) {
                            Element name = (Element) m;
                            System.out.println(name.getTagName() + " = " + name.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
