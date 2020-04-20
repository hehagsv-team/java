package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.IOException;
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
			String HQL="SELECT items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:usernameUser";
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
		System.out.println("........Username in cartservlet that is taken from Servlet : "+username);
			request.setAttribute("name", username);
			System.out.println("usernamein dopost methoid of cartservlet is : "+username);
			String dopost="doPost";
			String paymentButton =request.getParameter("paymentButton");
			System.out.println("The value of payment button in dopost() CArtServlet is :"+paymentButton);
			if(paymentButton !=null && paymentButton.equals("payment"))
			{
				System.out.println("ENTERED INTO PAYMENT BUTTON EQUALS CONDITION");
		        response.sendRedirect("/wildfly-kitchensink-jsp/PaymentServlet");
			
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

			String HQL="SELECT items.Name, items.Price FROM HclSkItems items,Orders ord WHERE items.Id=ord.item_id AND ord.payment=0 AND ord.userName=:Username";
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
