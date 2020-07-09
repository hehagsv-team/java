package hello;

import java.util.concurrent.TimeUnit;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	
	long beforeTime = System.currentTimeMillis();
	
	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(Email email) {
		System.out.println("Received <" + email + ">");
		long afterTime = System.currentTimeMillis();
        long diff=afterTime-beforeTime;		
		
	    long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
        long remainingSecondsInMillis = diff - TimeUnit.MINUTES.toMillis(minutes);  
        long seconds = TimeUnit.MILLISECONDS.toSeconds(remainingSecondsInMillis);  
        long remainingMilliSecInMillis = remainingSecondsInMillis - TimeUnit.SECONDS.toMillis(seconds); 
        long milliSeconds = TimeUnit.MILLISECONDS.toMillis(remainingMilliSecInMillis);
        
        StringBuilder b = new StringBuilder();
        b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : 
        String.valueOf(minutes));
        b.append(":");
        b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) :     
        String.valueOf(seconds));
        b.append(":");
        b.append(milliSeconds == 0 ? "00" : milliSeconds < 10 ? String.valueOf("0" + milliSeconds) : 
        String.valueOf(milliSeconds));
        
		
		System.out.println("Time Taken to Receive the Message: "+b.toString());
	}
	

}
