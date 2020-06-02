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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Request;

import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Items;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.Items_;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetails;
import org.jboss.as.quickstarts.kitchensinkjsp.model.ShippingOrderEntity;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.ShippingOrderEntity_;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Member;
import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders_;

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
    
    @Inject
    OrdersDetailsDto orderDetails;


	
    
    
    
    
    
    
    @GET
    @Path("/register.do")
    @Produces("text/xml")
    public OrdersDetailsDto listAllMembers() {
    	
        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
        // this query
    	System.out.println("Enterd into listAllMembers::::");
        @SuppressWarnings("unchecked")
        
//        final List<OrdersDetailsDto> results =em.createQuery(" SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id IN (SELECT item_id FROM Orders O WHERE O.payment=1 AND O.Id IN (SELECT order_id FROM ShippingOrderEntity  S))").getResultList();               
        		
//        final OrdersDetailsDto results =(OrdersDetailsDto) em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1").getResultList();               

        //        final List<OrdersDetailsDto> results = em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1").getResultList();               
//        ArrayList<OrdersDetailsDto> arrOrders=new ArrayList<OrdersDetailsDto>();
        
        Query result = em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");

//        Query result = em.createQuery("SELECT I.Name,I.Price,S.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM Items I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1");
        @SuppressWarnings("unchecked")
		List<Object[]> results=result.getResultList();  
        Iterator itr = results.iterator();
        Object[] obj;
        System.out.println("before while .... ");
        while(itr.hasNext()){
           obj = (Object[]) itr.next();
           System.out.println("Inside WHILE....");
           //now you have one array of Object for each row
           String Name = String.valueOf(obj[0]); 
           System.out.println("Name has ::: "+Name);
           Integer Price = Integer.parseInt(String.valueOf(obj[1]));
           System.out.println("Price has ::: "+Price);
           
           Integer quantity = Integer.parseInt(String.valueOf(obj[2]));
           System.out.println("Quantity ::: "+quantity);
           Integer Id = Integer.parseInt(String.valueOf(obj[3]));
           System.out.println("Order Id ::: "+Id);
           Date orderDate = Date.valueOf((String) obj[4]);
           System.out.println("Order Date ::: "+orderDate);
           Date deliverDate = Date.valueOf((String) obj[5]);
           System.out.println("Deliver Date ::: "+deliverDate);
           String shippingStatus = String.valueOf(obj[6]); 
           System.out.println("Shipping Status ::: "+shippingStatus);
           
           orderDetails.setName(Name);
           orderDetails.setPrice(Price);
           orderDetails.setQuantity(quantity);
           orderDetails.setOrder_Id(Id);
           orderDetails.setOrdered_Date(orderDate);
           orderDetails.setDeliver_Date(deliverDate);
           orderDetails.setShipping_Status(shippingStatus);
           
           //arrOrders.add(orderDetails);
           
           
//           orderDetails.add(arrOrders);
           System.out.println(" OrderDetails has the date :: "+orderDetails.getName()+"\t"+orderDetails.getPrice()+"\t"+orderDetails.getQuantity()+"\t"+orderDetails.getOrder_Id()+"\t"+orderDetails.getOrdered_Date()+"\t"+orderDetails.getDeliver_Date()+"\t"+orderDetails.getShipping_Status());
           
        }
		return orderDetails;
        
        
      
        
        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
        // the @Entity class
        // as described in the named query blueprint:
        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
//        final List<OrdersDetails> results = em.createQuery("select m from OrdersDetails m").getResultList();
//		 final List<OrdersDetailsDto> results = em.createQuery("select new org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto(i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus) from  Orders o JOIN o.items i JOIN o.shipping s where o.payment=1").getResultList();
		 
//        final List<OrdersDetailsDto> results = em.createQuery("select i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus from  Orders o JOIN o.items i JOIN o.shipping s where o.payment=1").getResultList();
		
//        final List<OrdersDetailsDto> results = em.createNativeQuery("select new org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto(i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus) from  Items i JOIN Orders o ON i.Id=o.item_id JOIN ShippingOrderEntity s join o.Id=s.order_id where o.payment=1",OrdersDetailsDto.class).getResultList();

//        CriteriaQuery<Items> query = em.createQuery(Items.class);
//        Root<Items> fromItems = query.from(Items.class);
//        Join<Items, Order> joinOrder = fromItems.join("book");
//        Join<Order, ShippingOrderEntity> joinShipping = details.join("organization");
//       
//        List<Predicate> conditions = new ArrayList();
//        conditions.add(builder.equal(joinShipping.get("name"), "XYZ"));
        

     // Create query
//     CriteriaBuilder cb = em.getCriteriaBuilder();
//     CriteriaQuery<OrdersDetailsDto> cq = cb
//             .createQuery(OrdersDetailsDto.class);
//     		
////     Root<Items> root = cq.from(Items.class);	
////   Join<Items, Orders> order = root.join(Items_.order);
////   Join<Orders, ShippingOrderEntity> shipping = order.join(Orders_.shipping);
//
//     
//     Root<ShippingOrderEntity> root=cq.from(ShippingOrderEntity.class);
//   
//     Join<ShippingOrderEntity,Orders> order = root.join(ShippingOrderEntity_.order);
//     Join<Orders,Items> item = order.join(Orders_.items);
//      
//     // Define DTO projection
////     cq.select(cb.construct(
////             OrdersDetailsDto.class,
////             root.get(Items_.Name),
////             root.get(Items_.Price),
////     		 shipping.get(ShippingOrderEntity_.quantity),
////             order.get(Orders_.Id),
////     		 order.get(Orders_.orderDate),
////     		 shipping.get(ShippingOrderEntity_.deliverDate),
////     		shipping.get(ShippingOrderEntity_.shippingStatus)));
//          
//     cq.select(cb.construct(
//             OrdersDetailsDto.class,
//             item.get(Items_.Name),
//             item.get(Items_.Price),
//     		 root.get(ShippingOrderEntity_.quantity),
//             order.get(Orders_.Id),
//     		 order.get(Orders_.orderDate),
//     		 root.get(ShippingOrderEntity_.deliverDate),
//     		root.get(ShippingOrderEntity_.shippingStatus)));
//             
//     
//     
//     // Define WHERE clause
////     ParameterExpression<Integer> paramTitle = cb.parameter(Integer.class);
//     cq.where(cb.gt(order.get(Orders_.payment),0));
//      
//     // Execute query
//     TypedQuery<OrdersDetailsDto> q = em.createQuery(cq);
//     //q.setParameter(paramTitle, "%Hibernate Tips%");
////     List<OrdersDetailsDto> results = q.getResultList();
//        
      // return results;
  }
    
    

    @POST
    @Path("/manufacturer")
    @Produces("text/xml")
	public List<HclSkManufacturer> listAllManufacuturer() {
    	
    	@SuppressWarnings("unchecked")
        final List<HclSkManufacturer> results = em.createQuery("select m from HclSkManufacturer m").getResultList();
		return results;
	}



