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

import org.apache.log4j.Logger;
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
		
	 static final long serialVersionUID = 1L;
	
	static Logger logger =Logger.getLogger(LoginServlet.class);
	
	
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
		logger.info("entered LoginServlet doget () method");		
		  HttpSession session=request.getSession(false);  

	        String username=(String)session.getAttribute("SessionUsername");
	        logger.debug("username in CartServlet SESSION is : "+username);
          session.invalidate();  
          logger.info("after clearing sessio ....sending control to Login .jsp");
  		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
  		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        StringBuilder errorMessage = new StringBuilder();
        logger.info("entered into the loginservlet");
        logger.info("Control enters into dopost() of LoginSErvlet");
		String userName=request.getParameter("name");
		logger.info("the value of username from loginservlet in dopost of loginservlet is : "+userName);
//	        request.setAttribute("name", userName);
		logger.info("checking session..................");

	       		User cart=new User();
		        int start=0;
		        request.setAttribute("start", start);
		        request.setAttribute("radioButtonValueTextBox", "All");
		        logger.debug("the name send to cartServlet : "+userName);
		        String nextPageName = request.getParameter("nextPageName");
		        logger.debug("next page value in LoginServlet : "+nextPageName);
		        logger.info("entered into else inside session==null");
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
						  logger.info("entered into else of else...........");
						  List<HclSkManufacturer> manu=memberResourceRESTService.listAllManufacuturer();
						  logger.debug("Manufacturer List are : "+manu);
					        request.setAttribute("manu", manu);
					        String category=request.getParameter("category");
					        logger.info("the category inside doGet() is :"+category);
					        request.setAttribute("category", category);
					        
					        
					        
						  int MaxTableSize=3;
						List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(MaxTableSize);
						logger.debug("result::::"+listAllMembers);
			              request.setAttribute("members", listAllMembers);
//						  RequestDispatcher resultView =request.getRequestDispatcher("/BrowseItems"); 
			              response.sendRedirect("/wildfly-kitchensink-jsp/BrowseItems");
						  
					 

						  
					  }
				  }

}
