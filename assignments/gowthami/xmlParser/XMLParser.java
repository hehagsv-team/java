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
			String search_string;
			while((search_string=br.readLine())!=null)
			{
				// Repeated code. reuse it 
				// Repeated code START ------------
				char search_character='<';
				String search_wrd="";
				int search_length=s.length();
				for (int position=0;position<search_length-1;position++)
				{
					search_wrd="";
					search_character='<';
					if(search_string.charAt(position)==c && search_string.charAt(position+1)=='/')
					{
						search_wrd=word(search_character,search_wrd,position,search_string);
						if (input.equals(search_wrd))
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
	public String word(char word_character,String wrd,int position,String line)
	{
		while(word_character!='>')
		{
			wrd+=word_character;
			position++;
			word_character = line.charAt(position);
		}
		wrd+='>';
		return wrd;
	}	
	public void readline(Iterator<String> itr,RandomAccessFile geek)
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
				char readline_char='<';
				String wrd="";
				int readline_length=line.length();
				for (int position=0;position<readline_length-1;position++)
				{
					readline_char='<';
					wrd="";
					if(line.charAt(position)==readline_char&& line.charAt(position+1)!='/')
					{
						wrd=word(readline_char,wrd,position,line);
						// Repeated code END ---------
						String temp="";
						for (int ha=0;ha<=wrd.length();ha++)
						{
							if(ha==0)
								temp += wrd.charAt(ha);
							if(ha == 1)
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
