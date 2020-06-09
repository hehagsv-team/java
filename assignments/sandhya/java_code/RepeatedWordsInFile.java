package com.dss.basics;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;
 
public class RepeatedWordsInFile 
{   
    public static void main(String[] args) 
    {   
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
     
        BufferedReader reader = null;
         
        try
        {
             
            reader = new BufferedReader(new FileReader("C:\\copy\\ram.txt"));
             
             
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
            Set<Entry<String, Integer>> ss=wordCountMap.entrySet();
            for(Entry<String, Integer> ee:ss)
            {
            	System.out.println(ee.getKey()+ " : "+ee.getValue());
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
