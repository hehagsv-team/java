package jmsptoptutorial;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.NamingException;

public class HelloWorldProducer {
	public static void main(String[] args) throws NamingException, JMSException {
		Connection connection = null;
		try {
			System.out.println("Create JNDI Context");
			Context context = ContextUtil.getInitialContext();

			System.out.println("Get connection facory");
			ConnectionFactory connectionFactory = (ConnectionFactory) context
					.lookup("ConnectionFactory");

			System.out.println("Create connection");
			connection = connectionFactory.createConnection();

			System.out.println("Create session");
			Session session = connection.createSession(false,
					QueueSession.AUTO_ACKNOWLEDGE);

			System.out.println("Lookup queue");
			Queue queue = (Queue) context.lookup("/queue/HelloWorldQueue");

			System.out.println("Start connection");
			connection.start();

			System.out.println("Create producer");
			MessageProducer producer = session.createProducer(queue);

			String s = "";
			do {
				//            for(int i=0;i<1000;i++)
				//            {
				System.out.print("Enter message to send -->");
				Scanner in = new Scanner(System.in); 
				s = in.nextLine(); 
				System.out.println("Reading::message-->" + s);
				Message hellowWorldText = session.createTextMessage("Hello World!" + s);
				System.out.println("Producer::message-->" + s);
				producer.send(hellowWorldText);
				//            }
			} while (!s.equals("EXIT"));

		} finally {
			if (connection != null) {
				System.out.println("close the connection");
				connection.close();
			}

		}

	}
}