package asssignments;
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
    static void queueTask(Task aTask) { 
             aTask.execute();       
    } 
} 
class ThreadPoolRunner extends Thread{ 
	
    public ThreadPoolRunner(String string) { 
        super (string); 
    } 
    public void run () { 
      
        synchronized(ThreadUsage.monitor){
	             
            while(true) {
            	if(!ThreadUsage.taskList.isEmpty()) {
            	    System.out.println("Elements in queue is: "+ThreadUsage.taskList);
            	    System.out.println("Elements will be removed out from queue");
            	    System.out.println("Current thread(remove): "+Thread.currentThread().getName()+"; Current Thread ID:: "+Thread.currentThread().getId());
            	    Task removeEle=ThreadUsage.taskList.remove();
            	    System.out.println("Removed element will be: "+removeEle);
                    ThreadPool.queueTask(removeEle);
		    ThreadUsage.monitor.notifyAll();
                    
            	}   
                else if(ThreadUsage.taskList.isEmpty()) {                 
                	try {
                	    System.out.println("Queue is empty...so thread is in wait condition "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
                  	    
                	    ThreadUsage.monitor.wait();
						System.out.println("Queue after wait condition "+Thread.currentThread().getName()+" "+Thread.currentThread().getId());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}               
                } 
            }
        } 
    }
}
class Task { 
       public static int counter = 0; 
       public int id; 
       Task () { 
           
            id = counter++;
           
       } 
       public void execute () { 
            System.out.println(Thread.currentThread().getName()+"; Thread ID:  "+Thread.currentThread().getId()); 
            try { 
                System.out.println("Executing Task #"+id); 
                Thread.sleep(5000); 
            } 
            catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
       } 
} 

public class ThreadUsage { 

    static Queue<Task> taskList = new LinkedList<>(); 
    public static Object monitor = new Object();
    static int capacity=3;
    static Task task=new Task();
    
	public static void main(String args[]) { 	   	
		new ThreadPool();
          synchronized(monitor){
              
              while(true) {
              	if(taskList.size()!=capacity) {              		
              		  System.out.println("Adding the elements into Queue");
              		  System.out.println("Current thread(add): "+Thread.currentThread().getName()+" Current Thread ID:: "+Thread.currentThread().getId());
                      taskList.add(task);
                      System.out.println("Elements in queue is: "+taskList);
              	}
                  else if(taskList.size()==capacity) {
                      System.out.println("Queue is full");
                      
                      try {
				monitor.wait();
		      } catch (InterruptedException e1) {
						// TODO Auto-generated catch block
				e1.printStackTrace();
			}               	 
                      System.out.println("After wait in main thread "+Thread.currentThread().getName()+" Main Thread ID:: "+Thread.currentThread().getId());
					  
                  }
		     
                  monitor.notifyAll();
                    
              }
    }
 }
}
    


 
