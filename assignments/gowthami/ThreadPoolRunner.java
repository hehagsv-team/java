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

		while (true) 
		{
			System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
			System.out.println("ThreadPoolRun::Adding new Task");

			synchronized(q)
			{
				if(q.isEmpty())
				{      		   
					try {
						System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
						System.out.println("ThreadPoolRun::Q is empty. Going to wait");

						q.wait();
					} 
					catch (InterruptedException e)
					{					
						e.printStackTrace();
					}
				}
				else
				{    
					System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
					System.out.println("ThreadPoolRun::Executing Task");
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
		System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
		try 
		{
			System.out.println("Task::Executing Task #" +id);
			Thread.sleep(5000);
			System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
			System.out.println("Task::awoke");
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
				System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
				System.out.println("Main::queue size="+q.size());
				if(q.size()>=5) {
					System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
					System.out.println("Main::going to wait");
					try {
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
					System.out.println("Main::got out of wait");
				}
				//				for(int i=0;i<=5;i++)
				//				{
				try {
					q.add(new Task());
					System.out.print("["+Thread.currentThread().getName()+" Thread-ID="+Thread.currentThread().getId()+"] ");
					System.out.println("Main::Added new Task");
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// ignore
				}
				q.notifyAll();		
				//				}

			}
		}
	}
}


