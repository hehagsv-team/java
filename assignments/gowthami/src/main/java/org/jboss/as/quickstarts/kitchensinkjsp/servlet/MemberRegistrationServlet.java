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
import java.util.Objects;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.as.quickstarts.kitchensinkjsp.controller.LoginUser;
import org.jboss.as.quickstarts.kitchensinkjsp.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensinkjsp.data.MemberListProducer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkItems;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;

/**
 * Servlet implementation class MemberRegistrationServlet
 */
@WebServlet("/BrowseItems")
public class MemberRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private EntityManager em;

    @Inject
    MemberRegistration registrationService;
    
    @Inject
    LoginUser registrationServices;

    
    @Inject
    CartResourceRESTService memberResourceRESTService;
    
    @Inject
    MemberListProducer memberListService;

    String userName;
    /**
     * Default constructor.
     */
    public MemberRegistrationServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        StringBuilder errorMessage = new StringBuilder();
		System.out.println("control entered into doGet of main page");
//	try {	
////         String userName=request.getParameter("name");
//		
        HttpSession session = request.getSession(false);
        String userName = (String)session.getAttribute("UsernameFilter");
        System.out.println(".......UserName in DOGET() session from MainServlet is : "+userName);
        

        
        request.setAttribute("name", userName);
//        User cart=new User();
//        int start=0;
//        request.setAttribute("start", start);
//        request.setAttribute("radioButtonValueTextBox", "All");
//        System.out.println("the name send to cartServlet : "+userName);
//        Boolean isvalid= memberResourceRESTService.validuser(userName);
//		  System.out.println("before isValid if :: "+isvalid+" name :: "+userName);
//		  if(userName==null) {
//				request.setAttribute("commonMessage", "Please Login for Main Page");
//		      RequestDispatcher resultView = request.getRequestDispatcher("Login.jsp");
//		        resultView.forward(request, response);
//		  }
//		  if(!isvalid) {
//		  System.out.println("Inside isValid if :: "+isvalid+" name :: "+userName);
//		  
//		  errorMessage.append("Invalid user"); 
//		  }
//		  else {
//			  
			  
			  List<HclSkManufacturer> manu=memberResourceRESTService.listAllManufacuturer();
		        System.out.println("Manufacturer List are : "+manu);
		        request.setAttribute("manu", manu);
		        String category=request.getParameter("category");
		        System.out.println("the category inside doGet() is :"+category);
		        request.setAttribute("category", category);
		        
		        
		        
			  int MaxTableSize=3;
			List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(MaxTableSize);
              System.out.println("result::::"+listAllMembers);
              request.setAttribute("members", listAllMembers);
			  RequestDispatcher resultView =request.getRequestDispatcher("BrowseItems.jsp"); 
			  
		 
		//  request.setAttribute("infoMessage", " Welcome...!!!");
//		  System.out.println("inside isValid else :: "+isvalid+" name :: "+userName);
		  resultView.forward(request, response); 
//		  }
		 
//              List<Item>listAllMembers=memberResourceRESTService.listAllMembers();
//              System.out.println("result::::"+listAllMembers);
//              request.setAttribute("items", listAllMembers);
//    } catch (Exception e) {
//
//        Throwable t = e;
//        while ((t.getCause()) != null) {
//            t = t.getCause();
//        }
////
////        errorMessage.append("Error========>" + t.getMessage());
////        request.setAttribute("infoMessage", "");
////        e.printStackTrace();
//    } finally {
////        request.setAttribute("errorMessage", errorMessage.toString());
//		request.setAttribute("commonMessage", "Please Login for Main Page");
//        RequestDispatcher resultView = request.getRequestDispatcher("Login.jsp");
//        resultView.forward(request, response);
//    }
}
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StringBuilder errorMessage = new StringBuilder();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//        request.setAttribute("name", userName);
        
        
        HttpSession session = request.getSession(false);
        String username = (String)session.getAttribute("UsernameFilter");
        System.out.println(".......UserName in DOPOST() session from LoginServlet is : "+username);
        
//        if(username!=null)
//        {
            System.out.println("control enters into dopost () method in main page");
