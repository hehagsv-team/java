package assignments.harika;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

// Sunoop: Comments
// The code is not modular. Seperate responsibilities into different methods.
// Modify the code to check if the file is a valid properties file.

public class PropertiesTest1 {     

	public static void main(String[] args) {
		HashMap<String, String> map=new HashMap<String,String>();


		try {
			BufferedReader reader;
			// Sunoop: why is the reader not getting closed?
			reader = new BufferedReader(new FileReader(args[0]));
			String line;       

			while ((line = reader.readLine()) != null) {
				String[] arrOfStr = line.split("=", 2); 
				map.put(arrOfStr[0],arrOfStr[1]); 
			}

			// Sunoop: How did you achieve without duplicates?
			System.out.println("The keys and values in the file without duplicates\n"+map);
			System.out.println("The Values are: \n");
			Collection<String> values=map.values();
			for(String value:values)
			{
				System.out.println(value);
			}
			System.out.println("The keys are : \n");
			Set<String> keys = map.keySet();
			for(String key:keys)
			{
				System.out.println(key);
			}
			System.out.println("The Keys and Values are : \n");
			Set<java.util.Map.Entry<String,String>> entry=map.entrySet();
			for(java.util.Map.Entry<String, String>  ee:entry)
			{
				System.out.println(ee.getKey()+ " : " +ee.getValue());
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

