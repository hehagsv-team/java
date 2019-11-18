//package com.dss.basics;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


	public static void main(String[] args) throws IOException {
		
		
		ServerSocket ss= new ServerSocket(5002);
		
		while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                
                s = ss.accept(); 
                System.out.println("client has started ..........");
                DataInputStream in = new DataInputStream( 
    					new BufferedInputStream(s.getInputStream()));
                System.out.println("Assigning a thread");
                
                Thread t=new Mythread(s,in);
                t.start();
            }
            catch (Exception e) {
            	s.close();
            	e.printStackTrace();
			}
        }
	}
}

class Mythread extends Thread{
	
	Socket s;
	DataInputStream in;
	public Mythread(Socket s, DataInputStream in) {
		this.s=s;
		this.in=in; 	
	}
	
	public void run() {
	
		try {
			in = new DataInputStream( 
				new BufferedInputStream(s.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		} 

		String line = ""; 

	
		while (!line.equals("Over")) 
		{ 
			try
			{ 
				line = in.readUTF(); 
				System.out.println(line); 

			} 
			catch(IOException i) 
			{ 
				System.out.println(i); 
			} 
		} 
		System.out.println("Closing connection"); 
		
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
