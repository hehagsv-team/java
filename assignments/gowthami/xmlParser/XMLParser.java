package assignments.gowthami.xmlParser;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class XMLParser
{
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
				char c='<';
				String wrd="";
				int th=s.length();
				for (int i=0;i<th-1;i++)
				{
					if(s.charAt(i)=='<'&& s.charAt(i+1)=='/')
					{
						while(c!='>')
						{
							wrd+=c;
							i++;
							c = s.charAt(i);
						}
						wrd+='>';
						if (input.equals(wrd))
							count++;
					}
				}
			}	
			if(count!=0)
			{
				return 2;
			}
			else
			{
				return 0;
			}

		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}

		return 1;
	}
	
	
	public void fun1(Iterator<String> itr,RandomAccessFile geek)
	{
		try
		{
			String line;
			String l="/";
			while(itr.hasNext())
			{
				line = itr.next();
				char c='<';
				String wrd="";
				int th=line.length();
				for (int i=0;i<th-1;i++)
				{
					if(line.charAt(i)=='<'&& line.charAt(i+1)!='/')
					{
						while(c!='>')
						{
							wrd+=c;
							i++;
							c = line.charAt(i);
						}
						wrd+='>';
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
						if (y==0)
							System.out.println(" !ERROR "+temp+" Tag not closed ");
						if(y==1)
						{
							System.out.println(" !ERROR "+temp+" Tag  ");
						}
					}
				}
			}
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}