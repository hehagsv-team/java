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
    
    HttpServletRequest request;
    
    HttpServletResponse response;
    int inc;
    /**
     * Default constructor.
     */
    public MemberRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }
    
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
            List<HclSkManufacturer> manu=service.listAllManufacuturer();
// 	        System.out.println("Manufacturer List are in doGet : "+manu);
	        request.setAttribute("manu", manu);
	        
	        String category=request.getParameter("category");
	        request.setAttribute("category", category);
           
// 	        System.out.println("in servlet before call in get ::"+inc);
	        inc=memberListService.retrieveAllMembersOrderedByName("first",0);
	        if(inc==-1) {
	        	request.setAttribute("noOrders", "No Orders...");
	        }
// 			System.out.println("in servlet after call in get::" +inc);
			request.setAttribute("inc", inc);
            
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
	        List<HclSkManufacturer> manu=service.listAllManufacuturer();
// 	        System.out.println("Manufacturer List are in doPost : "+manu);
	        request.setAttribute("manu", manu);
	        String category=request.getParameter("category");
	        request.setAttribute("category", category);
	       
//	        String navButton=request.getParameter("navButton");
			System.out.println("value of Navigation Button in servlet ::::: "+navButton);
// 			System.out.println("in servlet before call in post ::" +inc);
			inc=memberListService.retrieveAllMembersOrderedByName(navButton,inc);
			if(inc==-1) {
	        	request.setAttribute("noOrders", "No Orders...");
	        }
// 			System.out.println("in servlet after call in post::" +inc);
			request.setAttribute("inc", inc);
// 		    System.out.println("Order contains in servlet first ::: "+orders);
		
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
//		 System.out.println("Order contains in listAllOrders  ::: "+orders);
//		 request.setAttribute("no", "hiiiiiii");
//		 if(orders.isEmpty()) {
//			 request.setAttribute("noOrders", "No Orders...");
//		 }
//			 
		 

	}
		

