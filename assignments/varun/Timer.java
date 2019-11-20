package com.dss.p2basics;


class Counter {
	int i=0;
    public void display() {
           // write code
    	System.out.println("counter : "+ ++i);
    }
}

class Timer {
    // will tell the Counter.display() method to print every 5 sec
	public static void main(String[] args) throws InterruptedException
	{	
		
		Counter counter=new Counter();
		synchronized (counter) {
			while(true)
			{
				counter.wait(5000);
				counter.display();
			}
		}
		
	}
}