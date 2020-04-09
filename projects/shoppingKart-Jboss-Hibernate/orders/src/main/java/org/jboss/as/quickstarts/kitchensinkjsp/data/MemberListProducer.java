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
package org.jboss.as.quickstarts.kitchensinkjsp.data;

import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto;
import org.jboss.as.quickstarts.kitchensinkjsp.servlet.MemberRegistrationServlet;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.enterprise.context.Dependent;

//@RequestScoped
//public class MemberListProducer {
//    @Inject
//    private EntityManager em;
//
//    private List<Member> members;
//
//    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
//    // Facelets or JSP view)
//    @Produces
//    @Named
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Member member) {
//        retrieveAllMembersOrderedByName();
//    }
//
//    @PostConstruct
//    public void retrieveAllMembersOrderedByName() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
//        Root<Member> member = criteria.from(Member.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
//        criteria.select(member).orderBy(cb.asc(member.get("name")));
//        members = em.createQuery(criteria).getResultList();
//    }
//}

@RequestScoped
public class MemberListProducer{
	
		@Inject
		private EntityManager em;
	
		@Inject
		MemberRegistrationServlet servlet;
		
	    @Inject
	    private OrdersDetailsDto orders;

	    private List<OrdersDetailsDto> members;

	    private Query createQuery;
	    
	    int count=8,inc=0;
	    String navButton;
	    
	    @Produces
	    @Named
	    public List<OrdersDetailsDto> getMembers() {
	        return members;
	    }
	  
	    
		public void onMemberListChanged()  {
////	    	System.out.println("servlet navButton has value  :: "+navButton);
////	    	navButton=request.getParameter("navButton");
////	    	this.navButton=navButton;
////	    	this.inc=request.getIntHeader("inc");
////	    	request.setAttribute("inc", inc);
////	    	request.setAttribute("navButton", navButton);
	    	retrieveAllMembersOrderedByName();
////	        doPost(request, response);
	    }

	    @SuppressWarnings("unchecked")
	    @PostConstruct
		private void retrieveAllMembersOrderedByName() {
			
	   
	    	System.out.println("Inside query:::: ");
	    	System.out.println("Navigation Button has value ::: "+navButton);
	    	Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//	    	query.setFirstResult(0);
//		    query.setMaxResults(2);
		    members=query.getResultList();
		    System.out.println("Order contains in ListProducer ::: "+members);
//		    servlet.listAllOrders(members);
//	    	if(navButton.equals("first")) {
////	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(0);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("last")) {
////	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(count-2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("next")) {
////	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(inc+2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    inc=inc+2;
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("previous")) {
////	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(inc-2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    inc=inc-2;
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	
//	    	
	    	
	    	
	    	
	    	
	    	
//	    	for(int i=0;i<8;i++) {
//	    		if(inc==0 ) {
//	    			query.setFirstResult(0);
//	    		    query.setMaxResults(2);
//	    		    members=query.getResultList();
//	    		    System.out.println("Order contains ::: "+members);
//	    		    inc=0;
////	    		    inc=inc+2;
//	    		}
//	    		else if(inc>=2 && inc <=4) {
//	    			query.setFirstResult(2);
//	    		    query.setMaxResults(2);
//	    		    members=query.getResultList();
//	    		    System.out.println("Order contains ::: "+members);
////	    		    inc=inc+2;
//	    		}
//	    		else if(inc >4 && inc <=6 ) {
//	    			query.setFirstResult(4);
//	    		    query.setMaxResults(2);
//	    		    members=query.getResultList();
//	    		    System.out.println("Order contains ::: "+members);
////	    		    inc=inc+2;
//	    		}
//	    		else if(inc >6 && inc <=8) {
//	    			query.setFirstResult(6);
//	    		    query.setMaxResults(2);
//	    		    members=query.getResultList();
//	    		    System.out.println("Order contains ::: "+members);
////	    		    inc=inc+2;
//	    		}
	    	}
	    }	
	    	
	    	
		
//	    @SuppressWarnings("unchecked")
//	    
//		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    	String navButton=request.getParameter("navButton");
//	    	System.out.println("navButton has values :: "+navButton);
//	    	if(navButton.equals("first")) {
//	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(0);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("last")) {
//	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(count-2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("next")) {
//	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(inc+2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    inc=inc+2;
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    	else if(navButton.equals("previous")) {
//	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
//		    	query.setFirstResult(inc-2);
//			    query.setMaxResults(2);
//			    members=query.getResultList();
//			    inc=inc-2;
//			    System.out.println("Order contains ::: "+members);
//	    	}
//	    }
	    
//}
