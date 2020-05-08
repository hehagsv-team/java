<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
	<head>
		  <style><%@include file="/resources/css/Payment.css"%></style>
<title>Payment</title>
</head>
<body>

<%-- <%
    out.println("order id is : "+request.getAttribute("Status1"));
%> --%>
	<div class="container">
            <header>
			<div class="center-align">Shopping Cart</div>
			<ul class="right-align">
			
			
				<form name="submitForm1" method="POST" action="/wildfly-kitchensink-jsp/BrowseItems">
	            <input type="hidden" name="username" value="${name}">
	            <li><a href="javascript:document.submitForm1.submit()">Home</a></li>
	            </form>
	            
             <form name="submitForm3" method="POST" action="/wildfly-kitchensink-jsp/orders">
	            <input type="hidden" name="username" value="${name}">
	            <li><a href="javascript:document.submitForm3.submit()">Orders</a></li>
	            </form>

				<form name="submitForm" method="POST" action="/wildfly-kitchensink-jsp/cart.do">
	            <input type="hidden" name="username" value="${name}">
	            <li><a href="javascript:document.submitForm.submit()">Cart</a></li>
	            </form>


				             
            </ul>          
            <div class="right">            <!--    
                <a href="login">logout</a>  -->
                <form name="submitForm2" method="GET" action="/wildfly-kitchensink-jsp/BrowseItems">
	            <input type="hidden" name="username" value="null">
	            <li><a href="javascript:document.submitForm2.submit()">Logout</a></li>
	            </form>
            </div>
            <label class="user">${name}</label>
        </header>
        </div>
        
	
	<form method="POST" ><div ></div>

		   <input type="hidden" name="username" value="${name}">
		   <input type="hidden" name="paymentButton" value="payment">
		    <input type="hidden" name="OrderId" value="${order}">
		    <input type="hidden"  name="Status" value="${status}">
		    
		    <div class="selector"><br><br><br>
			    <!--  <input type="radio" id="r1" name="paymentYes"  value="yes" >Yes<br><br>
			     <input type="radio" id="r2" name="paymentYes"  value="no" >No -->
			     <c:set var="Status" value="${status}"/>
			     <%-- <c:set var="reversePayment" value="Refundable"/>
			     <c:set var="Status" value="Pass"/>
			     <c:set var="Status" value="Fail"/> --%>
		        <c:choose>
		        
							<c:when test="${Status == 'Pass'}">
			
								<center><div class="NextEmpty"><p> Payment in Progress</p></div></center>
			
			
							</c:when>
			
			       <c:otherwise>
									<center><div class="NextEmpty"><p>Payment Failed Please Try Again</p></div></center>
									
									</c:otherwise>
		</c:choose>
			
			      <button type="submit"  name="paymentButton" value="payment" >OK</button>
		    </div>
	</form>
</body>
</html>