package serverSocket;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class MultiThread extends Thread {
    Socket s;
    String filename="hello1.html";
    String txtfile="file.html";
	public MultiThread(Socket s) {
		this.s=s;
	}

	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		BufferedOutputStream output = null;
		FileInputStream f=null;
		String file = null;
		byte []b= new byte[2002];
		try {
			 in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			 out = new PrintWriter(s.getOutputStream());
			 output=new BufferedOutputStream(s.getOutputStream());   
	    	 String input=in.readLine();
	    	 StringTokenizer p=new StringTokenizer(input);
		     String method = p.nextToken().toUpperCase(); 
		     file = p.nextToken().toLowerCase();
	    	 File file1=new File("web",file);
	    	 int a=(int) file1.length();
	    	 
	         if(file1.exists()) {	
             	    f=new FileInputStream(file1);
     	            f.read(b);
	            	out.println("HTTP/1.1 200 OK");
				    out.println("Server:WebServer");
					out.println("Content-type: " + "text/html");
					out.println("Content-length: " + file1.length());
					out.println(); 
					out.flush(); 
					output.write(b, 0, a);
     				output.flush();
					System.out.println("File " + file + "is found,sent to client and returned");
	    	    }
	            else {
	                	File file2 = new File("web",txtfile);
	                	int len = (int) file2.length();
	                	f = new FileInputStream(file2);
	   				    f.read(b);
	                    out.println("HTTP/1.1 404 File Not Found");
	            		out.println("Server: WebServer");
	            		out.println("Content-type: " + "text/html");
	            		out.println("Content-length: " + len);
	            		out.println(); 
	            		out.flush(); 
	            		output.write(b, 0,len);
         				output.flush();
	            		System.out.println("File " + file + " not found");

	                }
		}
	    catch (IOException x) {
	    	try {
				in.close();
				out.close();
				output.close();
				s.close();
				System.out.println("connection closed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
	}
}