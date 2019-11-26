package com.dff;

import java.util.Queue;
import java.util.LinkedList;

class ThreadPool 
{
	Queue<Task> q=new LinkedList<Task>();	
	 ThreadPool ( Queue<Task> q)
	    {
           new ThreadPoolRun ("ThreadPool-1",q).start();
           new ThreadPoolRun ("ThreadPool-2",q).start();
           new ThreadPoolRun ("ThreadPool-3",q).start();
           new ThreadPoolRun ("ThreadPool-4",q).start();
           new ThreadPoolRun ("ThreadPool-5",q).start();
        }    
    void queueTask(Task aTask)
    {
           // TODO: complete
           // add task 
    		
    }
}
class ThreadPoolRun extends Thread
{
	Queue<Task> q=null;
    public ThreadPoolRun(String string,Queue<Task> queue)
    {
    	super (string);
    	this.q =queue;
   	}   
    public void run () 
    {  
    	
           while (true) 
           {
        	   synchronized(q)
        	   {
        		   if(q.isEmpty())
        		   {      		   
        			   try {
        				   q.wait();
        			   		} 
        			   	catch (InterruptedException e)
        			   		{					
        			   			e.printStackTrace();
        			   		}
        		   }
        		   else
        		   {        		   
        			   Task.execute();        		  
        			   q.notify();
        		   }
        	   	}
           }
    }
}
class Task
{   
    private static int counter = 0;
    private static int id;    
    public Task () 
    {
           id = counter++;
    }
    
    public static  void execute ()
    {
           System.out.println(Thread.currentThread().getName());
           try 
           {
                  System.out.println("Executing Task #" +id);
                  Thread.sleep(5000);
           } 
           catch (InterruptedException e) 
           {
                  e.printStackTrace();
           }
    }
}
    
public class ThreadPoolRunner
{
	public static void main(String[] args) throws Exception
	{		
		Queue<Task> q=new LinkedList<Task>();	
		synchronized(q) 
		{			
			while(true)
			{
				if(q.size()==5)
					q.wait();
				for(int i=0;i<=5;i++)
				{
					q.add(new Task());
					q.notify();		
				}
						
			}
	}
}
}
    

