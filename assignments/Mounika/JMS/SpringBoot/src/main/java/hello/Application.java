
package hello;

import java.util.concurrent.TimeUnit;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class Application {

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
													DefaultJmsListenerContainerFactoryConfigurer configurer) {
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the message converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	public static void main(String[] args) {
		// Launch the application
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		long bt = System.currentTimeMillis();
		System.out.println("Connecting to the Server..");
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		
		long at = System.currentTimeMillis();
        long d=at-bt;		
		StringBuilder serverTime=TimeTaken(d);
	   
		
		System.out.println("Time Taken to Connect the Server: "+serverTime.toString());
		// Send a message with a POJO - the template reuse the message converter
		
		long beforeTime = System.currentTimeMillis();
		System.out.println("Sending an email message.");
		
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
		
		long afterTime = System.currentTimeMillis();
        long diff=afterTime-beforeTime;		
		StringBuilder sentTime=TimeTaken(diff);
	   
		
		System.out.println("Time Taken to Send the Message: "+sentTime.toString());
		
		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"){
			@SuppressWarnings("unused")
			public Message createMessage(Session session) throws JMSException{
				TextMessage text=session.createTextMessage();
				text.setText("Hello");
				return text;
			}
		});
		
		
	}

	private static StringBuilder TimeTaken(long diff) {
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
	        return b;
	}

}
