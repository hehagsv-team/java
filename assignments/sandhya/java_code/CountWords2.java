package assignments.sandhya;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
 
public class CountWords2 
{   
    public static void main(String[] args) 
    {   
        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader("C:\\D_drive\\Trash\\word.txt"));
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
            System.out.println(wordCountMap.toString());
            for(Entry<String, Integer> ee:ss)
            {
            	System.out.println(ee.getKey()+ " : "+ee.getValue());
            }
        } 
        catch (IOException e) 
        {
//            e.printStackTrace();
        	System.out.println("Unable to process the request. File was not found at the location");
        }
        finally
        {
            try
            {
                if (reader != null) {
					reader.close();
				}        
            }
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }   
}
