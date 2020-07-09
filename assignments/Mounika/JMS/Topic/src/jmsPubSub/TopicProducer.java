package jmsPubSub;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;

public class TopicProducer {

	static long beforeSend;
	
	public static void main(String[] args) throws JMSException, NamingException {
		System.out.println("-------Entering JMS Example TopicProducer--------");
		
		Context context = TopicConsumer.getInitialContext();
		TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
		Topic topic = (Topic) context.lookup("topic/jms_pub_sub"); 
		TopicConnection connection= connectionFactory.createTopicConnection();
		TopicSession session = connection.createTopicSession(false,TopicSession.AUTO_ACKNOWLEDGE);
		connection.start();
		TopicProducer topicProducer = new TopicProducer();
		String s="";
		do{
//			long before=System.currentTimeMillis();
			System.out.print("Enter message to send -->");
			Scanner in = new Scanner(System.in); 
			s = in.nextLine(); 
//			long after = System.currentTimeMillis();
//	        long diff=after-before;	
//	        String time = topicProducer.TimeTaken(diff);
			System.out.println("Message before publish is -->" + s);
			
			beforeSend=System.currentTimeMillis();
			topicProducer.sendMessage(s, session, topic);
			long afterSend = System.currentTimeMillis();
//			System.out.println("After send time in TP: "+afterSend);
	        long d=afterSend-beforeSend;	
	        String timeSend = TopicProducer.TimeTaken(d);
	        System.out.println("Time delay between Message enter and message pulish "+timeSend);
		}while (!s.equals("EXIT"));
		System.out.println("-------Exiting JMS Example TopicProducer--------");
	}
	
	public static long getBeforeSend()
	{
		return beforeSend;
	}
	public void sendMessage(String text,TopicSession session,Topic topic) throws JMSException {
		TopicPublisher topicPublisher = session.createPublisher(topic);
		TextMessage textMessage = session.createTextMessage(text);
		topicPublisher.publish(textMessage);
		topicPublisher.close();		
	}
	public static String TimeTaken(long diff) {
		
//		System.out.println("After time: "+after);
//		System.out.println("before time: "+beforeSend);
//		long diff=after-beforeSend;
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
        return b.toString();
	}

}
