package com.xml;

import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class JavaObjectToXml {

    private JavaObjectToXml() {
    }

    /**
     *
     * @param args
     */
    public static void main(final String[] args) {
        Student student = new Student();
        Class classobj = student.getClass();
        classDetails(classobj);
    }
    /**
    *
    * @param classobject
    */
    public static void classDetails(final Class classobject) {

        DocumentBuilderFactory
        docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element root = doc.createElement("class");
        doc.appendChild(root);
        Attr attribute = doc.createAttribute("name");
        attribute.setValue(classobject.getName());
        root.setAttributeNode(attribute);

        Method[] studentclassMethods = classobject.getDeclaredMethods();
        for (Method method : studentclassMethods) {
            Element method1 = doc.createElement("method");
            root.appendChild(method1);
            Attr methodattribute = doc.createAttribute("name");
            methodattribute.setValue(method.getName());
            method1.setAttributeNode(methodattribute);
            Element param = doc.createElement("args");
            method1.appendChild(param);
            Class[] studentParamList = method.getParameterTypes();
            for (Class class1 : studentParamList) {
                Element arg = doc.createElement("arg");
                param.appendChild(arg);
                Element type = doc.createElement("type");
                type.appendChild(doc.createTextNode(class1.getName()));
                arg.appendChild(type);
                final String xmlfilepath = "C:\\log\\Filexml.xml";
                TransformerFactory
                transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(doc);
                StreamResult
                streamResult = new StreamResult(xmlfilepath);
                transformer.transform(domSource, streamResult);
            }
        }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
