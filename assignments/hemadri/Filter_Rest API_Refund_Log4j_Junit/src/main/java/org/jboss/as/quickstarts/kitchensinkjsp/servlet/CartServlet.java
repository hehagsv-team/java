package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jboss.as.quickstarts.kitchensinkjsp.model.Orders;
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Servlet implementation class CartService
 */
@WebServlet("/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 static Logger logger = Logger.getLogger(CartServlet.class);
       
	int maxTableSize=3;
	
	
	@Inject
    private EntityManager em;
	
	@Inject
	CartResourceRESTService cartResourceRESTService;
	
	@Inject
	MemberRegistrationServlet memberRegistrationServlet;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start=0;
		logger.debug("ENTERED INTO CART SERVLET DOGET() METHOD");
		logger.debug("entered into the cartservlet");
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
	    
		logger.debug("........Username in cartservlet that is taken from Servlet : "+username);
			request.setAttribute("name", username);
			String HQL="SELECT ord.Id, items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:usernameUser";
			
			Query createQuery = em.createQuery(HQL);
			createQuery.setParameter("usernameUser", username);
			int size = createQuery.getResultList().size();
			logger.debug("size of the cart items are : : " +size);
			String doget="doGet";
			request.setAttribute("doGet", doget);
			int disableAllButtons=0;
			if(size>0)
			{
				disableAllButtons=1;
				request.setAttribute("disableAllButtons",disableAllButtons);
			}


			createQuery.setFirstResult(0);
			createQuery.setMaxResults(maxTableSize);
			List<Object[]> resultList = createQuery.getResultList();

			logger.debug("entered into the cart page servlet code");
		    request.setAttribute("members", resultList);
		    request.setAttribute("start", start);
		  
		   
		    
		    
		    
		    logger.info("The resultset items are: : : "+resultList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
			requestDispatcher.forward(request, response);

			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
		logger.debug("........Username in cartservlet that is taken from Servlet : "+username);
			request.setAttribute("name", username);
			logger.debug("usernamein dopost methoid of cartservlet is : "+username);
			String dopost="doPost";
			String paymentButton =request.getParameter("paymentButton");
			logger.debug("The value of payment button in dopost() CArtServlet is :"+paymentButton);
			//			String radioButtonValue = request.getParameter("paymentYes");
			String Statusval=request.getParameter("Status");
			
			String paymentButtonvalue = request.getParameter("paymentButton");
			
			
			if(paymentButtonvalue!=null && Statusval!=null && paymentButtonvalue.equals("payment") && Statusval.equals("Pass"))
			{
				String userName=request.getParameter("username");
				logger.info("the username in dopost of paymentservlet of hidden "+ userName);
				
			String order=request.getParameter("OrderId");
			logger.info("from hidden button order id value is"+order);
//				String quant=request.getParameter("quant");
				logger.info("inside the method of updatepayment");
			     int i=cartResourceRESTService.updateorder(userName, order );
			     List<Orders> list=cartResourceRESTService.selects(order);
			     logger.debug("list of elements is"+list);
				if(i>0)
				{
				logger.info("after the redirection");
		        response.sendRedirect("/wildfly-kitchensink-jsp/orders");
				}
				else
				{
					
					URL url1 = new URL("http://localhost:8082/status");
					HttpURLConnection conns = (HttpURLConnection) url1.openConnection();
					conns.setRequestMethod("GET");
					conns.setRequestProperty("Accept", "application/json");

					if (conns.getResponseCode() != 200) {
						throw new RuntimeException("Failed : HTTP error code : " + conns.getResponseCode());
					}

					BufferedReader br1 = new BufferedReader(new InputStreamReader(
							(conns.getInputStream())));

					String s1=null;
					String output1;
					logger.info("Output from Server .... \n");
					logger.debug("checking whether log4j exists");
					while ((output1 = br1.readLine()) != null)
					{
						logger.debug(output1);
						s1=output1;
					}
					logger.debug("the string data is: "+s1);
					Object obj1=JSONValue.parse(s1);
					JSONObject jsonObject1=(JSONObject) obj1;
					String Status1=(String) jsonObject1.get("Payment");
					logger.debug("the data inside name i S1  " +Status1 );
					request.setAttribute("reverse",Status1);
	 				logger.info("after the update");
					logger.info("after the redirection");
//   		        response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
					requestDispatcher.forward(request, response);
		}
			}
			else if(paymentButtonvalue!=null && Statusval!=null &&  paymentButtonvalue.equals("payment") && Statusval.equals("Fail"))
			{
		        response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");

			}
			if(paymentButton !=null && paymentButton.equals("payment"))
			{
				
				String order=request.getParameter("adding");
				logger.debug("orderId in post :: "+order);
				request.setAttribute("order",order );
				
//				String order=request.getParameter("Order_Id");
				URL url = new URL("http://localhost:8081/test");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String s=null;
				String output;
				logger.info("Output from Server .... \n");
				while ((output = br.readLine()) != null)
				{
					logger.debug(output);
					s=output;
				}
				logger.debug("the string data is: "+s);
				Object obj=JSONValue.parse(s);
				JSONObject jsonObject=(JSONObject) obj;
				String Status=(String) jsonObject.get("Status");
				logger.debug("the data inside name is  " +Status );
				request.setAttribute("status", Status);
							


				logger.debug("ENTERED INTO PAYMENT BUTTON EQUALS CONDITION");
		        
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
				requestDispatcher.forward(request, response);

			
			
			}
			request.setAttribute("doPost", dopost);
			logger.debug("ENTERED INTO CART DOPOST() METHOD");
			String pageButton = request.getParameter("firstButton");
			logger.debug("PAGINATION BUTTON : : "+pageButton);
			request.setAttribute("pageButton", pageButton);
			String parameter = request.getParameter("table-start");
			logger.debug("page table start index : "+parameter);
			request.setAttribute("maxTableSize", maxTableSize);
			int start=0;
			if(parameter!=null){

				start=Integer.parseInt(parameter);
			}
			request.setAttribute("start", start);
			int max=maxTableSize;

			String HQL="SELECT ord.Id, items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:Username";
			Query createQuery = em.createQuery(HQL);
			logger.debug("USERNAME before set parameter : "+username);
			createQuery.setParameter("Username", username);
			int cartItemsSize = createQuery.getResultList().size();
			if(cartItemsSize==0)
			{
				logger.debug("ENTERED AS NO ITEMS RETURNED");
	        	String blockTable="blockAllTable";
	        	request.setAttribute("blockAllTable",blockTable);
			}
			if(cartItemsSize<=maxTableSize)
	    	{
				String block="sufficient";
				request.setAttribute("blockAll", block);
	    	}
			if(pageButton==null)
			{
				createQuery.setFirstResult(0);
				createQuery.setMaxResults(maxTableSize);
				List<Object[]> resultList = createQuery.getResultList();

			    request.setAttribute("members", resultList);
			    logger.debug("the list when pagebutton is null is : : : ; "+resultList);
				
			}
			else {
				int size = createQuery.getResultList().size();
				request.setAttribute("manufacturerSize", size);
				if(pageButton.equals("Next"))
				{
	        		logger.debug("control enteres into Next OrderServlet");
//					String HQL="SELECT items.Name, items.Price,ord.quantity FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0";
//					Query createQuery = em.createQuery(HQL);
					logger.debug("start value in NEXT CART"+start);
					start=start+maxTableSize;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
					
					
				    request.setAttribute("members", resultList);
					logger.info("The resultset items are: : : "+resultList);
//					start=start+2;
					logger.debug("start value in NEXT CART"+start);
					logger.info("the value sending to the cart page from DOPOST() method : "+start);
					request.setAttribute("start", start);
					
				}
				else if(pageButton.equals("First"))
				{
					start=0;
//					Query createQuery = em.createQuery(HQL);
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					logger.debug("the value of start inside first :"+start );
					
				}
				
				else if(pageButton.equals("Last"))
				{
					start=size-maxTableSize;

					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					logger.debug("the value of start inside first :"+start );

				}
				
				
				else if(pageButton.equals("Previous"))
				{
					start=start-maxTableSize;
					logger.debug("ENTERED INTO PREVIOUS ORDERSERVLET");
					if(start<=0)
						start=start-start;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					logger.debug("The resultset items are: : : "+resultList);
					logger.debug("the value of start inside first :"+start );
					
					
				}

				
			}

				
				
				
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
					requestDispatcher.forward(request, response);

			

		
			
		
		
	}
}






//cartResourceRESTService.InsertPersist();

//List<Object[]>items ;
//	items=cartResourceRESTService.insertItems(username);
//	List<Object[]>Inserts;
//	Inserts=cartResourceRESTService.InsertInfo(username);