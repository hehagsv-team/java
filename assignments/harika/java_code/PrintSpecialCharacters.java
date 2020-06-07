import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PrintSpecialCharacters {
	public static void main(String args[]) throws Exception {
		FileReader fr = new FileReader("C:\\Users\\roddam.harika\\Desktop\\file1.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int linecount=0;
		char[] ar=line.toCharArray();
		int count=0;
		
		while(line!=null) {
			char[] ar1=line.toCharArray();
			for(int i=0;i<ar1.length-1;i++)
			{
				if((ar1[i]>=' ') && (ar1[i]<='/') || (ar1[i]>=':') && (ar1[i]<='@'))
				{
					count++;
					
					if(count==1 )
						System.out.println(line);
				}
					
			} 
			line=br.readLine();
			count=0;
		}
	}
}