package com.dss.basic;

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
      
        synchronized(ThreadPoolMain.Lock){
	             
            while(true) {
            	if(!ThreadPoolMain.Queue.isEmpty()) {
            	    System.out.println("Elements in queue is: "+ThreadPoolMain.Queue);
            	    try {
            	    	Thread.sleep(1000);
            	    	Object deletedTask=ThreadPoolMain.Queue.remove();
                 	    System.out.println(Thread.currentThread().getName()+" removing only one task i.e.,  "+deletedTask);
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName()+" going to WAIT STATE untill NOTIFY");Thread.sleep(1000);
						ThreadPoolMain.Lock.wait();
					} catch (InterruptedException e) {
						System.out.println("Thread going to Sleep state");
					}
            	    
		    ThreadPoolMain.Lock.notifyAll();
                    
            	}   
                else if(ThreadPoolMain.Queue.isEmpty()) {                 
                	try {
                	    System.out.println("Queue is Empty So "+Thread.currentThread().getName()+" going to WAIT STATE ");Thread.sleep(1000);
                  	    ThreadPoolMain.Lock.wait();
                  	  ThreadPoolMain.Lock.notifyAll();
					} catch (InterruptedException e) {
						System.out.println("error in ");
					}               
                } 
            }
        } 
    }
}
class Task { 
       public static int counter = 0; 
       public static int id; 
       Task () { 
           
            id = counter++;
           
       } 
       public void execute () { 
            System.out.printf(Thread.currentThread().getName()+"; Thread ID:  "+Thread.currentThread().getId()); 
            try { 
                System.out.println("\tExecuting Task #"+id); 
                Thread.sleep(2000); 
            } 
            catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
       } 
} 

public class ThreadPoolMain { 
	
    public static Object Lock = new Object();
    static Queue Queue=new LinkedList();
    static Task task=new Task();
    static int queueCapacity=3;
    
	public static void main(String args[]) { 	   	
		new ThreadPool();
          synchronized(Lock){
              
              while(true) {
            	int queueTask;
              	if(Queue.size()!=queueCapacity) {              		
              		  System.out.println("Adding the task to Queue");
              		  System.out.println(Thread.currentThread().getName()+" Thread is Adding Task");

                      for(int i=0;i<queueCapacity;i++) {
                    	  Task task=new Task();
                    	  queueTask=task.id;
                    	  task.execute();
//                    	  queueTask=new Task().id;
                    	  Queue.add(queueTask);
//                    	  System.out.println(queueTask);
                    	  try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println("thread going to sleep state");
						}
                    	  
                      }

              	}
                  else if(Queue.size()==queueCapacity) {
                      try {
                    	  System.out.println("Queue is full So "+Thread.currentThread().getName()+" Thread (ID:"+Thread.currentThread().getId()+")going to WAIT STATE");
                    	  Thread.sleep(2000);
                    	  Lock.wait();
                      } catch (InterruptedException e1) {
                    	  e1.printStackTrace();
			}               	 
					  
                  }
//              	System.out.println("waking up all the threads");Thread.sleep(2000);
                  Lock.notifyAll();
                    
              }
    }
 }
}
