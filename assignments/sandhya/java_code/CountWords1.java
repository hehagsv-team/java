package assignments.sandhya;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
 
public class CountWords1 
{   
    public static void main(String[] args) 
    {   
       
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
     
        BufferedReader reader = null;
         
        try
        {
           
             
            reader = new BufferedReader(new FileReader("examp"));
             
           
            String currentLine = reader.readLine();
             
            while (currentLine != null)
            {   
                
                String[] words = currentLine.toLowerCase().split(" ");
                 
                
                 
                for (String word : words)
                {
                   
                    if(wordCountMap.containsKey(word))
                    {   
                        wordCountMap.put(word, wordCountMap.get(word)+1);
                    }
                     
                    
                    else
                    {
                        wordCountMap.put(word, 1);
                    }
                }
                 
                
                 
                currentLine = reader.readLine();
            }
             
            
            Set<Entry<String, Integer>> entrySet = wordCountMap.entrySet();
             
           
             
            List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
             
           
             
            Collections.sort(list, new Comparator<Entry<String, Integer>>() 
            {
                @Override
                public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) 
                {
                    return (e2.getValue().compareTo(e1.getValue()));
                }
            });
             
           
            System.out.println("Repeated Words In Input File Are :");
             
            for (Entry<String, Integer> entry : list) 
            {
                if (entry.getValue() > 1)
                {
                    System.out.println(entry.getKey() + " : "+ entry.getValue());
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();           
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }   
}
