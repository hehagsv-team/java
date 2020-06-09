import java.io.*;

class CntLines
{
         public static void main(String args[]) throws IOException
      { 
     try
    {
          FileReader fr;
          BufferedReader br;
          File f;
          String str;
          int cnt=0;
     
         for(int i=0;i<args.length;i++)
          {
             f = new File(args[i]);
            
            System.out.println("getAbsolutePath-->"+f.getAbsolutePath());
            fr = new FileReader(f);
            br = new BufferedReader(fr);
           
            while((str = br.readLine()) != null)
            {
            	cnt++;
            }
            System.out.println("File Name : " + f.getName() + " Total Lines : " + cnt);
            cnt = 0;  
              
            fr.close();
               
          } 
         
         
    }
    catch(FileNotFoundException e)
     {
      System.out.println("File Not Found");
     }
    catch(IOException e)
        {
      System.out.println("Exception : " + e);
        } 
      }
}

