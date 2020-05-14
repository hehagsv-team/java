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
        FileOutputStream out = new FileOutputStream("C:\\log/outputFile.xml");
        BufferedOutputStream os = new BufferedOutputStream(out);
        XMLEncoder x = new XMLEncoder(os);
        x.writeObject(list);
        x.close();
        BufferedReader in = new BufferedReader(new FileReader("C:\\log/outputFile.xml"));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

}
