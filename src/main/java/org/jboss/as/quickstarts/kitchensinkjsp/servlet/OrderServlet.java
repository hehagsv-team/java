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

        System.out.println("ENTERED INTO ORDERS DOGET() METHOD");
    	StringBuilder errorMessage = new StringBuilder();
        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
        try {

        	
//         OrdersDetailsDto orderDetails=service.listAllMembers();
        	
//        	OrdersDetailsDto orderDetails=service.listAllMembers();
//        	Object[] orderDetails=service.listAllMembers();

//            System.out.println("Order Details : "+orderDetails);
//            for(int i=0;i<orderDetails.size();i++)
// 		   {
// 			   System.out.println("orders in for loop  "+orderDetails.get(i));
//     		   OrdersDetailsDto order=orderDetails.get(i);	        		   
//     		   arrOrders.add(order);	        		   	        		  
//     		   System.out.println("Details in arrOrders is : "+arrOrders);
// 		   }
//            request.setAttribute("orders", orderDetails);
//            request.setAttribute("orders", arrOrders);

//            List<HclSkManufacturer> manu=service.listAllManufacuturer();
//	        System.out.println("Manufacturer List are : "+manu);
//	        request.setAttribute("manu", manu);
//	        
//	        String category=request.getParameter("category");
//	        request.setAttribute("category", category);
//           
//        	int maxTableSize=3;
	        int start=0;
	        request.setAttribute("start",start);
        	String username=request.getParameter("username");
	        System.out.println("USERNAME IN ORDER DOGET() SERVLET "+username);
            List<Object[]> orderDetails=service.listAllOrders(username,maxTableSize);
            System.out.println("Order Deatils : "+orderDetails);
            request.setAttribute("members", orderDetails);
            
        } catch (Exception e) {

            Throwable t = e;
            while ((t.getCause()) != null) {
                t = t.getCause();
            }

            errorMessage.append("Error========>" + t.getMessage());
            request.setAttribute("infoMessage", "");
            e.printStackTrace();
        } finally {
            request.setAttribute("errorMessage", errorMessage.toString());
            RequestDispatcher resultView = request.getRequestDispatcher("orders.jsp");
            resultView.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String username = request.getParameter("username");
    	System.out.println("Username in dopost() method of OrderServlet  : "+ username);
    	request.setAttribute("name", username);
        StringBuilder errorMessage = new StringBuilder();
        System.out.println("ENTERED INTO ORDERS DOPOST() METHOD");
        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
        String pageButton=request.getParameter("firstButton");
        request.setAttribute("maxTableSize", maxTableSize);
        System.out.println("pagination button clicked in post OrderServlet is : : "+pageButton);
       String parameter = request.getParameter("tableStart");
       int start=0;
       if(parameter!=null){

			start=Integer.parseInt(parameter);
		}
       request.setAttribute("start", start);
       if(pageButton==null)
        {

            List<Object[]> orderDetails=service.listAllOrders(username,maxTableSize);
            System.out.println("Order Deatils : "+orderDetails);
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
        	 Query createQuery = em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username");
        	 createQuery.setParameter("Username", username);
        	List<Object[]> resultList2 = createQuery.getResultList();
        	int size = resultList2.size();
        	request.setAttribute("manufacturerSize", size);
        	String block=null;
        	if(pageButton.equals("Next"))
			{
        		System.out.println("control enteres into Next OrderServlet");
//				String HQL="SELECT items.Name, items.Price,ord.quantity FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0";
//				Query createQuery = em.createQuery(HQL);
				System.out.println("start value in NEXT ORDERS"+start);
				start=start+maxTableSize;
				createQuery.setFirstResult(start);
				createQuery.setMaxResults(maxTableSize);
				@SuppressWarnings("unchecked")
				List<Object[]> resultList = createQuery.getResultList();
				
				
			    request.setAttribute("members", resultList);
				System.out.println("The resultset items are: : : "+resultList);
//				start=start+2;
				System.out.println("start value in NEXT ORDERS"+start);
				System.out.println("the value sending to the cart page from DOPOST() method : "+start);
				request.setAttribute("start", start);
				
			}
			else if(pageButton.equals("First"))
			{
//				System.out.println("entered into FIRST loop : : start value is : "+start+"\t Max value is : "+max);
				start=0;
//				Query createQuery = em.createQuery(HQL);
				createQuery.setFirstResult(start);
				createQuery.setMaxResults(maxTableSize);
				@SuppressWarnings("unchecked")
				List<Object[]> resultList = createQuery.getResultList();
//				start=start;
				request.setAttribute("start", start);
			    request.setAttribute("members", resultList);
				System.out.println("The resultset items are: : : "+resultList);
				System.out.println("the value of start inside first :"+start );
				
			}
			
			else if(pageButton.equals("Last"))
			{
//				System.out.println("entered into LAST loop : : start value is : "+start+"\t Max value is : "+max);

//				
//				String HQL="SELECT items.Name, items.Price,ord.quantity FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0";
//				System.out.println("entered into FIRST loop : : start value is : "+start+"\t Max value is : "+max);
//				
//				Query createQuery = em.createQuery(HQL);
				start=size-maxTableSize;
//				System.out.println("entered into LAST loop : : start value is : "+start+"\t Max value is : "+max);

				createQuery.setFirstResult(start);
				createQuery.setMaxResults(maxTableSize);
				@SuppressWarnings("unchecked")
				List<Object[]> resultList = createQuery.getResultList();
//				start=start+2;
				request.setAttribute("start", start);
			    request.setAttribute("members", resultList);
				System.out.println("The resultset items are: : : "+resultList);
				System.out.println("the value of start inside first :"+start );

			}
			
			
			else if(pageButton.equals("Previous"))
			{
//				System.out.println("entered into PREVIOUS loop : : start value is : "+start+"\t Max value is : "+max);
				start=start-maxTableSize;
//				System.out.println("entered into PREVIOUS loop : : start value is : "+start+"\t Max value is : "+max);
				System.out.println("ENTERED INTO PREVIOUS ORDERSERVLET");
				if(start<=0)
					start=start-start;
				createQuery.setFirstResult(start);
				createQuery.setMaxResults(maxTableSize);
				@SuppressWarnings("unchecked")
				List<Object[]> resultList = createQuery.getResultList();
//				start=start+2;
				request.setAttribute("start", start);
			    request.setAttribute("members", resultList);
				System.out.println("The resultset items are: : : "+resultList);
				System.out.println("the value of start inside first :"+start );
				
				
			}

        }

        RequestDispatcher resultView = request.getRequestDispatcher("orders.jsp");
        resultView.forward(request, response);
	}

}
