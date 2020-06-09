import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CountFirst2Lines {
    public static void main (String args[]) throws Exception {

       System.out.println ("word Counting ");       
       FileReader fr = new FileReader ("C:\\Users\\roddam.harika\\Desktop\\file1.txt");        
       BufferedReader br = new BufferedReader (fr);     
       String line = br.readLine();
        int countword = 0 ;
       int linecount=0;
       
	    while (line !=null) {
		if(linecount>=2)
			break;
          String parts[] = ((String) line).split(" ");					
          for( String cw : parts)
          {
        	  
            countword++;  
          
          }
         
          line = br.readLine();  
          
          linecount++;
	      }
	    System.out.println(countword);
       }         
	
}
