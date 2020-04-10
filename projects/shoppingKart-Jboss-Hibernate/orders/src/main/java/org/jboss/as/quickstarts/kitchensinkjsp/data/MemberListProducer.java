/*
 * JBoss, Home of Professional Open Source
 * Copyright p015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version p.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-p.0
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
	    
	    int count,inc,p=2;
//	    String navButton;
	    
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
//	    	retrieveAllMembersOrderedByName();
////	        doPost(request, response);
	    }

	    @SuppressWarnings("unchecked")
	   
		public Integer retrieveAllMembersOrderedByName(String navButton,Integer inc) {
    		Query q =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
    		count=q.getResultList().size();
//     		System.out.println("count has value:: "+count);
    		this.inc=inc;
    		if(q.getResultList().isEmpty()) {
    			inc=-1;
    			return inc;
    		}
    		else {
//     			System.out.println("Inside query:::: ");
//     	    	System.out.println("Navigation Button has value in ListProducer ::: "+navButton);
    	    	if(navButton.equals("first")) {
//     	    		System.out.println("value of inc in first : "+inc);
    	    		inc=0;
//     	    		System.out.println("value of inc : "+inc);
    	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
    		    	query.setFirstResult(0);
    			    query.setMaxResults(p);
    			    members=query.getResultList();
    			    
//    			    inc=inc+p;
//    			    servlet.listAllOrders(members);
    			    System.out.println("Order contains in first ::: "+inc+"\t"+members);
    	    	}
    	    	else if(navButton.equals("last")) {
//     	    		System.out.println("value of inc in last : "+inc);
    	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
    		    	query.setFirstResult(count-p);
    			    query.setMaxResults(p);
    			    members=query.getResultList();
//    			    servlet.listAllOrders(members);
    			    inc=count-p;
//     			    System.out.println("value of inc : "+inc +"\t"+count);
//     			    System.out.println("Order contains in last ::: "+inc+"\t"+members);
    	    	}
    	    	else if(navButton.equals("next")) {
//     	    		System.out.println("value of inc in next : "+inc);
    	    		inc=inc+p;
//     	    		System.out.println("value of inc : "+inc);
    	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
    		    	query.setFirstResult(inc);
    			    query.setMaxResults(p);
    			    members=query.getResultList();
//    			    inc=inc+p;
//    			    servlet.listAllOrders(members);
//     			    System.out.println("Order contains in next ::: "+inc+"\t"+members);
    	    	}
    	    	else if(navButton.equals("previous")) {
//     	    		System.out.println("value of inc in previous : "+inc);
    	    		inc=inc-p;
//     	    		System.out.println("value of inc : "+inc);
    	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
    		    	query.setFirstResult(inc);
    			    query.setMaxResults(p);
    			    members=query.getResultList();
//    			    servlet.listAllOrders(members);
//     			    System.out.println("Order contains in previous ::: "+inc+"\t"+members);
    	    	}
//         		System.out.println("Final value of inc in if :"+inc);
        		return inc;

    		}
    		
	    	
	    }
}

