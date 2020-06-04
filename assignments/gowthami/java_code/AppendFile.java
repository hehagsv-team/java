package assignments.gowthami;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class AppendFile
{
   public static void main( String[] args )
   {   
      new Demo().gowthami();
   }
}

class Demo {
	void gowthami () {
		 try
	      {
	       String content = "This is my content which would be appended " +
	             "at the end of the specified file";
	       
	       File file = null;
	       try {
	    	   file = openFileToWrite ();
	       } catch (IOException e) {
	    	   System.out.println("Unexcepted erro while reading/creating file");
	    	   return;
	       }
	       
//	       Writer fw = new FileWriter(file,true);
	       Writer fw = new StringWriter ();
	       BufferedWriter bw = new BufferedWriter(fw);
	       bw.write(content);
	       bw.close();
	       System.out.println("Data successfully appended at the end of file");
	      }
	      catch(IOException e)
	      {
	         	System.out.println("Exception occurred:");
	        	e.printStackTrace();
	      } catch (NullPointerException e) {
	    	  
	      }
	}

	private File openFileToWrite() throws IOException  {
		File file =new File("C://myfile.txt");
		if(!file.exists())
		{
				file.createNewFile();
		}	
		return file;
	}
}
