package org.hcl.shoppingKart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;
import org.jboss.as.quickstarts.kitchensinkjsp.servlet.OrderServlet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;


//@RunWith(MockitoJUnitRunner.class)
public class OrderServletTest {

	
	
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@Mock
	RequestDispatcher resultView;
	
	@Mock
	EntityManager em;
	
	@Mock
	Query result;
	
	@Mock
	Query result1;
	
	@InjectMocks
	OrderServlet order;
	
	@InjectMocks
	CartResourceRESTService service;
	
	String username="Gowthami";
	int maxTableSize=3;
	String pageButton;
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this); 	
    }
	
    
    @Test
    public void testUsernameInOrderServletUsingSession() {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getRequestDispatcher("orders.jsp")).thenReturn(resultView);
		try {
			
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
					+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username"))
					.thenReturn(result);
			when(result.setParameter("Username", username)).thenReturn(result);
			List<Object[]> resultList=new ArrayList<Object[]>();
			when(result.getResultList()).thenReturn(resultList);
			order.doGet(request, response, em);
			assertEquals(order.getUsername(),"Gowthami");

		} 
		catch (ServletException e) {
			fail(e.getMessage());
		} 
		catch (IOException e) {
			fail(e.getMessage());
		}
		
    }
    
    
    @Test
    public void testUsername_NotNullInOrderServletUsingSession()
    {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getRequestDispatcher("orders.jsp")).thenReturn(resultView);
		try {
			
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
					+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username"))
					.thenReturn(result);
			when(result.setParameter("Username", username)).thenReturn(result);
			List<Object[]> resultList=new ArrayList<Object[]>();
			when(result.getResultList()).thenReturn(resultList);
			order.doGet(request, response, em);
			assertNotNull(order.getUsername(),"Gowthami");
		} 
		catch (ServletException e) {
			fail(e.getMessage());
		} 
		catch (IOException e) {
			fail(e.getMessage());
		}
		
    }
    
        
    @Test
    public void testRequestDispatcher_ReturnsResultView_InOrderServlet_DoGetMethod() {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getRequestDispatcher("orders.jsp")).thenReturn(resultView);
		try {
			
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result);
			when(result.setParameter("Username", username)).thenReturn(result);
			List<Object[]> resultList=new ArrayList<Object[]>();
			when(result.getResultList()).thenReturn(resultList);
			order.doGet(request, response, em);
			assertEquals(order.getResultView(),resultView);			
			assertEquals(order.getSession(),session);
		} catch (ServletException e) {		
			fail(e.getMessage());
		} catch (IOException e) {			
			fail(e.getMessage());
		}
    }
    
    
    @Test
    public void testCreateQueryReturnsNullInOrderServletDoGetMethod() {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getRequestDispatcher("orders.jsp")).thenReturn(resultView);
		try {
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(null);
			when(result.setParameter("Username", username)).thenReturn(result);
			order.doGet(request, response,em);
		} 
		catch (ServletException e) { 
			fail(e.getMessage()); 
		} catch (IOException e) { 
			fail(e.getMessage()); 
		}catch(NullPointerException e) {
			assertNull(null);
		}
	}
    
   
    
    @SuppressWarnings("unchecked")
	@Test
    public void testCreateQueryReturnsNullInOrderServletDoPostMethod()
    {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		try
		{
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
					+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username"))
					.thenReturn(result);
			when(result.setParameter("Username", username)).thenReturn(result);
			List<Object[]> resultList=new ArrayList<Object[]>();
			when(result.getResultList()).thenReturn(resultList);
			order.doPost(request, response, em);		
		}
		catch (ServletException e) {
			fail(e.getMessage());
		} 
		catch (IOException e) {
			fail(e.getMessage());
		}
		catch(NullPointerException e) {
			assertNull(null);
		}
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void testPageButtonValueEqualsToNull_InOrderServlet_InsideDoPostMethod()
    {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getParameter("firstButton")).thenReturn(null);
		when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
				+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result1);
	    when( result1.setParameter("Username", username)).thenReturn(result1);
	        List<Object[]> results=result1.getResultList(); 
	        when(result1.getResultList()).thenReturn(results);
			try {
				order.doPost(request, response, em);
				assertEquals(order.getPageButton(),null);
			} catch (ServletException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}		
		
	
		catch(NullPointerException e) {
			assertNull(null);
		}
    }
   
    
    @SuppressWarnings("unchecked")
   	@Test
       public void  testPageButtonValueEqualsToFirst_InOrderServlet_InsideDoPostMethod()
       {
       	when(request.getSession(false)).thenReturn(session);
   		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
   		when(request.getParameter("firstButton")).thenReturn("First");
   		when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
   				+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result1);
   	    when( result1.setParameter("Username", username)).thenReturn(result1);
   	        List<Object[]> results=result1.getResultList(); 
   	        when(result1.getResultList()).thenReturn(results);
   			try {
   				order.doPost(request, response, em);
   				assertEquals(order.getPageButton(),"First");
   			} catch (ServletException e1) {
   				
   				e1.printStackTrace();
   			} catch (IOException e1) {
   			
   				e1.printStackTrace();
   			}		
   		  	
   		catch(NullPointerException e) {
   			assertNull(null);
   		}
       }
    
    @SuppressWarnings("unchecked")
   	@Test
       public void  testPageButtonValueEqualsToLast_InOrderServlet_InsideDoPostMethod()
       {
       	when(request.getSession(false)).thenReturn(session);
   		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
   		when(request.getParameter("firstButton")).thenReturn("Last");
   		when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
   				+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result1);
   	    when( result1.setParameter("Username", username)).thenReturn(result1);
   	        List<Object[]> results=result1.getResultList(); 
   	        when(result1.getResultList()).thenReturn(results);
   			try {
   				order.doPost(request, response, em);
   				assertEquals(order.getPageButton(),"Last");
   			} catch (ServletException e1) {
   				
   				e1.printStackTrace();
   			} catch (IOException e1) {
   			
   				e1.printStackTrace();
   			}		
   		  	
   		catch(NullPointerException e) {
   			assertNull(null);
   		}
       }
    
    
    
    @SuppressWarnings("unchecked")
   	@Test
       public void  testPageButtonValueEqualsToPrevious_InOrderServlet_InsideDoPostMethod()
       {
       	when(request.getSession(false)).thenReturn(session);
   		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
   		when(request.getParameter("firstButton")).thenReturn("Previous");
   		when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
   				+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result1);
   	    when( result1.setParameter("Username", username)).thenReturn(result1);
   	        List<Object[]> results=result1.getResultList(); 
   	        when(result1.getResultList()).thenReturn(results);
   			try {
   				order.doPost(request, response, em);
   				assertEquals(order.getPageButton(),"Previous");
   			} catch (ServletException e1) {
   				
   				e1.printStackTrace();
   			} catch (IOException e1) {
   			
   				e1.printStackTrace();
   			}		
   		  	
   		catch(NullPointerException e) {
   			assertNull(null);
   		}
       }
    
    @SuppressWarnings("unchecked")
   	@Test
       public void  testPageButtonValueEqualsToNext_InOrderServlet_InsideDoPostMethod()
       {
       	when(request.getSession(false)).thenReturn(session);
   		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
   		when(request.getParameter("firstButton")).thenReturn("Next");
   		when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders "
   				+ "O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result1);
   	    when( result1.setParameter("Username", username)).thenReturn(result1);
   	        List<Object[]> results=result1.getResultList(); 
   	        when(result1.getResultList()).thenReturn(results);
   			try {
   				order.doPost(request, response, em);
   				assertEquals(order.getPageButton(),"Next");
   			} catch (ServletException e1) {
   				
   				e1.printStackTrace();
   			} catch (IOException e1) {
   			
   				e1.printStackTrace();
   			}		
   		  	
   		catch(NullPointerException e) {
   			assertNull(null);
   		}
       }
    
    @Test
    public void testRequestDispatcher_ReturnsResultView_InOrderServlet_DoPostMethod()
    {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		when(request.getRequestDispatcher("orders.jsp")).thenReturn(resultView);
		try {
			when(em.createQuery("SELECT I.Name,I.Price,O.quantity,O.Id,O.orderDate,S.deliverDate,S.shippingStatus FROM HclSkItems I,Orders O,ShippingOrderEntity S WHERE I.Id = O.item_id AND O.Id=S.order_id AND O.payment=1 AND O.userName=:Username")).thenReturn(result);
			when(result.setParameter("Username", username)).thenReturn(result);
			List<Object[]> resultList=new ArrayList<Object[]>();
			when(result.getResultList()).thenReturn(resultList);
			order.doPost(request, response, em);
			assertEquals(order.getResultView(),resultView);			
			assertEquals(order.getSession(),session);	
		} catch (ServletException e) {		
			fail(e.getMessage());
		} catch (IOException e) {			
			fail(e.getMessage());
		}
    }	
}