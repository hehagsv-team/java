<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head><!-- 
		<link rel="stylesheet" type="text/css" href="/resource/css/style6.css"> -->
		  <style><%@include file="/resources/css/style6.css"%></style>
		

		<script type="text/javascript">
		function preback(){window.history.forward();}
		setTimeout("preback()",0);
		window.onunload=function(){null};
		
	
		function rdbuttonClick1(){
			document.getElementById("hidden-first").disabled=false;
			document.getElementById("hidden-quantity").disabled=true;
			document.getElementById("hidden-rdbutton").disabled=true;
	 		document.getElementById("hidden-payment").disabled=true;  
			document.getElementById("cart-button").disabled=false;
			document.getElementById("quantity-id1").disabled=false;
			document.getElementById("quantity-id2").disabled=true;
			document.getElementById("quantity-id3").disabled=true;
			document.getElementById("quantity-id4").disabled=true;
			document.getElementById("quantity-id5").disabled=true;
			
		}
		function rdbuttonClick2(){
			document.getElementById("hidden-first").disabled=false;
			document.getElementById("hidden-quantity").disabled=true;
			document.getElementById("hidden-rdbutton").disabled=true;
			document.getElementById("hidden-payment").disabled=true;  
			document.getElementById("cart-button").disabled=false;
			document.getElementById("quantity-id2").disabled=false;
			document.getElementById("quantity-id1").disabled=true;
			document.getElementById("quantity-id3").disabled=true;
			document.getElementById("quantity-id4").disabled=true;
			document.getElementById("quantity-id5").disabled=true;
			
		}
		function rdbuttonClick3(){
			document.getElementById("hidden-first").disabled=false;
			document.getElementById("hidden-quantity").disabled=true;
			document.getElementById("hidden-rdbutton").disabled=true;
 		 	document.getElementById("hidden-payment").disabled=true;  
			document.getElementById("cart-button").disabled=false;
			document.getElementById("quantity-id3").disabled=false;
			document.getElementById("quantity-id2").disabled=true;
			document.getElementById("quantity-id1").disabled=true;
			document.getElementById("quantity-id4").disabled=true;
			document.getElementById("quantity-id5").disabled=true;
			
		}
		function rdbuttonClick4(){
			document.getElementById("hidden-first").disabled=false;
			document.getElementById("hidden-quantity").disabled=true;
			document.getElementById("hidden-rdbutton").disabled=true;
 		 	document.getElementById("hidden-payment").disabled=true;  
			document.getElementById("cart-button").disabled=false;
			document.getElementById("quantity-id4").disabled=false;
			document.getElementById("quantity-id2").disabled=true;
			document.getElementById("quantity-id3").disabled=true;
			document.getElementById("quantity-id1").disabled=true;
			document.getElementById("quantity-id5").disabled=true;
		
		}
		function rdbuttonClick5(){
			document.getElementById("hidden-first").disabled=false;
			document.getElementById("hidden-quantity").disabled=true;
			document.getElementById("hidden-rdbutton").disabled=true;
 			document.getElementById("hidden-payment").disabled=true;  
			document.getElementById("cart-button").disabled=false;
			document.getElementById("quantity-id5").disabled=false;
			document.getElementById("quantity-id2").disabled=true;
			document.getElementById("quantity-id3").disabled=true;
			document.getElementById("quantity-id4").disabled=true;
			document.getElementById("quantity-id1").disabled=true;
		
		}
		
		function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		        return false;
		    }
		    return true;
		}
		
		function onclickLast(){
			document.getElementById("Previous-button").disabled=false;
		}
		function onclickNext(){
			document.getElementById("Previous-button").disabled=false;
		}
		
	 	function paymentEnabled(){
			document.getElementById("hidden-first").disabled=true;
		} 
	 	
	 	function paymentdupDis(){
	 		
	 		document.getElementById("hidden-payment").disabled=true;
	 		
	 	}
	 	function add(){
	 		document.getElementById("cart-button").disabled=false;
	 		/* document.getElementById("adding").value=document.getElementById("orderId").value */
		}
		
		/* function firstOnclick(){
			
			document.getElementById("hidden-first").disabled=true;
			
		}
		 */
		
		</script>
	</head>
	<body>
<%-- 	<%
	
		out.println("The username value is "+request.getParameter("username"));
		if(request.getParameter("username")==null){
			
			response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	
		}
		

	
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
        
        
		<form method="post"><div class="page-name">Cart items</div>
		
		            <input type="hidden" name="username" value="${name}">
		            
		            <input type="hidden" name="reversePayment" value="${reverse}">
		            
		             <c:set var="reversePayment" value="${reverse}"/>
			
