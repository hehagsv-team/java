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

import org.jboss.as.quickstarts.kitchensinkjsp.model.Item;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.UserAccount;

/**
 * JAX-RS Example
 *
 * This class produces a RESTful service to read the contents of the members table.
 */
@Path("/members")
@RequestScoped
public class MemberResourceRESTService {
    @Inject
    private EntityManager em;
    
    private List<Item> members;
    
    private Query createQuery;

    @SuppressWarnings("unchecked")
	@GET
    @Produces("text/xml")
    public List<Item> listAllMembers() {
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
       Query query= em.createQuery("select m from Item m order by m.itemId");
        query.setFirstResult(0);
        query.setMaxResults(2);
        members=query.getResultList();
        System.out.println("Order contain:::::"+members);
        
        return members;
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
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Item>listByPricerange(int max, int min)
    {
    	Query query=em.createQuery("select m from Item m where m.price >=:mini and m.price <=:maxi");
    	query.setParameter("maxi",Long.valueOf(max));
    	query.setParameter("mini", Long.valueOf(min));
    	List priceresult=query.getResultList();
    	System.out.println("Query has value:::"+priceresult);
    	return priceresult;
    }
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public Member lookupMemberById(@PathParam("id") long id) {
        return em.find(Member.class, id);
    }
}
