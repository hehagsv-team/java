package solution.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

interface TimerListener {}

class Counter extends Thread implements TimerListener
{
	private static int counter=0;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
	public void run() {
		System.out.println("Counter::run()");
		for(int i=1;i<=10;i++)
		{	    		
			synchronized(this) {
				try {
					System.out.println("Counter::going to wait");
					this.wait();	
					System.out.println("Counter::just woke up");
					display();
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}	    	              	          
			}    	         	         	   
		}

	}
	public void display() {
		System.out.println("["+ format.format(new Date())+"]"+" Count #" + ++counter);		
	}
}

class Timer extends Thread
{
	private TimerListener listernerObj;
	
	Timer (TimerListener anObj){
		listernerObj = anObj;
	}
	
	public void run() {
		System.out.println("Timer::run()");
		while (true) {
			synchronized (listernerObj) {
//				System.out.println("Timer::lock in");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				listernerObj.notifyAll();
			} 
		} 

	}
}

public class TimerCount {

	public static void main(String[] args) {

		Counter aCounter = new Counter();
		aCounter.start();
		new Timer(aCounter).start();
		
	}
}


