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
package org.jboss.as.quickstarts.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Definition of the two JMS destinations used by the quickstart
 * (one queue and one topic).
 */
@JMSDestinationDefinitions(
    value = {
        @JMSDestinationDefinition(
            name = "java:/queue/HELLOWORLDMDBQueue",
            interfaceName = "javax.jms.Queue",
            destinationName = "HELLOWORLDMDBQueue"
        ),
        @JMSDestinationDefinition(
            name = "java:/topic/HELLOWORLDMDBTopic",
            interfaceName = "javax.jms.Topic",
            destinationName = "HelloWorldMDBTopic"
        )
    })
/**
 * <p>
 * A simple servlet 3 as client that sends several messages to a queue or a topic.
 * </p>
 *
 * <p>
 * The servlet is registered and mapped to /HelloWorldMDBServletClient using the {@linkplain WebServlet
 * @HttpServlet}.
 * </p>
 *
 * @author Serge Pagop (spagop@redhat.com)
 *
 */
@WebServlet("/HelloWorldMDBServletClient")
public class HelloWorldMDBServletClient extends HttpServlet {

    private static final long serialVersionUID = -8314035702649252239L;

    private static final int MSG_COUNT = 5;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/queue/HELLOWORLDMDBQueue")
    private Queue queue;

    @Resource(lookup = "java:/topic/HELLOWORLDMDBTopic")
    private Topic topic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
//        out.write("<h1>Quickstart: Example demonstrates the use of <strong>JMS 2.0</strong> and <strong>EJB 3.2 Message-Driven Bean</strong> in JBoss EAP.</h1>");
        try {
            boolean useTopic = req.getParameterMap().keySet().contains("topic");
            final Destination destination = useTopic ? topic : queue;

            out.write("<p>Sending messages to <em>" + destination + "</em></p>");
            out.write("<h2>Following messages will be send to the destination:</h2>");
//            for (int i = 0; i < MSG_COUNT; i++) {
//                String text = "This is message " + (i + 1);
//                context.createProducer().send(destination, text);
//                out.write("Message (" + i + "): " + text + "</br>");
//            }
            String text = "Hello World!";
            long beforeTime = System.currentTimeMillis();
            
            context.createProducer().send(destination, text);
            
            out.write("Message : " + text);
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
            
    		
    		System.out.println("Time Taken to Sent the Message to "+destination +" : "+b.toString());
            
//            out.write("<p><i>Go to your JBoss EAP Server console or Server log to see the result of messages processing</i></p>");
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
