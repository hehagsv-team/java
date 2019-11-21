package com.dss.p2basics;

public class ThreadsNo {

	//private static final int NUM_JOBS_TO_CREATE = 0;

	public static void main(String[] args) {
		
		//Mythread t=new Mythread();
		int j=0;
		 Thread[] threads = new Thread[1000000000];
		 for (int i = 0; i < threads.length; i++,j++) {
		     threads[i] = new Thread(new Runnable() {
		         public void run() {
		             // some code to run in parallel
		             // this could also be another class that implements Runnable
		        	
		         }
		     });
		     System.out.println(j);
		     threads[i].start();
		 }

	}

}
