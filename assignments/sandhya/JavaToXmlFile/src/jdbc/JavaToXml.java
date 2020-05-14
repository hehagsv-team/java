package jdbc;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class JavaToXml {
    public static void main(String[] args) throws FileNotFoundException {
        EmployeeClass obj = new EmployeeClass();
        obj.setFirstName("Hemadri");
        obj.setLastName("teruvai");
        obj.setAge(21);
        FileOutputStream out = new FileOutputStream("C:\\log/outputFile.xml");
        BufferedOutputStream os = new BufferedOutputStream(out);
        XMLEncoder xml = new XMLEncoder(os);
        xml.writeObject(obj);
        xml.close();
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
