package org.jboss.as.quickstarts.kitchensinkjsp.filter;

import java.io.IOException;

import javax.inject.Inject;
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
import org.jboss.as.quickstarts.kitchensinkjsp.rest.CartResourceRESTService;
import org.jboss.as.quickstarts.kitchensinkjsp.servlet.LoginServlet;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginServlet")
public class LoginFilter implements Filter {

 static Logger logger = Logger.getLogger(LoginFilter.class);
    
    @Inject
    CartResourceRESTService memberResourceRESTService;

    
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		
		logger.info("............ENTERED INTO LOGIN FILTER....................");
		String usernameFromJsppageToFilter = request.getParameter("name");
		logger.debug("ABOVE IF : the username form jsp to filter is :"+usernameFromJsppageToFilter);
		HttpSession session = req.getSession(false);
		String attribute = (String)session.getAttribute("UsernameFilter");
		Boolean isvalid1= memberResourceRESTService.validuser(attribute);
		if(!isvalid1)
		{
			attribute=null;
		}
		logger.debug("The username if ALREADY EXIST : "+attribute);
		
		if(attribute==null)
		{
			logger.debug("IF : the username form jsp to filter is :"+usernameFromJsppageToFilter);
			if(usernameFromJsppageToFilter!=null)
			{
				Boolean isvalid= memberResourceRESTService.validuser(usernameFromJsppageToFilter);
			    if(isvalid)
			    {
			    	logger.debug("LoginFilter : username is valid :"+usernameFromJsppageToFilter);
					session = req.getSession();
					session.setAttribute("UsernameFilter", usernameFromJsppageToFilter);
					logger.info("username in Filter page is :"+usernameFromJsppageToFilter);
					chain.doFilter(request, response);
			    }
			    else {
			    	logger.info("Entered into else....of if(isvalid)........");
			    	logger.warn("Invalid username");
//					res.sendRedirect("wildfly-kitchensink-jsp/");
					request.setAttribute("errorMessage", "Invalid username");
//			        res.sendRedirect("/wildfly-kitchensink-jsp");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
					requestDispatcher.forward(request, response);

			    }
			}
			else {
				logger.info("Entered into else....of if(username)........");
//				res.sendRedirect("wildfly-kitchensink-jsp/");
		        res.sendRedirect("/wildfly-kitchensink-jsp");

			}
		}
		else
		{
			logger.info("Entered into else....of if(attribute==null)........");
//	        res.sendRedirect("/wildfly-kitchensink-jsp/BrowseItems");
			chain.doFilter(request, response);

		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
