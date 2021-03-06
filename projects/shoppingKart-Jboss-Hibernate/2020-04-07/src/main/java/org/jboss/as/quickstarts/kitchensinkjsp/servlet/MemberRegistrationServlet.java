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
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.as.quickstarts.kitchensinkjsp.controller.LoginUser;
import org.jboss.as.quickstarts.kitchensinkjsp.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensinkjsp.data.MemberListProducer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Item;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.MemberResourceRESTService;

/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/register.do")
public class MemberRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    MemberRegistration registrationService;
    
    @Inject
    LoginUser registrationServices;

    
    @Inject
    MemberResourceRESTService memberResourceRESTService;
    

    @Inject
    MemberListProducer memberListService;

    /**
     * Default constructor.
     */
    public MemberRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder errorMessage = new StringBuilder();

        try {

//            System.out.println("EMAIL='" + request.getParameter("email") + "'");
            Member member;
            // create a new member, remember :) the memberservice do not
            // call the initMethod if an error occur during the previous persist request

//            while ((member = registrationService.getNewMember()) == null) {
//                registrationService.initNewMember();
//            }
//
//            String value;
//
//            if ((value = request.getParameter("name")).length() < 1) {
//                errorMessage.append("Name can not be null\n");
//            } else {
//                member.setName(value);
//
//                if ((value = request.getParameter("email")).length() < 1) {
//                    errorMessage.append("email required!\n");
//                } else {
//                    member.setEmail(value);
//
//                    if ((value = request.getParameter("phoneNumber")).length() < 1) {
//                        errorMessage.append("phoneNumber required \n");
//                    } else // all parameters are filled, register
//                    {
//                        member.setPhoneNumber(value);
//
//                        log("\n*****************Try Registration of Member=" + member);
//                        registrationService.register();
//                        request.setAttribute("infoMessage", member.getName() + " Registered!");
//                    }
//                }

            String name=request.getParameter("name"); Boolean
			  isvalid= memberResourceRESTService.validuser(name);
			  System.out.println("before isValid if :: "+isvalid+" name :: "+name);
			  if(!isvalid) {
			  System.out.println("Inside isValid if :: "+isvalid+" name :: "+name);
			  
			  errorMessage.append("Invalid user"); 
			  }
			  else {
				  List<Item>listAllMembers=memberResourceRESTService.listAllMembers();
                  System.out.println("result::::"+listAllMembers);
                  request.setAttribute("items", listAllMembers);
				  RequestDispatcher resultView =
			  request.getRequestDispatcher("registrationResult.jsp"); 
				  
			 
			//  request.setAttribute("infoMessage", " Welcome...!!!");
			  System.out.println("inside isValid else :: "+isvalid+" name :: "+name);
			  resultView.forward(request, response); 
			  }
			 
			  if(request.getParameter("rdbutton").equals("List by Price") && request.getParameter("man_button").equals("Apply"))
			  {
				  String button=request.getParameter("rdbutton");
				  String applbutton=request.getParameter("man_button");
				  System.out.println("the value of radio butto is "+button);
				  System.out.println("the value of apply bbutto is "+applbutton);
			     int max=Integer.parseInt(request.getParameter("text2"));
			     int min=Integer.parseInt(request.getParameter("text1"));
			     System.out.println("the maximum value is"+max);
			     System.out.println("the minimum value is"+min);
			     List<Item>listAllPrices=memberResourceRESTService.listByPricerange(max, min);
			     System.out.println("result:::"+listAllPrices);
			     request.setAttribute("items", listAllPrices);
			     RequestDispatcher resultView =
						  request.getRequestDispatcher("registrationResult.jsp"); 
						  resultView.forward(request, response); 
			  }
			  if(request.getParameter("rdbutton").equals("All") && request.getParameter("man_button").equals("Apply"))
			  {
				  String button=request.getParameter("rdbutton");
				  String applbutton=request.getParameter("man_button");
				  System.out.println("the value of radio butto is "+button);
				  System.out.println("the value of apply bbutto is "+applbutton);
				  List<Item>listAllMembers=memberResourceRESTService.listAllMembers();
                  System.out.println("result::::"+listAllMembers);
                  request.setAttribute("items", listAllMembers);
				  RequestDispatcher resultView = request.getRequestDispatcher("registrationResult.jsp"); 
				  resultView.forward(request, response); 
			    
			  }
			  if(request.getParameter("navButton").equals("next"))
			  {
				  String butooon=request.getParameter("navButton");
				  System.out.println("value of radio button is"+ butooon);
				  List<Item>listAllMembers=memberResourceRESTService.listAllMembers();
                  System.out.println("result::::"+listAllMembers);
                  request.setAttribute("items", listAllMembers);
				  RequestDispatcher resultView = request.getRequestDispatcher("registrationResult.jsp"); 
				  resultView.forward(request, response); 
				  
				  
			  }
			  
			  
			  
			  
			  
//                  List<Item>listAllMembers=memberResourceRESTService.listAllMembers();
//                  System.out.println("result::::"+listAllMembers);
//                  request.setAttribute("items", listAllMembers);
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
            RequestDispatcher resultView = request.getRequestDispatcher("registrationForm.jsp");
            resultView.forward(request, response);
        }
    }

}
