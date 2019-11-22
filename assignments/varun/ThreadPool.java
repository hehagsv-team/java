//package com.dss.basics;

import java.util.LinkedList;
import java.util.Queue;

class ThreadPool {
       // maintain a pool of Threads - 5
       ThreadPool () throws InterruptedException {
            new ThreadPoolRunner ("ThreadPool-1").start();
            ThreadPoolRunner t2=  new ThreadPoolRunner ("ThreadPool-2");
              t2.start();
              t2.wait();
              new ThreadPoolRunner ("ThreadPool-3").start();
//              t3.start();
//              t3.wait();
             new ThreadPoolRunner ("ThreadPool-4").start();;
//              t4.start();
//              t4.wait();
              new ThreadPoolRunner ("ThreadPool-5").start();
//              t5.start();
//              t5.wait();
       }
       
       void queueTask(Task aTask) throws InterruptedException {//here am adding the tasks to the queue
     
    	   aTask.execute();}
   		public static void main(String[] args) throws InterruptedException {
   			ThreadPool tt=new ThreadPool();
   			Task aT=new Task();
   			tt.queueTask(aT);
		
		
   	}
   		
}

class ThreadPoolRunner extends Thread{
       public ThreadPoolRunner(String string) {
              super (string);
       }
       Queue<Integer> qu=new LinkedList<Integer>();
  	  int capacity=3;
  	  int value=0;
       public void run () {   
    	   Demo d =new Demo();
            	  if(getName().equals("ThreadPool-1")) {
            		  try {
						d.produce(qu,5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	  }
            	  else {
            		  try {
						d.consume(qu);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	  }
   }
       
class Demo{
       public void consume(Queue<Integer> qu2) throws InterruptedException {
		// TODO Auto-generated method stub
    	   while (true) { 
               synchronized (this) 
               { 
                   while (qu2.size() == 0) 
                       wait(); 

                   int val = qu2.remove(); 
 
                   System.out.println("Consumer consumed-" + val); 
 
                   notify(); 
 
                   Thread.sleep(1000); 
               } 
           }
    	   
		
	}
	public void produce(Queue<Integer> qu2,int capacity) throws InterruptedException {
		// TODO Auto-generated method stub
		while (true) { 
            synchronized (this) 
            { 
                while (qu2.size() == capacity) 
                    wait(); 

                System.out.println("Producer produced-"
                                   + value); 

                qu2.add(value++); 

                notifyAll();
                Thread.sleep(1000); 
            } 
        } 
		
	}
}

}

class Task {
       
       private static int counter = 0;
       private int id;
       
       public Task () {
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

