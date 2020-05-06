package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
import javax.xml.soap.SOAPException;

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
		System.out.println("ENTERED INTO CART SERVLET DOGET() METHOD");
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
	    
		System.out.println("........Username in cartservlet that is taken from Servlet : "+username);
			request.setAttribute("name", username);
			String HQL="SELECT ord.Id, items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:usernameUser";
			
			Query createQuery = em.createQuery(HQL);
			createQuery.setParameter("usernameUser", username);
			int size = createQuery.getResultList().size();
			System.out.println("size of the cart items are : : " +size);
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

			System.out.println("entered into the cart page servlet code");
		    request.setAttribute("members", resultList);
		    request.setAttribute("start", start);
		  
		   
		    
		    
		    
		    System.out.println("The resultset items are: : : "+resultList);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
			requestDispatcher.forward(request, response);

			}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
		System.out.println("........Username in cartservlet that is taken from Servlet : "+username);
			request.setAttribute("name", username);
			System.out.println("usernamein dopost methoid of cartservlet is : "+username);
			String dopost="doPost";
			String paymentButton =request.getParameter("paymentButton");
			System.out.println("The value of payment button in dopost() CArtServlet is :"+paymentButton);
			//			String radioButtonValue = request.getParameter("paymentYes");
			String Statusval=request.getParameter("Status");
			String paymentButtonvalue = request.getParameter("paymentButton");
			
		
			if(paymentButtonvalue!=null && Statusval!=null && paymentButtonvalue.equals("payment") && Statusval.equals("Pass"))
			{
				String userName=request.getParameter("username");
				System.out.println("the username in dopost of paymentservlet of hidden "+ userName);
				
			String order=request.getParameter("OrderId");
			System.out.println("from hidden button order id value is"+order);
//				String quant=request.getParameter("quant");
//				System.out.println("from hidden button qunatity value is"+quant);
				System.out.println("inside the method of updatepayment");
			     int i=cartResourceRESTService.updateorder(userName, order );
			     List<Orders> list=cartResourceRESTService.selects(order);
			     System.out.println("list of elements is"+list);
				if(i>0)
				{
//				System.out.println("after the update");
				System.out.println("after the redirection");
		        response.sendRedirect("/wildfly-kitchensink-jsp/orders");
				}
				else
				{
					System.out.println("after the update");
					System.out.println("after the redirection");
			        response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");
				}
			}
			else if(paymentButtonvalue!=null && Statusval!=null &&  paymentButtonvalue.equals("payment") && Statusval.equals("Fail"))
			{
		        response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");

			}
			if(paymentButton !=null && paymentButton.equals("payment"))
			{
				
				
				String order=request.getParameter("adding");
				System.out.println("orderId in post :: "+order);
				                 
				request.setAttribute("order",order );
	
		
		System.out.print("Current Time in milliseconds = ");
		long timeBeforeconnection=System.currentTimeMillis();
	    System.out.println(System.currentTimeMillis());
	    
		System.out.println("Before connection");
	
		URL url = new URL("http://localhost:8081/test");		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json"); 
	conn.setConnectTimeout(50);	   
	BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	String s=null;
	String output;		
	long timeout=conn.getConnectTimeout();
		System.out.print("Current Time in milliseconds = ");
		long timeAfterConnection=System.currentTimeMillis();
	    System.out.println(System.currentTimeMillis());
	    long finaltime=timeAfterConnection-timeBeforeconnection;
	    System.out.println("the final time is::"+finaltime);
	    if(finaltime>timeout)
	    {
	    	try {
				throw new TimeoutException();
			} catch (TimeoutException e) {
				System.out.println("the tiemout exception is ::"+e.fillInStackTrace());
//				conn.disconnect();
//				 System.out.println("connection timedout please try payment again");					
			}
	    }
		while ((output = br.readLine()) != null)
		{
			System.out.println(output);
			s=output;
		}
		br.close();
		System.out.println("After Connection");
		System.out.println("the string data is: "+s);
		Object obj=JSONValue.parse(s);
		JSONObject jsonObject=(JSONObject) obj;
		String Status=(String) jsonObject.get("Status");
		System.out.println("the data inside name is  " +Status );
		
		request.setAttribute("status", Status);
		System.out.println("ENTERED INTO PAYMENT BUTTON EQUALS CONDITION");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
		requestDispatcher.forward(request, response);
		
		
	}
			
				
			request.setAttribute("doPost", dopost);
			System.out.println("ENTERED INTO CART DOPOST() METHOD");
			String pageButton = request.getParameter("firstButton");
			System.out.println("PAGINATION BUTTON : : "+pageButton);
			request.setAttribute("pageButton", pageButton);
			String parameter = request.getParameter("table-start");
			System.out.println("page table start index : "+parameter);
			request.setAttribute("maxTableSize", maxTableSize);
			int start=0;
			if(parameter!=null){

				start=Integer.parseInt(parameter);
			}
			request.setAttribute("start", start);
			int max=maxTableSize;
