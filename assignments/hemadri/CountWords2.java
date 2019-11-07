package assignments.hemadri;

import java.io.*;
import java.util.*;
 
public class CountWords2 
{   
    public static void main(String[] args) throws IOException 
    {   
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader("examp"));
        String line = br.readLine();  
        while (line != null)
        {   
        	String[] line_word = line.toLowerCase().split(" ");
            for (String w : line_word)
            {
            	if(h.containsKey(w))
                {
            		h.put(w, h.get(w)+1);
                }
            	else
            	{
            		h.put(w, 1);
            	}
            }
            line = br.readLine();
        }
            System.out.println(h);
            br.close();        

    }   
}
