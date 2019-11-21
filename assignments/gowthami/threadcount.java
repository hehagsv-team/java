package com.dff;
class Multithreading extends Thread 
{ 	
    public void run() 
    {    	
    	System.out.println(Thread.activeCount());
    	Thread[] T=new Thread[1000000000];
        try
        {
       		Thread.sleep(2000);
        	for(int i=0;i<=T.length;i++)
             	{ 
        		System.out.println(++i);
             	}
        } 
        catch (Exception e) 
        {           
            System.out.println ("Exception is caught"); 
        } 
    } 
}  
public class Multi 
{ 
    public static void main(String[] args) 
    {        
            Multithreading object = new Multithreading(); 
            object.start(); 
    } 
} 