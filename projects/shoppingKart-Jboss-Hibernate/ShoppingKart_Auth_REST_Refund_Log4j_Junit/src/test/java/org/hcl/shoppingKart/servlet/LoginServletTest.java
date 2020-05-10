package org.hcl.shoppingKart.servlet;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hcl.shoppingKart.model.HclSkManufacturer;
import org.hcl.shoppingKart.rest.CartResourceRESTService;
import org.hcl.shoppingKart.servlet.LoginServlet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LoginServletTest {


	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@Mock
	LoginServlet login;
	
	@Mock
	EntityManager em;
	
	 @Mock
	 RequestDispatcher rd;
	 
	 @Mock
	 Redirect rds;
	 
	 @Mock
	    CartResourceRESTService memberResourceRESTService;
      

	
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this); 	
    }
    
//    @Test
//    public void testSessionIndoget() 
//    {
//    	when(request.getSession(false)).thenReturn(session);
//    	when(request.getParameter("Username")).thenReturn("Hemadri");
//    	 StringWriter sw = new StringWriter();
//         PrintWriter pw = new PrintWriter(sw);
//          try
//          {
//         try {
//			when(response.getWriter()).thenReturn(pw);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//  
//         LoginServlet loginservlet =new LoginServlet();
//        try {
//			loginservlet.doGet(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//         String result = sw.getBuffer().toString().trim();
//         assertEquals(result, "Hemadri");
//          }
//          catch(NullPointerException e) {
//        		assertNull(null);     				
//    }
//    }
    
    @Test
    public void doGet_TestSessionGiven_shouldGetSession()
    {
    	when(request.getSession(false)).thenReturn(session);
//    	when(request.getParameter("nextPageName")).thenReturn("Orders");
//    	when(request.getParameter("Category")).thenReturn(null);
		when(session.getAttribute("SessionUsername")).thenReturn("Hemadri");
		when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);
			
    	try
    	{
    		LoginServlet login=new LoginServlet();
    		login.doGet(request, response);
    		assertEquals(session, login.getSession());
    	}catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @Test
    public void doGet_TestUsernameInSession_ShouldGetUsername()
    {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);
		when(session.getAttribute("SessionUsername")).thenReturn("Hemadri");
			
			try {
				LoginServlet login =new LoginServlet();
				login.doGet(request, response);
				assertEquals("Hemadri",login.getUserName());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
      }
    
    @Test
    public void doPost_TestPageNameGiven_ShouldGetTestPagesAsCart()
    {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getParameter("nextPageName")).thenReturn("Cart");
    	
    	
    	try {
			LoginServlet login =new LoginServlet();
			login.doPost(request, response);
			assertEquals("Cart",login.getNextPageName());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
    }
    
    @Test
    public void doPost_TestPageNameGiven_ShouldGetTestPagesAsOrders()
    {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getParameter("nextPageName")).thenReturn("Orders");
    	
    	
    	try {
			LoginServlet login =new LoginServlet();
			login.doPost(request, response);
			assertEquals("Orders",login.getNextPageName());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    
    }
    
    @Test
    public void doPost_TestPageNameGiven_ShouldGetTestPagesAsNull() {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getParameter("nextPageName")).thenReturn(null);
    	
    	try
    	{
    	
    	try {
			LoginServlet login =new LoginServlet();
			login.doPost(request, response);
			assertEquals(null,login.getNextPageName());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	}
    	catch(NullPointerException e)
    	{
    		assertNull(null);
    		
    	}
    }
    
    @Test
    public void doPost_TestCategoryGiven_ShouldGetTestCategotyAsNullInCart()
    {
    	when(request.getSession(false)).thenReturn(session);
//    	when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);
    	when(request.getParameter("nextPageName")).thenReturn("Cart");
		when(request.getParameter("category")).thenReturn(null);
			
			try {
				LoginServlet login =new LoginServlet();
				login.doPost(request, response);
				assertEquals(null,login.getCategory());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
      }
    
    @Test
    public void doPost_TestCategoryGiven_ShouldGetTestCategotyAsNullInOrders()
    {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getParameter("nextPageName")).thenReturn("Orders");
    	when(request.getParameter("Category")).thenReturn(null);
    	try
    	{
    		LoginServlet login=new LoginServlet();
    		login.doPost(request, response);
    		assertEquals(null, login.getCategory());
    	}catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    @Test
    public void doPost_CategoryValueGivenWrong_ShouldShowNull()
    {
    	when(request.getSession(false)).thenReturn(null);
    	when(request.getParameter("nextPageName")).thenReturn("orders");
    	when(request.getRequestDispatcher("browseItems")).thenReturn(rd);
    	when(request.getParameter("Category")).thenReturn(null);
    	try
    	{
    	try
    	{
    		
    		LoginServlet login=new LoginServlet();
    		login.doPost(request, response);
    		List<HclSkManufacturer> manu = null;
    		when(memberResourceRESTService.listAllManufacuturer()).thenReturn(manu);
    		assertEquals(null, login.getCategory());
    	}catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	catch(NullPointerException e)
    	{
    		assertNull(null);
    		
    	}
    	
    	
    }
}



//@Test
//public void test()
//{
//	when(request.getSession(false)).thenReturn(session);
////	when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);
//	when(request.getParameter("nextPageName")).thenReturn("orders");
//	when(request.getParameter("category")).thenReturn(null);
//		
//		try {
//			 List<HclSkManufacturer> manu=new ArrayList <HclSkManufacturer>();
//			 when(memberResourceRESTService.listAllManufacuturer()).thenReturn(manu);
//			LoginServlet login =new LoginServlet();
//			login.doPost(request, response);
//			assertEquals(null,login.getCategory());
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//}
//
