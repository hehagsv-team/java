package org.hcl.shoppingKart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;
import org.jboss.as.quickstarts.kitchensinkjsp.servlet.CartServlet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CartServletTest {
	
	@Mock
	HttpServletRequest req;
	
	@Mock
	HttpServletResponse res;
	
	@Mock
	HttpSession session;
	
	@Mock
	CartServlet cart;
	
	@Mock
	EntityManager em;
	
	@Mock
	CartResourceRESTService service;
	
	@Mock
	TypedQuery<Object> createQuery;
	
	@Mock
	CriteriaBuilder cri;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this); 
	}
	
	@Test
	 public void testUsernameInSession() {
    	when(req.getSession(false)).thenReturn(session);
		when(session.getAttribute("UsernameFilter")).thenReturn("Gowthami");
		try {
			
//			when(em.createQuery(Mockito.anyString())).thenReturn(createQuery);
//			List<Object> resultList=new ArrayList<Object>();
//			when(createQuery.getResultList()).thenReturn(resultList);
//			new CartServlet().doGet(request, response,em);
			CartServlet cs=new CartServlet();
			cs.doGet(req, res, em);
			assertEquals(cs.getUsername(),"Gowthami");
			

		} catch (ServletException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} catch (IOException e) {   
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
}
		
	
	


