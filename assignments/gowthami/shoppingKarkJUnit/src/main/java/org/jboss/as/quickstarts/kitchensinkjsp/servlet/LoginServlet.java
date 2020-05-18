package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.as.quickstarts.kitchensinkjsp.controller.LoginUser;
import org.jboss.as.quickstarts.kitchensinkjsp.controller.MemberRegistration;
import org.jboss.as.quickstarts.kitchensinkjsp.data.MemberListProducer;
import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	 @Inject
	    private EntityManager em;

	    @Inject
	    MemberRegistration registrationService;
	    
	    @Inject
	    LoginUser registrationServices;

	    
	    @Inject
	    CartResourceRESTService memberResourceRESTService;
	    
	    @Inject
	    MemberListProducer memberListService;

	    String userName;
	
	
	
	
	
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("entered LoginServlet doget () method");
		
		  HttpSession session=request.getSession(false);  

	        String username=(String)session.getAttribute("SessionUsername");
	        System.out.println("username in CartServlet SESSION is : "+username);
          session.invalidate();  
          System.out.println("after clearing sessio ....sending control to Login .jsp");
  		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
  		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        StringBuilder errorMessage = new StringBuilder();
        System.out.println("Control enters into dopost() of LoginSErvlet");
		String userName=request.getParameter("name");
		System.out.println("the value of username from loginservlet in dopost of loginservlet is : "+userName);
//	        request.setAttribute("name", userName);
	       System.out.println("checking session..................");

	       		User cart=new User();
		        int start=0;
		        request.setAttribute("start", start);
		        request.setAttribute("radioButtonValueTextBox", "All");
		        System.out.println("the name send to cartServlet : "+userName);
		        String nextPageName = request.getParameter("nextPageName");
				  System.out.println("next page value in LoginServlet : "+nextPageName);
				System.out.println("entered into else inside session==null");
					  if(nextPageName.equals("Cart"))
					  {
			              response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");
					  }
					  
					  else if(nextPageName.equals("Orders"))
					  {
			              response.sendRedirect("/wildfly-kitchensink-jsp/orders");
					  }
					  else
					  {
						  System.out.println("entered into else of else...........");
						  List<HclSkManufacturer> manu=memberResourceRESTService.listAllManufacuturer();
					        System.out.println("Manufacturer List are : "+manu);
					        request.setAttribute("manu", manu);
					        String category=request.getParameter("category");
					        System.out.println("the category inside doGet() is :"+category);
					        request.setAttribute("category", category);
					        
					        
					        
						  int MaxTableSize=3;
						List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(MaxTableSize);
			              System.out.println("result::::"+listAllMembers);
			              request.setAttribute("members", listAllMembers);
//						  RequestDispatcher resultView =request.getRequestDispatcher("/BrowseItems"); 
			              response.sendRedirect("/wildfly-kitchensink-jsp/BrowseItems");
						  
					 

						  
					  }
				  }

}
