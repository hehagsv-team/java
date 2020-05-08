package org.hcl.shoppingKart;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Properties;
import java.io.IOException;
import java.util.ArrayList;

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
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.omg.PortableInterceptor.SUCCESSFUL;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;



//import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Tst {

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
	
	@InjectMocks
	OrderServlet order;
	
	@InjectMocks
	CartResourceRESTService service;
	
	String username="Gowthami";
	int maxTableSize=3;
	String pageButton=null;
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this); 	
    }
    
    @Test
    public void tst() throws ServletException, IOException {
    	when(request.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		List<Object[]> orderDetails =new ArrayList<Object[]>();
		when( service.listAllOrders("Gowthami",maxTableSize)).thenReturn(orderDetails);
		
		when(em.createQuery(anyString())).thenReturn(result);
		Mockito.doNothing().when(result.setParameter("Username", username));
		when(result.getResultList()).thenReturn(orderDetails);
	
    	OrderServlet order=new OrderServlet();
  
        order.doPost(request, response, em);
    

}
}