//          String username = request.getParameter("username");
          System.out.println("the value of input is : : "+username);
          request.setAttribute("name", username);
          
          
          String ValueTextBox=request.getParameter("radioButtonValue");
   
          System.out.println("Radio Button text Box Value "+ValueTextBox);
          request.setAttribute("radioButtonValueTextBox", ValueTextBox);
          if(ValueTextBox==null)
          	request.setAttribute("radioButtonValueTextBox", "All");       
          String category=request.getParameter("category");
          System.out.println("the category inside dooPost() is :"+category);
          request.setAttribute("category", category);
          String rdButton=request.getParameter("rdbutton");
          
          request.setAttribute("rdButton", rdButton);
          System.out.println("the radio button selected : "+rdButton);
          String pageButton = request.getParameter("firstButton");
          System.out.println("Page Button Clicked is"+pageButton);
          request.setAttribute("pageButton", pageButton);
         int start=0;
         request.setAttribute("start", start);
    	  List<HclSkManufacturer> manu=memberResourceRESTService.listAllManufacuturer();
        System.out.println("Manufacturer List are : "+manu);
        request.setAttribute("manu", manu);
        String categoryTextBox = request.getParameter("categoryValue");
        System.out.println("Category Text box : "+categoryTextBox);
        
        int maxTableSize=3;
        request.setAttribute("maxTableSize", maxTableSize);
        
            List<Objects []> resultList2 = null ;
            //query for View By Manufacturer
            if(pageButton!=null)
            {

  	        	 if(ValueTextBox.equals("Manufacturer"))
  	        	 {
  	        		 
  	        		 String HQL="SELECT items.Name,items.Price FROM HclSkItems items,HclSkManufacturer man WHERE "
  	     	    				+ "items.Manufacturer_Id=man.Id AND man.name=:categoryUser";
  	     	    		Query resultList = em.createQuery(HQL);
  	     	    		System.out.println("Catrgory VALUES IN MANUFACTUERE AND NEXT IS :"+categoryTextBox+"\t CATEGORY IS :"+category);
  	     	    		resultList.setParameter("categoryUser", categoryTextBox);
  	     	    		request.setAttribute("category",categoryTextBox );
  	     	    		Query createQuery = em.createQuery(HQL);
  	     	    		createQuery.setParameter("categoryUser", categoryTextBox);
  	     	    		List<Object[]> manResult = createQuery.getResultList();
  	     	    		int size = manResult.size();
  	     	    		System.out.println("size of LIST BY MANUFACTURER IS :"+size);
  	     	    		request.setAttribute("manufacturerSize", size);
  	     	    		if(size==maxTableSize)
  	     	    		{
  	     	    			String block="sufficient";
  	     	    			request.setAttribute("blockAll", block);
  	     	    		}
  	     	    	
  	                 if(pageButton.equals("Next"))
  	                 {
  	               	  String tableStart = request.getParameter("tableStart");
  	               	  start=Integer.parseInt(tableStart);
  	     	      		start=start+maxTableSize;
  	               	  System.out.println("entered into MANUFACTURER and NEXT");
  	       	    		resultList.setFirstResult(start);
  	       	    		resultList.setMaxResults(maxTableSize);
  	       	    		List<Object[]> result = resultList.getResultList();
  	       	    		System.out.println("list of items are"+result);
  	       	    		request.setAttribute("members", result);
//  	       	      		start=start+maxTableSize;
  	       	      		request.setAttribute("start", start);
  	               	 
  	                 }
  	                 
  	                 else if(pageButton.equals("First"))
  	                 {
  	               	  start=0;
  	               	  System.out.println("entered into MANUFACTURER and FIRST");
  	     	    		resultList.setFirstResult(start);
  	     	    		resultList.setMaxResults(maxTableSize);
  	     	    		List<Object[]> result = resultList.getResultList();
  	     	    		System.out.println("list of items are"+result);
  	     	    		request.setAttribute("members", result);
  	       	      		request.setAttribute("start", start);

  	               	  
  	                 }
  	                 
  	                 else if(pageButton.equals("Last"))
  	                 {
  	               	  System.out.println("entered into MANUFACTURER and LAST");
  	       	    		request.setAttribute("category",categoryTextBox );
  	       	    		start=size-maxTableSize;
  	       	    		resultList.setFirstResult(start);
  	       	    		resultList.setMaxResults(maxTableSize);
  	       	    		List resultList3 = resultList.getResultList();
  	       	    		request.setAttribute("members", resultList3);
  	       	    		request.setAttribute("start", start);
  	                 }
  	                
  	                 else if(pageButton.equals("Previous"))
  	                 {
  		               	  System.out.println("entered into MANUFACTURER and PREVIOUS");
  		               	 String tableStart = request.getParameter("tableStart");
  		               	  start=Integer.parseInt(tableStart);
  		               	  start=start-maxTableSize;
  		               	  System.out.println("the value of start inside MANUFACUTER and PREVIOUS : "+start);
  		               	  int max=maxTableSize;
  		               	  if(start<0) {
  		               		  max=maxTableSize+start;
  		               		  start=start-start;
  		               	  }
  		               	  resultList.setFirstResult(start);
  		               	  resultList.setMaxResults(max);
  		               	  List<Object[]> resultList3 = resultList.getResultList();
  		               	  request.setAttribute("members", resultList3);
  		               	  request.setAttribute("start", start);
  	                 }
  	        		 
  	        	 }

                //.....................................MANUFACTUERE ENDED............................................
  	        	 
  	        	 
                
  	        	 if(ValueTextBox.equals("Price"))
  	        	 {
  	        		 System.out.println("ENTERED PRICE");
  	        		  String max=request.getParameter("text2");
  	      	      	  String min=request.getParameter("text1");
  	      	      	  String parameter = request.getParameter("tableStart");
  	      	      	  System.out.println("start value from jsp for PRICE : "+start);
  	      	      	  start=Integer.parseInt(parameter);
  	      	      	  System.out.println("MAX VALUE IS : "+max+"\tMIN VALUE IS : "+min);
  	      	      	  int maxValue=Integer.parseInt(max);
  	      			  int minValue=Integer.parseInt(min);
  	      	     	  request.setAttribute("Max", max);
  	      	      	  request.setAttribute("Min", min);     			
  	      	     
  	      			Query createQuery = em.createQuery("select m.Name,m.Price from HclSkItems m WHERE m.Price BETWEEN ?0 AND ?1");
  	      			createQuery.setParameter(0, minValue);
  	      			createQuery.setParameter(1, maxValue);
  	      			List<Object[]> resultListPrice = createQuery.getResultList();
  	      			int priceSize = resultListPrice.size();
  	      			request.setAttribute("manufacturerSize", priceSize);
  	      		 
  	      			if(priceSize==maxTableSize)
       	    		{
       	    			String block="sufficient";
       	    			request.setAttribute("blockAll", block);
       	    		}
  	        		 
  	        		 if(pageButton.equals("First"))
  	                 {
  	        			 System.out.println("ENTERED PRICE FIRST");
  	        			 start=0;
  	    	      		 createQuery.setFirstResult(start);
  	    	      		 createQuery.setMaxResults(maxTableSize);
  	    	      		 List<Object[]> resultList = createQuery.getResultList();
  	    	      		  request.setAttribute("members", resultList);
  		               	  request.setAttribute("start", start);
  	        			 
  	        			 
  	                 }
  	        		 
  	        		 if(pageButton.equals("Next"))
  	                 {
  	        			 System.out.println("ENTERED PRICE NEXT");
  	        			 System.out.println("start value beore in PRICE NEXT");
  	        			 start=start+maxTableSize;
  	        			 createQuery.setFirstResult(start);
  	        			 createQuery.setMaxResults(maxTableSize);
  	        			 List<Object[]> resultList = createQuery.getResultList();
  	    	      		  request.setAttribute("members", resultList);

  	    	      		  request.setAttribute("start", start);
  	        			 
  	                 }
  	        		 
  	        		 if(pageButton.equals("Last"))
  	                 {
  		               	  System.out.println("entered into PRICE and LAST");
  	        			 start=priceSize-maxTableSize;
  	        			 createQuery.setFirstResult(start);
  	        			 createQuery.setMaxResults(maxTableSize);
  	        			 List<Object[]> resultList = createQuery.getResultList();
  	    	      		  request.setAttribute("members", resultList);

  	    	      		  request.setAttribute("start", start);
  	        			 
  	        			 
  	        			 
  	                 }
  	        		 if(pageButton.equals("Previous"))
  	                 {

  		               	  System.out.println("entered into PRICE and PREVIOUS");
  		               	 String tableStart = request.getParameter("tableStart");
  		               	  start=Integer.parseInt(tableStart);
  		               	  start=start-maxTableSize;
  		               	  System.out.println("the value of start inside MANUFACUTER and PREVIOUS : "+start);
  		               	  int max1=maxTableSize;
  		               	  if(start<0) {
  		               		  max1=maxTableSize+start;
  		               		  start=start-start;
  		               	  }
  		               	  createQuery.setFirstResult(start);
  		               	  createQuery.setMaxResults(max1);
  		               	  List<Object[]> resultList3 = createQuery.getResultList();
  		               	  request.setAttribute("members", resultList3);
  		               	  request.setAttribute("start", start);
  	                 }
  	        		 
  	        	 }
  	        	 
  	        	 
//  	        	 ......................................... ALL ...................................
                
  	        	 
                
  	        	 if(ValueTextBox.equals("All"))
  	        	 {
  	        		 
  	        	        Query resultList = em.createQuery("select m.Name,m.Price from HclSkItems m order by m.Id");
  	        	        List<Object[]> resultListAll = resultList.getResultList();
  	        	        int Allsize = resultListAll.size();
  	        	        request.setAttribute("manufacturerSize", Allsize);
  	        	      
  ;	        		  if(pageButton.equals("Next"))
  		                {
  		               	  String tableStart = request.getParameter("tableStart");
  		               	  start=Integer.parseInt(tableStart);
  		     	      		start=start+maxTableSize;
  		               	  System.out.println("entered into ALL and NEXT");
  		       	    		resultList.setFirstResult(start);
  		       	    		resultList.setMaxResults(maxTableSize);
  		       	    		List<Object[]> result = resultList.getResultList();
  		       	    		System.out.println("list of items are"+result);
  		       	    		request.setAttribute("members", result);
//  		       	      		start=start+maxTableSize;
  		       	      		request.setAttribute("start", start);
  		               	 
  		                 }
  		                 
  		                 else if(pageButton.equals("First"))
  		                 {
  		               	  start=0;
  		               	  System.out.println("entered into ALL and FIRST");
  		     	    		resultList.setFirstResult(start);
  		     	    		resultList.setMaxResults(maxTableSize);
  		     	    		List<Object[]> result = resultList.getResultList();
  		     	    		System.out.println("list of items are"+result);
  		     	    		request.setAttribute("members", result);
  		       	      		request.setAttribute("start", start);

  		               	  
  		                 }
  		                 
  		                 else if(pageButton.equals("Last"))
  		                 {
  		               	  System.out.println("entered into ALL and LAST");
  		       	    		request.setAttribute("category",categoryTextBox );
  		       	    		start=Allsize-maxTableSize;
  		       	    		resultList.setFirstResult(start);
  		       	    		resultList.setMaxResults(maxTableSize);
  		       	    		List resultList3 = resultList.getResultList();
  		       	    		request.setAttribute("members", resultList3);
  		       	    		request.setAttribute("start", start);
  		                 }
  		                
  		                 else if(pageButton.equals("Previous"))
  		                 {
  			               	  System.out.println("entered into ALL and PREVIOUS");
  			               	 String tableStart = request.getParameter("tableStart");
  			               	  start=Integer.parseInt(tableStart);
  			               	  start=start-maxTableSize;
  			               	  System.out.println("the value of start inside MANUFACUTER and PREVIOUS : "+start);
  			               	  int max=maxTableSize;
  			               	  if(start<0) {
  			               		  max=maxTableSize+start;
  			               		  start=start-start;
  			               	  }
  			               	  resultList.setFirstResult(start);
  			               	  resultList.setMaxResults(max);
  			               	  List<Object[]> resultList3 = resultList.getResultList();
  			               	  request.setAttribute("members", resultList3);
  			               	  request.setAttribute("start", start);
  		                 }

  	        		 
  	        	 }
                
                
                
                
                
                
                
                
                
                
            }
            else {
          	  
          	  if(rdButton!=null && rdButton.equals("List by Manufacturer"))
    	        {
    	        	String radioButtonValueTextBox="Manufacturer";
    	        request.setAttribute("radioButtonValueTextBox", radioButtonValueTextBox);
    	          System.out.println("Radio Button text Box Value "+radioButtonValueTextBox);
    	        	
    	      	  System.out.println("ENTERED LIST BY MANUFACTURER");
    	      	  String HQL="SELECT items.Name,items.Price FROM HclSkItems items,HclSkManufacturer man WHERE "
    	    				+ "items.Manufacturer_Id=man.Id AND man.name=:categoryUser";
    	    		Query resultList = em.createQuery(HQL);
    	    		resultList.setParameter("categoryUser", category);
    	    		resultList.setFirstResult(0);
    	    		resultList.setMaxResults(maxTableSize);
    	    		List<Object[]> resultListMan = resultList.getResultList();
    	    		
    	    		
    	    		Query createQuery = em.createQuery(HQL);
    	    		createQuery.setParameter("categoryUser", category);
    	    		List<Object[]> resultList3 = createQuery.getResultList();
    	    		int size = resultList3.size();
    	    		if(size<=maxTableSize)
    	    		{
    	    			String block="sufficient";
    	    			request.setAttribute("blockAll", block);
    	    		}
//    	    		resultList2 = resultList.getResultList();
  				/*
  				 * System.out.println("ENTERING FOR LOOP"); int i=0;
  				 * System.out.println("list of items are"+resultList); for (Object[] objects :
  				 * resultList2) { i++; System.out.println("ENTERED FOR LOOP"); String
  				 * employeeName=(String)objects[0]; Integer price=(Integer)objects[1]; //
  				 * Integer quantity=(Integer)objects[2]; // Integer payment=(Integer)objects[3];
  				 * System.out.println(employeeName+"\t      \t"+price); }
  				 */
    	    		
    	        	
    	
    	      	request.setAttribute("members", resultListMan);
    	        } 
    	        
    	        else if(rdButton!=null && rdButton.equals("All"))
    	        {
    	        	String radioButtonValueTextBox="All";
    	        	request.setAttribute("radioButtonValueTextBox", radioButtonValueTextBox);
    	          System.out.println("Radio Button text Box Value "+radioButtonValueTextBox);
    	      	  System.out.println("ENTERED All");
    	
    	  		  List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(maxTableSize);
    	            System.out.println("result::::"+listAllMembers);
    	            request.setAttribute("members", listAllMembers);
    	   
    	        }
    	        
    	        else if(rdButton!=null && rdButton.equals("List by Price"))
    	        {
    	        	String radioButtonValueTextBox="Price";
    	        request.setAttribute("radioButtonValueTextBox", radioButtonValueTextBox);
    	          System.out.println("Radio Button text Box Value "+radioButtonValueTextBox);
    	      	  System.out.println("ENTERED LIST BY PRICE");
    	      	  String Max=request.getParameter("text2");
    	      	  String Min=request.getParameter("text1");
    	      	  
    	      	  if(Max.equals("") || Min.equals(""))
    	      	  {
    	      		  System.out.println("THE VALUES ARE NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
    	      		  request.setAttribute("error", "Please enter min and max value");
    	      	  }
    	      	 
    	      	  else {
    	      		  
    	      		  int maxvalue=Integer.parseInt(Max);
      	      	  int minvalue=Integer.parseInt(Min);
      	      	  if(maxvalue<minvalue)
      	      	  {
      	      		  request.setAttribute("error", "Maximum Value is less than Minimum Value");  
      	      	  }
      	      	  else
      	      	  {

      	  	      	  request.setAttribute("Max", Max);
      	  	      	  request.setAttribute("Min", Min);
      	  	      	  System.out.println("Max Value : "+Max+"\n Min Value : "+Min);
      	  	      	  
      	  	      	  List<Object[]> listByPrice = memberResourceRESTService.listByPrice(Max,Min,maxTableSize);
      	  	      	  
      	  	      	int listByPriceFindSize = memberResourceRESTService.listByPriceFindSize(Max,Min,maxTableSize);
      	  	      	if(listByPriceFindSize<=maxTableSize)
      	  	      	{
      	  	      		String block="sufficient";
      	  	      		request.setAttribute("blockAll", block);
      	  	      	}
      	  	      	  
      	  	      	  request.setAttribute("members", listByPrice);
      	      		  
      	      	  }
    	      	  
    	      	  }
    	      	  
    	      	  
    	      	  
    	      	  
    	        }
//    	           RequestDispatcher requestDispatcher = request.getRequestDispatcher("BrowseItems.jsp");
//    	           requestDispatcher.forward(request, response);
    	//  			
          else
          {
        	System.out.println("CAME INTO ELSE STATEMETN"); 
        	List<HclSkManufacturer> manu1=memberResourceRESTService.listAllManufacuturer();
            System.out.println("Manufacturer List are : "+manu1);
            request.setAttribute("manu", manu1);
            String category1=request.getParameter("category");
            System.out.println("the category inside doGet() is :"+category1);
            request.setAttribute("category", category1);
            
            
            
    	  List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(maxTableSize);
          System.out.println("result::::"+listAllMembers);
          request.setAttribute("members", listAllMembers);
//    	  RequestDispatcher resultView =request.getRequestDispatcher("BrowseItems.jsp"); 
    	  
     
    //  request.setAttribute("infoMessage", " Welcome...!!!");
    	  System.out.println("Username :: at class level"+userName);
//    	  resultView.forward(request, response); 
    	  
          }

          	  
            }
  	        	        
  	        RequestDispatcher resultView =request.getRequestDispatcher("BrowseItems.jsp"); 
  	        resultView.forward(request, response); 	  
//        }
//        else {
//			request.setAttribute("commonMessage", "Please Login for Main Page");
//  	        RequestDispatcher resultView =request.getRequestDispatcher("Login.jsp"); 
//  	        resultView.forward(request, response); 	  
//        }

      
		}



}
