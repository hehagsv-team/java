package assignments.gowthami.xmlParser;

import java.util.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class XMLParser
{
    enum Num 
    { 
	mismatch,change, match; 
    }
	public List<String> readFileInList(String fileName)
	{
		
		List<String> lines = Collections.emptyList(); 
		try
		{ 
			lines = Files.readAllLines(Paths.get(fileName));
		} 
		catch (IOException e) 
		{ 
			
			e.printStackTrace(); 
		} 
		return lines; 
	} 	
	int search(RandomAccessFile br, String input)
	{
		try
		{
			int count=0;
			String s;
			while((s=br.readLine())!=null)
			{
				// Repeated code. reuse it 
				// Repeated code START ------------
				char c='<';
				String wrd="";
				int th=s.length();
				for (int i=0;i<th-1;i++)
				{
					wrd="";
					c='<';
					if(s.charAt(i)==c&& s.charAt(i+1)=='/')
					{
						wrd=word(c,wrd,i,s);
						if (input.equals(wrd))
							count++;
					}
				}
			}	
			if(count!=0)
			{
				// USE ENUM instead of 0, 1, 2.
				// Code not readable	
			 	return Num.valueOf("match");
	        	}
	        	else
	        	{
	        		return Num.valueOf("mismatch");
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		return Num.valueOf("change");
	}
	public String word(char c,String wrd,int i,String line)
	{
		while(c!='>')
		{
			wrd+=c;
			i++;
			c = line.charAt(i);
		}
		wrd+='>';
		return wrd;
	}	
	public void fun1(Iterator<String> itr,RandomAccessFile geek)
	{
		try
		{
			Num jk=Num.mismatch;
			String line;
			String l="/";
			while(itr.hasNext())
			{
				line = itr.next();
				// Repeated code. Use a common code
				// Repeated code START ------------
				char c='<';
				String wrd="";
				int th=line.length();
				for (int i=0;i<th-1;i++)
				{
					c='<';
					wrd="";
					if(line.charAt(i)==c&& line.charAt(i+1)!='/')
					{
						wrd=word(c,wrd,i,line);
						// Repeated code END ---------
						String temp="";
						for (int ha=0;ha<=wrd.length();ha++)
						{
							if(ha==0)
								temp += wrd.charAt(ha);
							if (ha == 1)
								temp += l;
							if(ha>1)
								temp += wrd.charAt(ha-1);
						}
						geek.seek(0);
						int y= search(geek,temp);
						// USE ENUM instead of 0, 1, 2.
						// Code not readable
						if (y==Num.mismatch)
						{
							System.out.println(" !ERROR "+temp+" Tag not closed ");
							jk=Num.change;
						}
					}
				}
			}
			if (jk==Num.mismatch)
				System.out.println("the file is well-formed");
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