<%-- 			<c:choose>
			<c:when test="${ tempSizelow==1}">
				 --%>	
		
		
		<c:choose>
		
			<c:when test="${blockAllTable=='blockAllTable'}">
			
				<center><div class="NextEmpty"><p>No items in Cart</p></div></center>
			
			
			</c:when>
			<c:when test="${reversePayment == 'Refund'}">
			
				<center><div class="NextEmpty"><p>Amount will be Refund Please Return to Cart Page</p></div></center>
			
			
			</c:when>
			
			
			
			<c:otherwise>
			<center><div class="table-box">
				<div class="cart-button">
		
		<%-- 
		<div class="textBoxError">${textBoxError}</div>
		<div class="paymentText">${payment}</div> --%>
		
		<!-- <input type="hidden" id="hidden-payment" name="paymentButton" value="pay" disabled="disabled"> -->
		 <button type="submit" id="cart-button" name="paymentButton" value="payment" disabled="disabled" onClick="paymentdupDis()">Payment</button>  
		 
		 <!-- <form action="/payment" > 
	  		<button type="submit" id="cart-button" name="paymentButton" value="payment" disabled="disabled" onClick=paymentdupDis>Payment</button>
		</form>  -->
			
			<%-- <form name="submitForm4" method="POST" action="/wildfly-kitchensink-jsp/payment">
	            <input type="hidden" name="username" value="${name}">
	            <li><a type="submit" id="payment" name="paymentButton" value="payment" disabled="disabled" onClick=paymentdupDis
	            href="javascript:document.submitForm4.submit()">Payment</a></li>
	            </form>  --%>
			 
		</div>
			<div class="cart-table">
			<table>
					<thead>
                        <tr>
                            <th class="col-select">Select</th>
                            <th class="col-name">Name</th>
                            <th class="col-price">Price</th>
                            <th class="col-quantity">Quantity</th>
                        </tr>
                   </thead>
					<tbody>
					  <c:forEach items="${members}" var="member">
							  <c:set var="a" value="1"/>
								
								<tr><!-- <td><input type="radio" name="adding" id="adding" onclick="add()" ></td> -->									
								
								<c:forEach items="${member}" var="mem">
									<c:if test="${a == 1}">
									<td><input type="radio" name="adding" value="${mem}" id="adding" onclick="add()" ></td>
									    <input type="hidden" name="Order_Id" value="${order}">
									    <input type="hidden" name="Status" value="${status}">
									    
		            
										<%-- <td><c:out value="${mem}"/></td> --%>
										
									 </c:if>
									<c:if test="${a == 2}">
										<td><c:out value="${mem}"/></td>
										
									 </c:if>		
									 <c:if test="${a == 3}">
									<%--  <input type="hidden" name="orderId" value="${mem}"> --%>
									<td><c:out value="${mem}"/></td>
										
									 </c:if>
									 <%-- <c:if test="${a == 4}">
									 
										<td><c:out value="${mem}"/></td>
									 </c:if> --%>
									 <c:set var="a" value="${a+1}"/>
									 </c:forEach>
									 <td><input type="number" id="quantity-text" name="Quantity" value="quantity"></td>
								</tr>
								
							</c:forEach>

					</tbody> 
				</table>
		</div>
		
					<div class="pagination">
											<input type="hidden" name="tableStart" value="${start}">  <%-- ${manufacturerSize}  ${maxTableSize} --%>
							<c:choose>
							
							
								<c:when test="${blockAll=='sufficient'}">
											<button id="first-button" name="firstButton" value="First" disabled="disabled">First</button>
											<button id="Previous-button" name="firstButton" value="Previous" disabled="disabled">Previous</button>
											<button id="Next-button" name="firstButton" value="Next" disabled="disabled">Next</button>
											<button id="last-button" name="firstButton" value="Last" disabled="disabled">Last</button>
								
								</c:when>
							
							
								<c:when test="${start==0}">
									
											<button id="first-button" name="firstButton" value="First" disabled="disabled">First</button>
											<button id="Previous-button" name="firstButton" value="Previous" disabled="disabled" >Previous</button>
											<button id="Next-button" name="firstButton" value="Next">Next</button>
											<button id="last-button" name="firstButton" value="Last">Last</button>
								
								</c:when>
								
								<c:when test="${start+maxTableSize>=manufacturerSize}">
											<button id="first-button" name="firstButton" value="First" >First</button>
											<button id="Previous-button" name="firstButton" value="Previous" >Previous</button>
											<button id="Next-button" name="firstButton" value="Next" disabled="disabled">Next</button>
											<button id="last-button" name="firstButton" value="Last" disabled="disabled">Last</button>
								
								</c:when>
								
								
								
								
								<c:otherwise>
									
										<button id="first-button" name="firstButton" value="First" >First</button>
										<button id="Previous-button" name="firstButton" value="Previous" >Previous</button>
										<button id="Next-button" name="firstButton" value="Next">Next</button>
										<button id="last-button" name="firstButton" value="Last">Last</button>
								
								</c:otherwise>
							</c:choose>

				
				
				</div>
					
			
		
			</div>
			</center>
			
			</c:otherwise>
		
		
		
		</c:choose>
		
		
		
			
			
			
			
			
			
			
			
				
	</form>

	</body>




</html>