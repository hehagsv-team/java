package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.awt.List;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.as.quickstarts.kitchensinkjsp.controller.LoginUser;
import org.jboss.as.quickstarts.kitchensinkjsp.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensinkjsp.data.MemberListProducer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MemberRegistrationServletTest
{
    
	@Mock
	HttpServletRequest request;
	
	@Mock
	HttpServletResponse response;
	
	@Mock
	HttpSession session;
	
	@Mock
	MemberRegistrationServlet memberRegistrationServlet;
	
	 @Mock
	    MemberRegistration registrationService;

	    
	    @Mock
	    LoginUser registrationServices;

	    
	    @Mock
	    CartResourceRESTService memberResourceRESTService;
	    
	    @Mock
	    MemberListProducer memberListService;
	    
	
	@Mock
	EntityManager em;
	
	 @Mock
	 RequestDispatcher rd;
	 
	 @Mock
	 Redirect rds;
      

	
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this); 	
    }
    
 
	@Test
    public void testUsernameInsession()
    {
 	when(request.getSession(false)).thenReturn(session);
//    	when(request.getRequestDispatcher("BrowseItems.jsp")).thenReturn(rd);
		when(request.getParameter("category")).thenReturn("LG");
			
			try {
				MemberRegistrationServlet member =new MemberRegistrationServlet();
				member.doGet(request, response);
				assertEquals("LG",member.getCategory());
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
      }
    
	
	
	
	

}
