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
package org.jboss.as.quickstarts.kitchensinkjsp.rest;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkItems;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto;
import org.jboss.as.quickstarts.kitchensinkjsp.model.UserAccount;

/**
 * JAX-RS Example
 *
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/members")
@RequestScoped
public class CartResourceRESTService {
    @Inject
    private EntityManager em;
    
    
    @Inject
    OrdersDetailsDto orderDetails;
    

    @GET
    @Produces("text/xml")
    public List<Object[]> listAllMembers(int maxTableSize) {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
        @SuppressWarnings("unchecked")
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
        Query itemResults = em.createQuery("select m.Name,m.Price from HclSkItems m order by m.Id");
        itemResults.setFirstResult(0);
        itemResults.setMaxResults(maxTableSize);
        List<Object[]> resultList = itemResults.getResultList();
        System.out.println("inside listallitems"+resultList);
        return resultList;
    }
    
    public List<UserAccount> listAllUsers() {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
        @SuppressWarnings("unchecked")
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
        final List<UserAccount> Userresults = em.createQuery("select m from UserAccount m order by m.name").getResultList();
        System.out.println("Result is" +Userresults);
        return Userresults;
    }
    
    public Boolean validuser(String name)
    {
    	try {
    		
    		System.out.println("before query :::: "+name);
    	Query query=em.createQuery("select m.name from UserAccount m where m.name = :name");
    	query.setParameter("name",name);
    	List results = query.getResultList();
    	System.out.println("Query has value ::: "+results);
//    	members=(List<UserAccount>) em.createQuery("select m.name from UserAccount m where m.name='" +Gowthami "'").getParameter(name);
    	if(results.isEmpty())
    		return false;
    	else 
    		return true;
    	}
    	catch(NoResultException e)
    	{
    		System.out.println("Exception :: "+e);
    		return false;
    	}
    }
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Member lookupMemberById(@PathParam("id") long id) {
        return em.find(Member.class, id);
    }

	public List<HclSkManufacturer> listAllManufacuturer() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
        final List<HclSkManufacturer> results = em.createQuery("select m from HclSkManufacturer m").getResultList();
		return results;
	}

	public List<Object[]> listByPrice(String max, String min, int maxTableSize) {
		// TODO Auto-generated method stub
		int maxValue=Integer.parseInt(max);
		int minValue=Integer.parseInt(min);
		
		
		Query createQuery = em.createQuery("select m.Name,m.Price from HclSkItems m WHERE m.Price BETWEEN ?0 AND ?1");
		createQuery.setParameter(0, minValue);
		createQuery.setParameter(1, maxValue);
		createQuery.setFirstResult(0);
		createQuery.setMaxResults(maxTableSize);
		List<Object[]> resultList = createQuery.getResultList();
		return resultList;
		
		
		
	}


	
	
	
	
	
	public int listByPriceFindSize(String max, String min, int maxTableSize) {
		// TODO Auto-generated method stub
		int maxValue=Integer.parseInt(max);
		int minValue=Integer.parseInt(min);
		
		
		Query createQuery = em.createQuery("select m.Name,m.Price from HclSkItems m WHERE m.Price BETWEEN ?0 AND ?1");
		createQuery.setParameter(0, minValue);
		createQuery.setParameter(1, maxValue);
		List<Object[]> resultList = createQuery.getResultList();
		int size=resultList.size();
		return size;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public List<Object[]> listAllOrders(String username,int maxTableSize) {
	    	
	        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
	        // this query
	    	System.out.println("Enterd into listAllMembers::Orders...::");
	        @SuppressWarnings("unchecked")
	        
//	        final List<OrdersDetailsDto> results =em.createQuery(" SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id IN (SELECT item_id FROM Orders O WHERE O.payment=1 AND O.Id IN (SELECT order_id FROM ShippingOrderEntity  S))").getResultList();               
	        		
//	        final OrdersDetailsDto results =(OrdersDetailsDto) em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1").getResultList();               

	        //        final List<OrdersDetailsDto> results = em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1").getResultList();               
//	        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
	        
	        Query result = em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username");
	        result.setParameter("Username", username);
//	        Query result = em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus 
//	        FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
	        result.setFirstResult(0);
	        result.setMaxResults(maxTableSize);
			List<Object[]> results=result.getResultList();  
//	        Iterator itr = results.iterator();
//	        Object[] obj;
//	        System.out.println("before while .... ");
//	        while(itr.hasNext()){
//	           obj = (Object[]) itr.next();
//	           System.out.println("Inside WHILE....");
//	           //now you have one array of Object for each row
//	           String Name = String.valueOf(obj[0]); 
//	           System.out.println("Name has ::: "+Name);
//	           Integer Price = Integer.parseInt(String.valueOf(obj[1]));
//	           System.out.println("Price has ::: "+Price);
//	           
//	           Integer quantity = Integer.parseInt(String.valueOf(obj[2]));
//	           System.out.println("Quantity ::: "+quantity);
//	           Integer Id = Integer.parseInt(String.valueOf(obj[3]));
//	           System.out.println("Order Id ::: "+Id);
//	           Date orderDate = Date.valueOf((String) obj[4]);
//	           System.out.println("Order Date ::: "+orderDate);
//	           Date deliverDate = Date.valueOf((String) obj[5]);
//	           System.out.println("Deliver Date ::: "+deliverDate);
//	           String shippingStatus = String.valueOf(obj[6]); 
//	           System.out.println("Shipping Status ::: "+shippingStatus);
//	           
//	           orderDetails.setName(Name);
//	           orderDetails.setPrice(Price);
//	           orderDetails.setQuantity(quantity);
//	           orderDetails.setOrder_Id(Id);
//	           orderDetails.setOrdered_Date(orderDate);
//	           orderDetails.setDeliver_Date(deliverDate);
//	           orderDetails.setShipping_Status(shippingStatus);
//	           
//	           //arrOrders.add(orderDetails);
//	           
//	           
//	           System.out.println(" OrderDetails has the date :: "+orderDetails.getName()+"\t"+orderDetails.getPrice()+"\t"+orderDetails.getQuantity()+"\t"+orderDetails.getOrder_Id()+"\t"+orderDetails.getOrdered_Date()+"\t"+orderDetails.getDeliver_Date()+"\t"+orderDetails.getShipping_Status());
	           
//	        }
			return results;
	 }
	    
	 
	 
	 
	 
	 public int listAllOrdersSize(String username,int maxTableSize) {
	    	
	        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
	        // this query
	    	System.out.println("Enterd into listAllMembers::Orders...::");
	        @SuppressWarnings("unchecked")
	       
	        Query result = em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username");
	        result.setParameter("Username", username);	
	        List<Object[]> results=result.getResultList();  

	        int size = results.size();
			return size;
	 }
 }
	 
