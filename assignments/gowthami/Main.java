import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
class Gow 
{
	enum Num 
    { 
		zero,one, two; 
    }
	public  List<String> readFileInList(String fileName)
	{
		List<String> lines = Collections.emptyList(); 
	    try
	    { 
	      lines = Files.readAllLines(Paths.get(fileName));
	    } 
	    catch (IOException e) 
	    { 
	    	e.printStackTrace(); 
	    	System.out.println("file not found");
	    } 
	    return lines; 
	  } 
	public   Num search(RandomAccessFile br, String input)
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
	        	return Num.valueOf("two");
	        }
	        else
	        {
	        	return Num.valueOf("zero");
	        }
	        
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
		return Num.valueOf("one");
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
	public  void fun1(Iterator<String> itr,RandomAccessFile geek)
	{
		try
		{
			Num jk=Num.zero;
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
					c='<';
					wrd="";
					if(line.charAt(i)==c&& line.charAt(i+1)!='/')
					{
						wrd=word(c,wrd,i,line);
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
						Num y= search(geek,temp);
						if (y==Num.zero)
						{
							System.out.println(" !ERROR "+temp+" Tag not closed ");
							jk=Num.one;
						}
					}
				}
			}
			if (jk==Num.zero)
				System.out.println("the file is well-formed");
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		try
		{
			Gow m=new Gow();
			RandomAccessFile geek = new RandomAccessFile(args[0], "r");
	        List<String> li = m.readFileInList(args[0]); 
	        Iterator<String> itr = li.iterator();
	        m.fun1(itr,geek);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
