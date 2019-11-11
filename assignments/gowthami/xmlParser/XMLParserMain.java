package assignments.gowthami.xmlParser;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
public class XMLParserMain {
	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			XMLParser obj = new XMLParser();
			// Should read from args[]!!
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

// Does not work for the xml
//<note>
//<to>Tove</to>
//<from>Jani</from>
//<heading>Reminder</heading>
//<body>Don't forget me this weekend!</body>
//<text>
//</text></note> 
