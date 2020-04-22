package org.jboss.as.quickstarts.kitchensinkjsp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.jboss.as.quickstarts.kitchensinkjsp.filter.CopyPrintWriter;

public class HeaderFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		PrintWriter out = response.getWriter();
		
		System.out.println("............ENTERED INTO HEADER FILTER....................");
//		String usernameFromlogin = request.getParameter("name");
//		System.out.println("usernameFromJsppageToFilter is::" +usernameFromlogin );
			ArrayList list=new ArrayList();
			ArrayList list1=new ArrayList();
			String HeaderName1=null;		
			Enumeration<String> headerNames=req.getHeaderNames();
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("-----------------------------------ENTERING INTO REQUEST HEADERS-------------------------------------------");
			while (headerNames.hasMoreElements() )
			{
				HeaderName1 = (String) headerNames.nextElement();
				list1.add(HeaderName1);
				list.add(req.getHeader(HeaderName1));			
			}
		for(int i=0;i<list.size();i++)
			{
				System.out.print(list1.get(i) +"::"+ list.get(i)+ "\n");
			}
		System.out.println("request URL::"+req.getRequestURI() );
		
//		chain.doFilter(req, res);

		
		final CopyPrintWriter writer = new CopyPrintWriter(response.getWriter());
	    chain.doFilter(req, new HttpServletResponseWrapper((HttpServletResponse) response) {
	        public PrintWriter getWriter() {
	            return writer;
	        }
	    });
		
	    System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    System.out.println("--------------------------------------ENTERING INTO RESPONSE HEADERS-------------------------------------\n");
	    Collection<String> headerresponse=res.getHeaderNames();
		ArrayList header=new ArrayList();
		ArrayList value=new ArrayList();
		for(String e:headerresponse)
		{
			header.add(e);
			value.add(res.getHeader(e));				
		}
//		System.out.println("headers::"+header);
//		System.out.println("headers::"+value);
		for(int i=0;i<header.size();i++)
		{
			System.out.print(header.get(i) +"::"+ value.get(i)+ "\n");
		}
		System.out.println("request URL::"+req.getRequestURI() );
		
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		String gg=writer.getCopy();	
     	System.out.println(gg);
//		String wrd="";
//		char c='>';
//		for(int i=0;i<=gg.length()-1;i++)
//		{
//			if(gg.charAt(i)!='>')
//			{
//				wrd=wrd+gg.charAt(i);
//				System.out.print(wrd);
//			}			
//			else
//			{
//				wrd=wrd+c;
//				System.out.print(wrd +"\n");
//			}
//			wrd="";
//		}
		
				
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
