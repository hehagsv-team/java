package assignments.gowthami;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XMLParser
{
	static int search(BufferedReader br, String input)
	{
		try
		{
			String[] words=null;
			int count=0;
			String s;     
			while((s=br.readLine())!=null)  
			{
				words=s.split(" ");  
				for (String word : words) 
				{
					if (word.equals(input))  
					{
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


	/*
	 * MAIN method
	 */
	public static void main(String[] args) 
	{

		try {
			BufferedReader reader;
			reader = new BufferedReader(new FileReader("C:/Users/puvvadi.gowthami/Desktop/xmlf.txt"));
			String line;
			String l="/";
			line = reader.readLine();
			char c='<';
			String wrd="";
			int p=1;
			for (int i=0;i<=line.length();i++)
			{
				if(line.charAt(i).equals(c)==0)
				{
					while(c.equals('>')==1)
					{  
						wrd+=c;
						i++;
						c = line.charAt(i);
					}
					wrd+='>';
					String temp="";
					while (line != null)
					{
						for (int i=0;i<(wrd.length()-1);i++)
						{
							if (i == 1) 
							{ 
								temp += l;
							} 
							if(i==0)
								temp += wrd.charAt(i);
							if(i>1)
								temp += wrd.charAt(i-1);
						}
					} 
					int y= search(reader,temp);
					if (y==0)
					{ 
						System.out.println("The given word is not present ");
					}
					else
					{
						System.out.println("The given word is present ");
					}
					break;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}


	}
}
