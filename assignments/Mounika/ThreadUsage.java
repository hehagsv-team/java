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
    static Queue<Task>taskList= new LinkedList<Task>(); 
    public ThreadPoolRunner(String string) { 
        super (string); 
    } 
    public void run () { 
       PC pc=new PC(); 
       while(true) {
            if((getName()=="ThreadPool-1")||(getName()=="ThreadPool-2")) 
            { 
                pc.produce(taskList); 
            } 
            else { 
                pc.consume(taskList); 
            } 
       } 
   }   
} 
class PC{ 
    public static Object monitor = new Object(); 
    int capacity=4; 
    Task task=new Task();
    public void produce(Queue<Task> taskList) { 
    // TODO Auto-generated method stub 
       
        synchronized(monitor){
              //Task task=new Task();
            while(taskList.size()!=capacity) {                
                taskList.add(task);
               
                if(taskList.size()==capacity) {                
                try {                    
                    monitor.wait();                   
                } 
                catch (InterruptedException e) { 
                // TODO Auto-generated catch block 
                    e.printStackTrace(); 
                } 
            }
          }
           
        }
    } 
    public void consume(Queue<Task> taskList) { 
    // TODO Auto-generated method stub 
        
        synchronized(monitor){
	    //Task task=new Task();            
            while(!taskList.isEmpty()) {                
                ThreadPool.queueTask(task); 
                taskList.remove();                
                
                if(taskList.isEmpty()) {                 
                monitor.notifyAll();               
            } 
        } 
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
            System.out.println(Thread.currentThread().getName()+" "+Thread.currentThread().getId()); 
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
        public static void main(String[] args) { 
            new ThreadPool();  
        }
    }
    


 
