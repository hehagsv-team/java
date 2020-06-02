//package org.jboss.as.quickstarts.kitchensinkjsp.servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.jboss.as.quickstarts.kitchensinkjsp.model.HclSkManufacturer;
//import org.jboss.as.quickstarts.kitchensinkjsp.model.OrdersDetails;
//import org.jboss.as.quickstarts.kitchensinkjsp.rest.MemberResourceRESTService;
//
///**
// * Servlet implementation class ManufacturerServlet
// */
//@WebServlet("/manu")
//public class ManufacturerServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//	@Inject
//    MemberResourceRESTService service;
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ManufacturerServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	/*
//	 * protected void doGet(HttpServletRequest request, HttpServletResponse
//	 * response) throws ServletException, IOException { // TODO Auto-generated
//	 * method stub
//	 * response.getWriter().append("Served at: ").append(request.getContextPath());
//	 * }
//	 */
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//        StringBuilder errorMessage = new StringBuilder();
//
//		try {
//
//	        List<HclSkManufacturer> manu=service.listAllManufacuturer();
//	        System.out.println("Manufacturer List are : "+manu);
//	        request.setAttribute("manu", manu);
//	        String category=request.getParameter("category");
//	        request.setAttribute("category", category);
//			
//		}        
//		catch (Exception e) {
//
//            Throwable t = e;
//            while ((t.getCause()) != null) {
//                t = t.getCause();
//            }
//
//            errorMessage.append("Error========>" + t.getMessage());
//            request.setAttribute("infoMessage", "");
//            e.printStackTrace();
//        } finally {
//            request.setAttribute("errorMessage", errorMessage.toString());
//            RequestDispatcher resultView = request.getRequestDispatcher("BrowseItems.jsp");
//            resultView.forward(request, response);
//        }
//	}
//
//}
