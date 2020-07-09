package jmsPubSub;

import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class TopicConsumer implements MessageListener{
	
	private static boolean exitTrue = false;
	
	public static void main(String[] args) throws JMSException, NamingException, InterruptedException {
		
		System.out.println("-------Entering JMS Example TopicConsumer--------");
		
		Context context = TopicConsumer.getInitialContext();
		TopicConnectionFactory connectionFactory = (TopicConnectionFactory) context.lookup("ConnectionFactory");
		Topic topic = (Topic) context.lookup("topic/jms_pub_sub"); 
		TopicConnection connection= connectionFactory.createTopicConnection();
		TopicSession session = connection.createTopicSession(false,TopicSession.AUTO_ACKNOWLEDGE);
		session.createSubscriber(topic).setMessageListener(new TopicConsumer());
		connection.start();
		while (!exitTrue) {
			synchronized (TopicConsumer.class) {
				TopicConsumer.class.wait();
				if (exitTrue) {
					if (connection != null) {
						System.out.println("close the connection");
						connection.close();
					}
				} 
			}
		}
		System.out.println("-------Exiting JMS Example TopicConsumer--------");
	}
	

	@Override
	public void onMessage(Message message) {
		try {
//			long before=TopicProducer.getBeforeSend();
//			System.out.println("before time in TC: "+before);
			long before=System.currentTimeMillis();
			String Message = ((TextMessage) message).getText();
			System.out.println("Incoming Message : "+Message);
			long after = System.currentTimeMillis();
	        long diff=after-before;	
	        String time = TopicProducer.TimeTaken(diff);
			System.out.println("Time taken to receive a message is : "+time);
			
			if (Message.equals("EXIT")) {
				TopicConsumer.exitTrue = true;
				synchronized (TopicConsumer.class) {
					TopicConsumer.class.notifyAll();
				}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}	
	}
	
	public static Context getInitialContext() throws JMSException, NamingException {
        Properties props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
        props.setProperty("java.naming.provider.url", "localhost:1099");
        Context context = new InitialContext(props);
        return context;
    }

}
