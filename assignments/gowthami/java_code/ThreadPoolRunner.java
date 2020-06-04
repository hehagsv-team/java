package assignments.gowthami;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
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
		ThreadPoolRunner.log("ThreadPoolRun::start()");
		while (true) 
		{
			synchronized(q)
			{
				ThreadPoolRunner.log("ThreadPoolRun::LOCKED");
				if(q.isEmpty())
				{      		   
					try {
						ThreadPoolRunner.log("ThreadPoolRun::Q is empty. Going to WAIT");
						q.wait();
						ThreadPoolRunner.log("ThreadPoolRun::Out of WAIT");
					} 
					catch (InterruptedException e)
					{					
						e.printStackTrace();
					}
				}
				else
				{    
					ThreadPoolRunner.log("ThreadPoolRun::Executing Task");
					Task.execute();        		  
					q.notify();
					ThreadPoolRunner.log ("ThreadPoolRun::NOTIFY");
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
		try 
		{
			ThreadPoolRunner.log("Task::Executing START Task #" +id);
			Thread.sleep(5000);
			ThreadPoolRunner.log("Task::Executing DONE Task #" +id);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}

public class ThreadPoolRunner
{
	public static void main(String[] args) /* throws Exception */
	{		
		
		Queue<Task> q=new LinkedBlockingQueue<Task>(5);	
		new ThreadPool (q);
		addTasks(q);
	}

	private static void addTasks(Queue<Task> q) {
		while(true)
		{
			synchronized(q) 
			{			
				log("Main::LOCKED");
				log ("Main::queue size="+q.size());
				if(q.size()>=5) {
					log ("Main::going to WAIT");
					try {
						q.wait();
						log ("Main::got out of WAIT");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//				for(int i=0;i<=5;i++)
				//				{
				try {
					q.add(new Task());
					log ("Main::Added new Task");
				} catch (IllegalStateException e) {
					log ("Ignoring Exception"+e);
					e.printStackTrace();
					// ignore
				}
				q.notifyAll();	
				log ("Main::NOTIFY");
				//				}

			}
		}
	}
	
	static void log (String msg) {
		System.out.println("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] "+msg);
	}
}


