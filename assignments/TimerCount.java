public class TimerCount {
	  public static Object monitor = new Object();
	  public static int counter=0;
	  public static class Counter extends Thread
	  {
	    public void run() {
	    	for(int i=1;i<=10;i++)
	    	{	    		
	    	        synchronized(monitor) {
	    	          try {
	    	        	  monitor.wait(5000);	    	          
	    	            System.out.println("Timer count after 5 seconds is: " + ++counter);
	    	          }
	    	          catch(InterruptedException e) {}	    	              	          
	    	       }    	         	         	   
	    	}
	      
	    }
	  }
	  
	  public static class Timer extends Thread
	  {
	    public void run() {
	      
	      for(int i=1;i<=10;i++)
	      {	    	  	      
		      synchronized(monitor) {
		    	  
		    	  monitor.notifyAll();
		      } 
	      }
	     
	    }
	  }
	  
	  public static void main(String[] args) {
		
	    new Counter().start();
	    new Timer().start();
	  }
	}


