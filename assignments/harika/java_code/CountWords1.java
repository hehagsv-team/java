import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CountWords1 {
	public static void main(String args[])throws Exception {
		
		System.out.println("word counting");
		FileReader fr = new FileReader("C:\\Users\\roddam.harika\\Desktop\\file1.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int countword = 0;
		while(line != null) {
			String parts[] = line.split(" ");
			for( String c : parts) 
			{
				countword++;
			}
			line = br.readLine();
		}
		System.out.println(countword);
	}
}