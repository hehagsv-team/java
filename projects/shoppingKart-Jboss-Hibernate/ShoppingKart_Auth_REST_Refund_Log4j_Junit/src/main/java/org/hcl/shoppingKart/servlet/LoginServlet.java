package org.hcl.shoppingKart.servlet;

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
import org.hcl.shoppingKart.controller.LoginUser;
import org.hcl.shoppingKart.controller.MemberRegistration;
import org.hcl.shoppingKart.data.MemberListProducer;
import org.hcl.shoppingKart.model.HclSkManufacturer;
import org.hcl.shoppingKart.rest.CartResourceRESTService;

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
	    
	    String nextPageName; 
	    HttpSession session;
	    
	    String category;
	    
	    
	    
       
    public String getCategory() {
			return category;
		}

	public String getNextPageName() {
			return nextPageName;
		}
		
	

	public HttpSession getSession() {
			return session;
		}
	/**
     * @see HttpServlet#HttpServlet()
     */



	public String getUserName() {
			return userName;
		}
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		logger.info("entered LoginServlet doget () method");		
		  session=request.getSession(false);  

	        userName=(String)session.getAttribute("SessionUsername");
	        logger.debug("username in CartServlet SESSION is : "+userName);
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
		         nextPageName = request.getParameter("nextPageName");
		        logger.debug("next page value in LoginServlet : "+nextPageName);
		        logger.info("entered into else inside session==null");
					  if(nextPageName.equals("Cart"))
					  {
			              response.sendRedirect("/Auth-REST-Refund-Log4j-Junit/cart.do");
					  }
					  
					  else if(nextPageName.equals("Orders"))
					  {
			              response.sendRedirect("/Auth-REST-Refund-Log4j-Junit/orders");
					  }
					  else
					  {
						  logger.info("entered into else of else...........");
						  List<HclSkManufacturer> manu=memberResourceRESTService.listAllManufacuturer();
						  logger.debug("Manufacturer List are : "+manu);
					        request.setAttribute("manu", manu);
					       category=request.getParameter("category");
					        logger.info("the category inside doGet() is :"+category);
					        request.setAttribute("category", category);
					        
					        
					        
						  int MaxTableSize=3;
						List<Object[]> listAllMembers=memberResourceRESTService.listAllMembers(MaxTableSize);
						logger.debug("result::::"+listAllMembers);
			              request.setAttribute("members", listAllMembers);
//						  RequestDispatcher resultView =request.getRequestDispatcher("/BrowseItems"); 
			              response.sendRedirect("/Auth-REST-Refund-Log4j-Junit/BrowseItems");
						  
					 

						  
					  }
				  }

}
