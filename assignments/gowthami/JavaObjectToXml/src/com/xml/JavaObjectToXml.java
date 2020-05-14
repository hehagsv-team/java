package com.xml;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class JavaObjectToXml {

    public static void main(String args[]) {
        Student student1 = new Student();
        student1.setRollno(1);
        student1.setName("Gowthami");

        try {
            XMLEncoder xe = new XMLEncoder(new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\lenovo.LAPTOP-A9778KLS\\Documents\\xmlfile.xml")));
            xe.writeObject(student1);
            xe.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
