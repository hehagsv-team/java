package jdbc;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaToXml {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeClass e = new EmployeeClass();
        e.setFirstName("Hemadri");
        e.setLastName("teruvai");
        e.setAge(21);

        List<EmployeeClass> list = new ArrayList<>();
        list.add(e);
        FileOutputStream out = new FileOutputStream("C:\\log/outputFile.xml");
        BufferedOutputStream os = new BufferedOutputStream(out);
        XMLEncoder x = new XMLEncoder(os);
        x.writeObject(list);
        x.close();
    }

}
