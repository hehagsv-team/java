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

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
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
import org.jboss.as.quickstarts.kitchensinkjsp.model.Items;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetails;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.MemberResourceRESTService;

/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/orders")
public class MemberRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    MemberRegistration registrationService;
    @Inject
    MemberResourceRESTService service;
    @Inject
    MemberListProducer memberListService;

    
    private List<OrdersDetailsDto> orders;
    
    @Produces
    @Named
    public List<OrdersDetailsDto> getOrders() {
        return orders;
    }
    
    @Inject
    private EntityManager em;
    
//    HttpServletRequest request;
//    
//    HttpServletResponse response;
//    
    int count=8 ,inc=0;
    /**
     * Default constructor.
     */
    public MemberRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

//    @Produces
//    @Named
//    public List<OrdersDetailsDto> getMembers() {
//        return members;
//    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @SuppressWarnings("unchecked")
    @RequestScoped
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder errorMessage = new StringBuilder();
        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
        try {

//        	this.request=request;
//			this.response=response;
        	
			
			
//         List<OrdersDetailsDto> orderDetails=service.listAllMembers();
        	
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

            List<HclSkManufacturer> manu=service.listAllManufacuturer();
	        System.out.println("Manufacturer List are in doGet : "+manu);
	        request.setAttribute("manu", manu);
	        
	        String category=request.getParameter("category");
	        request.setAttribute("category", category);
           
//	        Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(0);
//		    query.setMaxResults(2);
//		    orders=query.getResultList();
//		    System.out.println("Orders in doGet ::: "+orders);
//	        System.out.println("name : "+orders.get(0)+"\t price :"+orders.get(1));
//            List<Orders> orderDetails=service.listAllMembers();
//            System.out.println("Order Deatils : "+orderDetails);
//            request.setAttribute("orders", orderDetails);
            
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
    @SuppressWarnings("unchecked")
    @RequestScoped
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        StringBuilder errorMessage = new StringBuilder();

		try {
//			this.request=request;
//			this.response=response;
			
			String navButton=request.getParameter("navButton");
//			memberListService.onMemberListChanged(request, response,navButton);
			
	        List<HclSkManufacturer> manu=service.listAllManufacuturer();
	        System.out.println("Manufacturer List are in doPost : "+manu);
	        request.setAttribute("manu", manu);
	        String category=request.getParameter("category");
	        request.setAttribute("category", category);
	       
//	        String navButton=request.getParameter("navButton");
			
//	        System.out.println("value of Navigation Button in servlet ::::: "+navButton);
//			if(navButton.equals("first")) {
//			Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(0);
//		    query.setMaxResults(2);
//		    orders=query.getResultList();
//		    
//		    System.out.println("Order contains in servlet ::: "+orders);
//		}
//		else if(navButton.equals("last")) {
//			Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(count-2);
//		    query.setMaxResults(2);
//		    orders=query.getResultList();
//		    System.out.println("Order contains in servlet  ::: "+orders);
//		}
//		else if(navButton.equals("next")) {
//			Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(inc+2);
//		    query.setMaxResults(2);
//		    orders=query.getResultList();
//		    inc=inc+2;
//		    System.out.println("Order contains in servlet ::: "+orders);
//		}
//		else if(navButton.equals("previous")) {
//			Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(inc-2);
//		    query.setMaxResults(2);
//		    orders=query.getResultList();
//		    inc=inc-2;
//		    System.out.println("Order contains in servlet  ::: "+orders);
//		}
			
			
		

	        
	        
//	        List<Items> items=service.listManuItems(category);
//	        System.out.println("Filter By Manufcaturer items are :: "+items);
//	        request.setAttribute("items", items);
	        
		}        
		catch (Exception e) {

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

//	public void listAllOrders(List<OrdersDetailsDto> members) {
//
//		orders=members;
//	}
		
}
