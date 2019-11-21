class NumberOfThreads extends Thread
{
	public void run()
	{
		try
		{
			System.out.println("thread"+Thread.currentThread().getId()+"is running");
			
		}
		catch(Exception e)
		{
			System.out.println("out of stack exception");
		}
	}
}
class Multithread
{
	public static void main(String args[])
	{
		while(true)
		{
		NumberOfThreads obj=new NumberOfThreads();
		obj.start();
		}
	
	}
}