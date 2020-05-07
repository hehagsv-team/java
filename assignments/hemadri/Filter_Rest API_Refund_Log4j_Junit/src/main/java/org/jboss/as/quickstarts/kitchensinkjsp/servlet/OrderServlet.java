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
package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jboss.as.quickstarts.kitchensinkjsp.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensinkjsp.data.MemberListProducer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.Items;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetails;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;

/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
	static Logger logger = Logger.getLogger(OrderServlet.class);
    
    @Inject
    EntityManager em;
    @Inject
    MemberRegistration registrationService;
    @Inject
    CartResourceRESTService service;
    @Inject
    MemberListProducer memberListService;

    int maxTableSize=3;
    /**
     * Default constructor.
     */
    public OrderServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        logger.info("ENTERED INTO ORDERS DOGET() METHOD");
    	StringBuilder errorMessage = new StringBuilder();
        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
        	
        	HttpSession session = request.getSession(false);
    		String username = (String)session.getAttribute("UsernameFilter");
    		logger.debug("........Username in OrderServlet that is taken from Servlet : "+username);    	
    		request.setAttribute("name", username);
    			   int start=0;
    		        request.setAttribute("start",start);
//    	        	String username=request.getParameter("username");
    		       logger.debug("USERNAME IN ORDER DOGET() SERVLET "+username);
    	            List<Object[]> orderDetails=service.listAllOrders(username,maxTableSize);
    	           logger.debug("Order Deatils : "+orderDetails);
    	            request.setAttribute("members", orderDetails);
    	            RequestDispatcher resultView = request.getRequestDispatcher("orders.jsp");
    	            resultView.forward(request, response);
    	         
    		

	        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	

		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
		logger.debug("........Username in cartservlet that is taken from Servlet : "+username);

	    	logger.debug("Username in dopost() method of OrderServlet  : "+ username);
	    	request.setAttribute("name", username);
	        StringBuilder errorMessage = new StringBuilder();
	       logger.info("ENTERED INTO ORDERS DOPOST() METHOD");
	        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
	        String pageButton=request.getParameter("firstButton");
	        request.setAttribute("maxTableSize", maxTableSize);
	        logger.debug("pagination button clicked in post OrderServlet is : : "+pageButton);
	       String parameter = request.getParameter("tableStart");
	       int start=0;
	       if(parameter!=null){

				start=Integer.parseInt(parameter);
			}
	       request.setAttribute("start", start);
	       if(pageButton==null)
	        {

	            List<Object[]> orderDetails=service.listAllOrders(username,maxTableSize);
	            logger.debug("Order Deatils : "+orderDetails);
	            int listAllOrdersSize = service.listAllOrdersSize(username,maxTableSize);
	            if(listAllOrdersSize==0)
	            {
	            	String blockTable="blockAllTable";
	            	request.setAttribute("blockAllTable",blockTable);
	            }
	            if(listAllOrdersSize<=maxTableSize)
		    	{
	    			String block="sufficient";
	    			request.setAttribute("blockAll", block);
		    	}
	    		request.setAttribute("members", orderDetails);

	        }
	        
	        else {
	        	 Query createQuery = em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id=O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username");
	        	 createQuery.setParameter("Username", username);
	        	List<Object[]> resultList2 = createQuery.getResultList();
	        	int size = resultList2.size();
	        	request.setAttribute("manufacturerSize", size);
	        	String block=null;
	        	if(pageButton.equals("Next"))
				{
	        		logger.info("control enteres into Next OrderServlet");
//					String HQL="SELECT items.Name, items.Price,ord.quantity FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0";
//					Query createQuery = em.createQuery(HQL);
					logger.debug("start value in NEXT ORDERS"+start);
					start=start+maxTableSize;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
					
					
				    request.setAttribute("members", resultList);
				   
					logger.debug("The resultset items are: : : "+resultList);
//					start=start+2;
					 int sizes=resultList.size();
					   logger.debug("the size of the list is "+sizes);
					logger.debug("start value in NEXT ORDERS"+start);
					logger.debug("the value sending to the cart page from DOPOST() method : "+start);
					request.setAttribute("start", start);
					
				}
				else if(pageButton.equals("First"))
				{
					start=0;
//					Query createQuery = em.createQuery(HQL);
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					 int sizes=resultList.size();
					  logger.debug("the size of the list is "+sizes);
					logger.debug("the value of start inside first :"+start );
					
				}
				
				else if(pageButton.equals("Last"))
				{
					start=size-maxTableSize;
//					

					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					logger.debug("the value of start inside first :"+start );

				}
				
				
				else if(pageButton.equals("Previous"))
				{
//					
					start=start-maxTableSize;
//	
					logger.info("ENTERED INTO PREVIOUS ORDERSERVLET");
					if(start<=0)
						start=start-start;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					logger.debug("the value of start inside first :"+start );
					
					
				}

	        }

	        RequestDispatcher resultView = request.getRequestDispatcher("orders.jsp");
	        resultView.forward(request, response);
    	
    	
    	
    		}

}
