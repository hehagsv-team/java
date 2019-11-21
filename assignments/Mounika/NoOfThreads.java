class ThreadId extends Thread { 
	public static int count=0;
    public void run()  {
     try {
			Thread.sleep(60000);
			System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
			count++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println ("Count of Threads are: "+count);
		}
      } 	          
} 
  
public class NoOfThreads{ 
    public static void main(String[] args) 
    { 
    	for (;;) 
        { 
            ThreadId t1 = new ThreadId(); 
            t1.start();
        }                 
    } 
}

