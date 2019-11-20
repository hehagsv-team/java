class Counter2 {
		int count=0;
		public void display()
		{
			System.out.println("counter value : "+ ++count);
		}
}
class count
{
	public static void main(String[] args)
	{
		try
		{
			Counter2 c=new Counter2();
			synchronized(c)
			{
				for(;;)
				{
					c.wait(5000);
					c.display();
				}
			}
		}
		catch(InterruptedException e)
		{
			 System.out.println("Interrupted");
		}		
	}
}