//    @POST
//    @Path("/BrowseItems")
//    @Produces("text/xml")
//	public List<Items> listManuItems(String category) {
//    	
//    	@SuppressWarnings("unchecked")
//        final List<Items> results = em.createQuery("select i.Id,i.Name,i.Price,i.Manufacturer_Id FROM Items i JOIN HclSkManufacturer m on m.Id = i.Manufacturer_Id where m.name = :name").getResultList();
//        ((Query) results).setParameter("name",category);
//		return results;
//	}
    
//    select RowNum,i.item_id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1"
    
    
//    public List<OrdersDetailsDto> listAllMembers() {
//        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
//        // this query
//        @SuppressWarnings("unchecked")
//        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
//        // the @Entity class
//        // as described in the named query blueprint:
//        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
////        final List<OrdersDetails> results = em.createQuery("select m from OrdersDetails m").getResultList();
//		 final List<OrdersDetailsDto> results = em.createQuery("select new org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetailsDto(i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus) from  Orders o JOIN o.items i JOIN o.shipping s where o.payment=1").getResultList();
////		 final List<OrdersDetailsDto> results = em.createQuery("select i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus from  Orders o JOIN o.items i JOIN o.shipping s where o.payment=1").getResultList();
//
//        return results;
//  }
    
    
//    public List<Orders> listAllMembers() {
//        // Use @SupressWarnings to force IDE to ignore warnings about "genericizing" the results of
//        // this query
//        @SuppressWarnings("unchecked")
//        // We recommend centralizing inline queries such as this one into @NamedQuery annotations on
//        // the @Entity class
//        // as described in the named query blueprint:
//        // https://blueprints.dev.java.net/bpcatalog/ee5/persistence/namedquery.html
////        final List<Items> results = em.createQuery("select m from Items m order by m.Id").getResultList();
//		 final List<Orders> results = em.createQuery("select i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus from  Items i JOIN i.orders o JOIN o.shipping s where o.payment=1").getResultList();
////		 final List<OrdersDetailsDto> results = em.createQuery("select i.Name,i.Price,s.quantity,o.Id,o.orderDate,s.deliverDate,s.shippingStatus from  Orders o JOIN o.items i JOIN o.shipping s where o.payment=1").getResultList();
//
//        return results;
//    }
	/*
	 * @GET
	 * 
	 * @Path("/{id:[0-9][0-9]*}")
	 * 
	 * @Produces("text/xml") public Member lookupMemberById(@PathParam("id") long
	 * id) { return em.find(Member.class, id); }
	 */



}
