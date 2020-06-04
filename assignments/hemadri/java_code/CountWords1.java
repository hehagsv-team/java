

package assignments.hemadri;

import java.io.*;
import java.util.*;
import java.util.Map.Entry; 
import java.util.regex.Pattern;

public class CountWords1
{ 
	public static void main(String args[]) 
	{ 
		Map<String, Integer> wordMap = buildWordMap(args[0]); 
		List<Entry<String, Integer>> list = sortByValueInDecreasingOrder(wordMap); 
		System.out.println("List of repeated word from file and their count"); 
		for (Map.Entry<String, Integer> entry : list) 
		{ 
			if (entry.getValue() > 1) 
			{ 
				System.out.println(entry.getKey() + " => " + entry.getValue()); 
			} 
		} 
	} 
	public static Map<String, Integer> buildWordMap(String fileName) 
	{ 
		Map<String, Integer> wordMap = new HashMap<>(); 
		try 
		(FileInputStream fis = new FileInputStream(fileName); 
				DataInputStream dis = new DataInputStream(fis); 
				BufferedReader br = new BufferedReader(new InputStreamReader(dis))) 
		{ 
			Pattern pattern = Pattern.compile("\\s+"); 
			String line = null; while ((line = br.readLine()) != null) 
			{ 
				line = line.toLowerCase(); 
				String[] words = pattern.split(line); 
				for (String word : words) 
				{ 
					if (wordMap.containsKey(word)) 
					{ 
						wordMap.put(word, (wordMap.get(word) + 1)); 
					} 
					else 
					{ 
						wordMap.put(word, 1); 
					} 
				} 
			} 
		} 
		catch (IOException ioex) 
		{ 
			ioex.printStackTrace(); 
		} 
		return wordMap; 
	} 
	public static List<Entry<String, Integer>> sortByValueInDecreasingOrder(Map<String, Integer> wordMap) 
	{ 
		Set<Entry<String, Integer>> entries = wordMap.entrySet(); 
		List<Entry<String, Integer>> list = new ArrayList<>(entries); 
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() 
		{ 
			@Override 
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) 
			{ 
				return (o2.getValue()).compareTo(o1.getValue()); 
			} 
		}); 
		return list; 
	} 

}
