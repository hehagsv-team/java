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
package org.hcl.shoppingKart.data;

import org.apache.log4j.Logger;
import org.hcl.shoppingKart.model.Item;
import org.hcl.shoppingKart.model.OrdersDetailsDto;

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

@RequestScoped
public class MemberListProducer {
	
	static Logger logger = Logger.getLogger(MemberListProducer.class);
	
    @Inject
    private EntityManager em;

    private Query createQuery;
    
    int count,inc,p=2;
//    private List<Item> members;
    
    private List<OrdersDetailsDto> members;

    // @Named provides access the return value via the EL variable name "members" in the UI (e.g.,
    // Facelets or JSP view)
//    @Produces
//    @Named
//    public List<Item> getMembers() {
//        return members;
//    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Item member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Member> criteria = cb.createQuery(Member.class);
//        Root<Member> member = criteria.from(Member.class);
//        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
//        // feature in JPA 2.0
//        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
//        criteria.select(member).orderBy(cb.asc(member.get("name")));
//        members = em.createQuery("select m from Item m order by m.itemId").getResultList();
    }
    
    
    
	public Integer retrieveAllMembersOrderedByName(String navButton,Integer inc, String username) {
		Query q =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName = :name");
		q.setParameter("name", username);
		count=q.getResultList().size();
		logger.info("count has value:: "+count);
		this.inc=inc;
		if(q.getResultList().isEmpty()) {
			inc=-1;
			return inc;
		}
		else {
			logger.info("Inside query:::: ");
	    	logger.debug("Navigation Button has value in ListProducer ::: "+navButton);
	    	if(navButton.equals("first")) {
	    		logger.debug("value of inc in first : "+inc);
	    		inc=0;
	    		logger.info("value of inc : "+inc);
	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName = :name");
	    		query.setParameter("name", username);
	    		query.setFirstResult(0);
			    query.setMaxResults(p);
			    members=query.getResultList();
			    
//			    inc=inc+p;
//			    servlet.listAllOrders(members);
			    logger.debug("Order contains in first ::: "+inc+"\t"+members);
	    	}
	    	else if(navButton.equals("last")) {
	    		logger.debug("value of inc in last : "+inc);
	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName = :name");
	    		query.setParameter("name", username);
	    		query.setFirstResult(count-p);
			    query.setMaxResults(p);
			    members=query.getResultList();
//			    servlet.listAllOrders(members);
			    inc=count-p;
			  logger.debug("value of inc : "+inc +"\t"+count);
			    logger.debug("Order contains in last ::: "+inc+"\t"+members);
	    	}
	    	else if(navButton.equals("next")) {
	    		logger.debug("value of inc in next : "+inc);
	    		inc=inc+p;
	    		logger.debug("value of inc : "+inc);
	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName = :name");
	    		query.setParameter("name", username);
	    		query.setFirstResult(inc);
			    query.setMaxResults(p);
			    members=query.getResultList();
			    
//			    inc=inc+p;
//			    servlet.listAllOrders(members);
			    logger.info("Order contains in next ::: "+inc+"\t"+members);
	    	}
	    	else if(navButton.equals("previous")) {
	    		logger.debug("value of inc in previous : "+inc);
	    		inc=inc-p;
	    		logger.debug("value of inc : "+inc);
	    		Query query =em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName = :name");
	    		query.setParameter("name", username);
	    		query.setFirstResult(inc);
			    query.setMaxResults(p);
			    members=query.getResultList();
			   
//			    servlet.listAllOrders(members);
			    logger.info("Order contains in previous ::: "+inc+"\t"+members);
	    	}
    		logger.info("Final value of inc :"+inc);
    		return inc;

		}
		
    	
    }
    
    
    
    
}
