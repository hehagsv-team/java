/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.mdb;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * <p>
 * A simple Message Driven Bean that asynchronously receives and processes the messages that are sent to the topic.
 * </p>
 *
 * @author Serge Pagop (spagop@redhat.com)
 *
 */
@MessageDriven(name = "HelloWorldQTopicMDB", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "topic/HELLOWORLDMDBTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class HelloWorldTopicMDB implements MessageListener {

    private final static Logger LOGGER = Logger.getLogger(HelloWorldTopicMDB.class.toString());

    /**
     * @see MessageListener#onMessage(Message)
     */
    
    public void onMessage(Message rcvMessage) {
        TextMessage msg = null;
        try {
        	long beforeTime = System.currentTimeMillis();
            if (rcvMessage instanceof TextMessage) {
                msg = (TextMessage) rcvMessage;
                LOGGER.info("Received Message from topic: " + msg.getText());
                
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
                
        		
                LOGGER.info("Time Taken to Receive the Message from Topic: "+b.toString());
            } else {
                LOGGER.warning("Message of wrong type: " + rcvMessage.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
