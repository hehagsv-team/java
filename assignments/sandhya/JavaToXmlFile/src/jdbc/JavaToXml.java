package jdbc;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class JavaToXml {
    private JavaToXml() {
        throw new IllegalStateException("Utility class");
    }
    /**
     *
     * @param args
     */
    public static void main(final String[] args)
            throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        ExampleMethodClass obj = new ExampleMethodClass(); // Class
        Class c = obj.getClass();
        Method[] allMethods = c.getDeclaredMethods();
        javaToXml(c, allMethods, doc);
    }

    private static void javaToXml(final Class c, final Method[] allMethods,
            final Document doc) {
        Element rootElement = doc.createElement("class");
        doc.appendChild(rootElement);
        Attr attr = doc.createAttribute("name");
        attr.setValue(c.getName());
        rootElement.setAttributeNode(attr);
        for (Method classMethod : allMethods) {
            Class<?>[] pType = classMethod.getParameterTypes();
            Element method = doc.createElement("method");
            rootElement.appendChild(method);
            Attr methodAttr = doc.createAttribute("name");
            methodAttr.setValue(classMethod.getName());
            method.setAttributeNode(methodAttr);
            Element args = doc.createElement("args");
            method.appendChild(args);
            for (Class classobject : pType) {
                Element arg = doc.createElement("arg");
                args.appendChild(arg);
                Element type = doc.createElement("type");
                type.appendChild(doc.createTextNode(classobject.getName()));
                arg.appendChild(type);
            }
        }
        transformToXml(doc);
    }

    private static void transformToXml(final Document doc) {
        try {
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer;
            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(
                    new File("C:\\log/outputFile.xml"));
            transformer.transform(source, result);
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
