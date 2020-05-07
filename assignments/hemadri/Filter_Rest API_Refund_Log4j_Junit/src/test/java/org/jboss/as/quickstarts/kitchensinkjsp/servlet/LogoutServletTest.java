package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LogoutServletTest 
{
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@Mock
	LogoutServlet logout;
	
	@Mock
	EntityManager em;
	
	 @Mock
	 RequestDispatcher rd;
	 
	
	
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this); 	
    }
    
    @Test
    public void testUserNameInsession()
    {
    	when(request.getSession(false)).thenReturn(session);
    	when(request.getRequestDispatcher("Login.jsp")).thenReturn(rd);
		when(session.getAttribute("SessionUsername")).thenReturn(null);
			
			try {
				LogoutServlet login =new LogoutServlet();
				logout.doPost(request, response);
				assertEquals(null,logout.getUsername());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
}
