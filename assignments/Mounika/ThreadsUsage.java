import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {
       // maintain a pool of Threads - 5
       ThreadPool () {    	      
              new ThreadPoolRunner ("ThreadPool-1").start();             
              new ThreadPoolRunner ("ThreadPool-2").start();              
              new ThreadPoolRunner ("ThreadPool-3").start();              
              new ThreadPoolRunner ("ThreadPool-4").start();              
              new ThreadPoolRunner ("ThreadPool-5").start();              
       }
       
       void queueTask(Task aTask) {
             aTask.execute();    	  
       }
}

class ThreadPoolRunner extends Thread{
	static Queue<Task>taskList= new LinkedList<Task>();
	
       public ThreadPoolRunner(String string) {
              super (string);              
       }

       public void run () {    	   
    	   ThreadPool t1=new ThreadPool();    	   
              while (true) {
                    Task task=new Task();                                   
                    taskList.add(task);                   
                    t1.queueTask(task);                               	  
              }
       }
}

class Task {
       
       private static int counter = 0;
       private int id;
       
       Task () {
              id = counter++;            
       }
       
       public void execute () {
              System.out.println(Thread.currentThread().getName());
              try {
                     System.out.println("Executing Task #"+id);
                     Thread.sleep(5000);
              } catch (InterruptedException e) {
                     e.printStackTrace();
              }
       }
      
}
public class ThreadUsage {
	 	public static void main(String[] args) {
	 		new ThreadPool(); 
	 	}


}
