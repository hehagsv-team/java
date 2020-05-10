package org.hcl.shoppingKart.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hcl.shoppingKart.model.Orders;
import org.hcl.shoppingKart.model.UserAccount;
import org.hcl.shoppingKart.rest.CartResourceRESTService;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Inject
	CartResourceRESTService cartResourceRESTService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
		response.getWriter().append("Served at: ").append(request.getContextPath());
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String order_id=(String) request.getAttribute("order");
		System.out.println("in paymentservlet orderid is"+order_id);
		
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		System.out.println("the username in dopost of paymentservlet "+ username);
		String radioButtonValue = request.getParameter("paymentYes");
		String paymentButtonvalue = request.getParameter("paymentButton");
		if(paymentButtonvalue.equals("payment") && radioButtonValue.equals("yes"))
		{
			String userName=request.getParameter("username");
			System.out.println("the username in dopost of paymentservlet of hidden "+ userName);
			
//			String order=request.getParameter("OrderId");
//			System.out.println("from hidden button order id value is"+order);
//			String quant=request.getParameter("quant");
//			System.out.println("from hidden button qunatity value is"+quant);
			System.out.println("inside the method of updatepayment");
//		     cartResourceRESTService.UpdatePersist();
//		     List<Orders> list=cartResourceRESTService.selects();
//		     System.out.println("list of elements is"+list);
			
//			System.out.println("after the update");
			System.out.println("after the redirection");
	        response.sendRedirect("/Auth-REST-Refund-Log4j-Junit/orders");
		}
		else if(paymentButtonvalue.equals("payment") && radioButtonValue.equals("no"))
		{
	        response.sendRedirect("/Auth-REST-Refund-Log4j-Junit/cart.do");

		}
	}

}
