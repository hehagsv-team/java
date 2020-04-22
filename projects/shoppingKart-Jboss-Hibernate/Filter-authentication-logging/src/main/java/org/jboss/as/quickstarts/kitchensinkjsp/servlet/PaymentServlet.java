package org.jboss.as.quickstarts.kitchensinkjsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("payment.jsp");
		requestDispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String radioButtonValue = request.getParameter("paymentYes");
		String paymentButtonvalue = request.getParameter("paymentButton");
		if(paymentButtonvalue.equals("payment") && radioButtonValue.equals("yes"))
		{
	        response.sendRedirect("/wildfly-kitchensink-jsp/orders");
		}
		else if(paymentButtonvalue.equals("payment") && radioButtonValue.equals("no"))
		{
	        response.sendRedirect("/wildfly-kitchensink-jsp/cart.do");

		}
	}

}
