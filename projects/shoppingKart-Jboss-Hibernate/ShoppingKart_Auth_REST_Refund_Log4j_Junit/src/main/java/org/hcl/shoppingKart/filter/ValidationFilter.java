package org.hcl.shoppingKart.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hcl.shoppingKart.servlet.LoginServlet;

/**
 * Servlet Filter implementation class ValidationFilter
 */
@WebFilter({"/cart.do","/orders","/BrowseItems"})
public class ValidationFilter implements Filter {
	
	static Logger logger = Logger.getLogger(ValidationFilter.class);

	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String serverName = request.getServerName();
		
		logger.debug("ENTERED INTO VALIDATION FILTER...........");
		logger.info("servlet name in Validation filter is :"+serverName);
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String servletPath = req.getServletPath();
		logger.debug("servlet path................ "+servletPath);
		HttpSession session = req.getSession(false);
		String username = (String)session.getAttribute("UsernameFilter");
		logger.info("........Username in cartservlet that is taken from Servlet : "+username);
		if(username!=null)
		{
			chain.doFilter(request, response);
		}
		// pass the request along the filter chain
		else
		{
			if(servletPath.equals("/cart.do"))
			{

				request.setAttribute("nextPageValue","Cart");
				request.setAttribute("commonMessage", "Please Login for Cart Items");
			}
			else if(servletPath.contentEquals("/orders"))
			{

				request.setAttribute("nextPageValue","Orders");
				request.setAttribute("commonMessage", "Please Login to view Orders");
			}
			else
			{

				request.setAttribute("commonMessage", "Please Login for BrowseItems");
			}
		      RequestDispatcher resultView = request.getRequestDispatcher("Login.jsp");
		      resultView.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
