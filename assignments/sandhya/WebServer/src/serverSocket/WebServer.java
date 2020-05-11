package serverSocket;
import java.net.*; 

public class WebServer {
	public static void main(String[] args) throws Exception {
		try {
		ServerSocket server=new ServerSocket(8888);
		System.out.println("server started");
		while(true) {
		Socket s=server.accept();
		MultiThread t=new MultiThread(s);
		t.start();
		}
		}catch(Exception e){
		      System.out.println(e);
	    }
	}
}


