package assignments.gowthami.xmlParser;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
public class TestXMLParser {
	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			XMLParser obj = new XMLParser();
			String File="C:\\D_drive\\Trash\\myxml.xml";
			RandomAccessFile geek = new RandomAccessFile(File, "r");
	        List<String> li = obj.readFileInList(File); 
	        Iterator<String> itr = li.iterator();
	        obj.fun1(itr,geek);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}