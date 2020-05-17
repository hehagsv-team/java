package test.org.hcl.harika;

import java.io.File;
import java.util.jar.Attributes;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.mockito.Mock;

import main.org.hcl.harika.Employee;
import main.org.hcl.harika.SAXHandler;

public class SAXParserTest {

    @Mock
    private String uri;
    @Mock
    private String localName;
    @Mock
    private String qName;
    @Mock
    private Attributes attributes;
    @Mock
    private Employee emp;
    @Mock
    private SAXParserFactory parserFactor;
    @Mock
    private SAXParser parser;
    @Test
    public void test() throws Exception {
        // 1. Get the factory object for the sax parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2. Create parser objects from factory object SAXParser
        SAXParser saxParser = factory.newSAXParser();
        // 3. Set parsed files and self-defined event handler objects by parsing the
        // parse() method of saxParser
        saxParser.parse(new File("sampleprogram.xml"), new SAXHandler());

    }

    // Self-defined event handlers
//    class SAXHandler extends DefaultHandler {
//
//        // Identifier that resolves the start and end of a label
//        boolean isOk = false;
//
//        public void startElement(String uri, String localName, String qName, Attributes attributes)
//                throws SAXException {
//            super.startElement(uri, localName, qName, (org.xml.sax.Attributes) attributes);
//            // Set isOK to true when parsing author element begins
//            if ("employee".equals(qName)) {
//                isOk = true;
//            }
//        }
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            // TODO Auto-generated method stub
//            super.characters(ch, start, length);
//            // Print the contents of an element when the parsed identifier is true
//            if (isOk) {
//                System.out.println(new String(ch, start, length));
//            }
//        }
//
//        @Override
//        public void endElement(String uri, String localName, String qName) throws SAXException {
//            super.endElement(uri, localName, qName);
//            // Set isOK to false when parsing the end of author element
//            if ("employee".equals(qName)) {
//                isOk = false;
//            }
//        }
//
//    }

}


