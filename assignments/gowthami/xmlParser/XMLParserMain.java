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
			
			// Should read from args[]!!
			XMLParser m=new XMLParser();
			RandomAccessFile geek = new RandomAccessFile(args[0], "r");
	        List<String> li = m.readFileInList(args[0]); 
	        Iterator<String> itr = li.iterator();
	        m.readline(itr,geek);
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
