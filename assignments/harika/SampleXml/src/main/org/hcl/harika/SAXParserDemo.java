package main.org.hcl.harika;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public final class SAXParserDemo {
    private SAXParserDemo() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * javadoc (ignored).
     *
     * @param args
     *
     */
    public static void main(final String[] args) throws Exception {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream(
                "sampleprogram.xml"), handler);
        for (Employee emp : handler.empList) {
            System.out.println(emp);
        }
    }
}