//			
//				System.out.println("After insert elements are"+Inserts);

			String HQL="SELECT ord.Id, items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:Username";
			Query createQuery = em.createQuery(HQL);
			System.out.println("USERNAME before set parameter : "+username);
			createQuery.setParameter("Username", username);
			int cartItemsSize = createQuery.getResultList().size();
			if(cartItemsSize==0)
			{
				System.out.println("ENTERED AS NO ITEMS RETURNED");
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
			    System.out.println("the list when pagebutton is null is : : : ; "+resultList);
				
			}
			else {
				int size = createQuery.getResultList().size();
				request.setAttribute("manufacturerSize", size);
				if(pageButton.equals("Next"))
				{
	        		System.out.println("control enteres into Next OrderServlet");
//					String HQL="SELECT items.Name, items.Price,ord.quantity FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0";
//					Query createQuery = em.createQuery(HQL);
					System.out.println("start value in NEXT CART"+start);
					start=start+maxTableSize;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
					
					
				    request.setAttribute("members", resultList);
					System.out.println("The resultset items are: : : "+resultList);
//					start=start+2;
					System.out.println("start value in NEXT CART"+start);
					System.out.println("the value sending to the cart page from DOPOST() method : "+start);
					request.setAttribute("start", start);
					
				}
				else if(pageButton.equals("First"))
				{
//					System.out.println("entered into FIRST loop : : start value is : "+start+"\t Max value is : "+max);
					start=0;
//					Query createQuery = em.createQuery(HQL);
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					System.out.println("The resultset items are: : : "+resultList);
					System.out.println("the value of start inside first :"+start );
					
				}
				
				else if(pageButton.equals("Last"))
				{
					start=size-maxTableSize;
//					System.out.println("entered into LAST loop : : start value is : "+start+"\t Max value is : "+max);

					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					System.out.println("The resultset items are: : : "+resultList);
					System.out.println("the value of start inside first :"+start );

				}
				
				
				else if(pageButton.equals("Previous"))
				{
//					System.out.println("entered into PREVIOUS loop : : start value is : "+start+"\t Max value is : "+max);
					start=start-maxTableSize;
//					System.out.println("entered into PREVIOUS loop : : start value is : "+start+"\t Max value is : "+max);
					System.out.println("ENTERED INTO PREVIOUS ORDERSERVLET");
					if(start<=0)
						start=start-start;
					createQuery.setFirstResult(start);
					createQuery.setMaxResults(maxTableSize);
					@SuppressWarnings("unchecked")
					List<Object[]> resultList = createQuery.getResultList();
//					start=start+2;
					request.setAttribute("start", start);
				    request.setAttribute("members", resultList);
					System.out.println("The resultset items are: : : "+resultList);
					System.out.println("the value of start inside first :"+start );
					
					
				}
				
				

				
			}

				
				
				
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
					requestDispatcher.forward(request, response);

			

	
			
		
		
	}
}








//cartResourceRESTService.InsertPersist();

//List<Object[]>items ;
//	items=cartResourceRESTService.insertItems(username);
//	System.out.println("in the post method is"+items);
//	List<Object[]>Inserts;
//	Inserts=cartResourceRESTService.InsertInfo(username);
