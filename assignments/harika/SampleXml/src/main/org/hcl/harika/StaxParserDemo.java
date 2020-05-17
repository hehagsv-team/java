package main.org.hcl.harika;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public final class StaxParserDemo {
    private StaxParserDemo() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * javadoc (ignored).
     *
     * @param args
     *
     */
  public static void main(final String[] args)
          throws XMLStreamException {
    List<Employee> empList = null;
    Employee currEmp = null;
    String tagContent = null;
    XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory
                .createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream(
                                "sampleprogram.xml"));
        while (reader.hasNext()) {
      int event = reader.next();

            switch (event) {
        case XMLStreamConstants.START_ELEMENT:
                if ("employee".equals(reader.getLocalName())) {
            currEmp = new Employee();
            currEmp.id = reader.getAttributeValue(0);
          }
                if ("employees".equals(reader.getLocalName())) {
            empList = new ArrayList<>();
          }
          break;
            default:
                break;

        case XMLStreamConstants.CHARACTERS:
          tagContent = reader.getText().trim();
          break;

        case XMLStreamConstants.END_ELEMENT:
                switch (reader.getLocalName()) {
            case "employee":
              empList.add(currEmp);
              break;
            case "firstName":
              currEmp.firstName = tagContent;
              break;
            case "lastName":
              currEmp.lastName = tagContent;
              break;
            case "location":
              currEmp.location = tagContent;
              break;
                default:
                    break;
          }
          break;

        case XMLStreamConstants.START_DOCUMENT:
          empList = new ArrayList<>();
          break;
      }
        }
        for (Employee emp : empList) {
      System.out.println(emp);
        }
  }
}

//class Employee1 {
//    /** javadoc (ignored). */
//    private String id;
//    /** javadoc (ignored). */
//    private String firstName;
//    /** javadoc (ignored). */
//    private String lastName;
//    /** javadoc (ignored). */
//    private String location;
//
//    /** @Override */
//  @Override
//    public String toString() {
//        return firstName + " " + lastName + "(" + id + ") " + location;
//  }
//}
