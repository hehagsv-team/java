<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Order Details</title>

<!-- <link rel="stylesheet" type="text/css" href="resource/css/style.css"> -->
<style><%@include file="/resources/css/style.css"%></style>

		<script type="text/javascript">
		function preback(){window.history.forward();}
		setTimeout("preback()",0);
		window.onunload=function(){null};
		</script>
</head>
<body background="blue"><!-- 
<form id="reg" action="orders" method="GET"> -->
        <div class="container">
            <header>
			<div class="center-align">Shopping Cart</div>
			<ul class="right-align">
					
			<form name="submitForm1" method="POST" action="/wildfly-kitchensink-jsp/BrowseItems">
            <li><a href="javascript:document.submitForm1.submit()">Home</a></li>
			<input type="hidden" name="username" value="${name}">
			</form>
			
			
			   <form name="submitForm3" method="POST" action="/wildfly-kitchensink-jsp/orders">
	            <input type="hidden" name="username" value="${name}">
	            <li><a href="javascript:document.submitForm3.submit()">Orders</a></li>
	            </form>
	            
			<form name="submitForm" method="POST" action="/wildfly-kitchensink-jsp/cart.do">
            <li><a href="javascript:document.submitForm.submit()">Cart</a></li>
			<input type="hidden" name="username" value="${name}">
			</form>        
               			             
            </ul>          
            <div class="right"> 
                <!-- <a href="login">logout</a> -->
                 <form name="submitForm2" method="POST" action="/wildfly-kitchensink-jsp/LogoutServlet">
	            <input type="hidden" name="username" value="null">
	            <li><a href="javascript:document.submitForm2.submit()">Logout</a></li>
	            </form>
            </div>
            <label class="user">${name}</label>
<form method="POST" action="/wildfly-kitchensink-jsp/orders"> 

            <input type="hidden" name="username" value="${name}">
        </header>
        </div>
 <br>
  <br>   
 <div class="order">&nbsp;&nbsp;&nbsp; Order Details</div><br><br>
<br>
<br>

<c:choose>

	<c:when test="${blockAllTable=='blockAllTable'}">
	
		<center><div class="NextEmpty"><p>No orders yet</p></div></center>
	
	
	
	
	</c:when>

	<c:otherwise>
		<center>
<div class="orderstable">
			<table>
	
			<tr id="color1">
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Order_Id</th>
				<th>Ordered_Date</th>
				<th>Delivered_Date</th>
				<th>Shipping_Status</th>
			</tr>
			<c:forEach items="${members}" var="member">
			  <c:set var="a" value="1"/>
				
				<tr>
				<c:forEach items="${member}" var="mem">
					<c:if test="${a == 1}">
						<td><c:out value="${mem}"/></td>
					 </c:if>
					<c:if test="${a == 2}">
						<td><c:out value="${mem}"/></td>
					 </c:if>		
					 <c:if test="${a == 3}">
						<td><c:out value="${mem}"/></td>
					 </c:if>
					 <c:if test="${a == 4}">
						<td><c:out value="${mem}"/></td>
					 </c:if>
					 <c:if test="${a == 5}">
						<td><c:out value="${mem}"/></td>
					 </c:if>		
					 <c:if test="${a == 6}">
						<td><c:out value="${mem}"/></td>
					 </c:if>
					 <c:if test="${a == 7}">
						 <c:choose>
		         			
						    <c:when test = "${mem=='D'}">
						        <td>Delivered</td>
						    </c:when>
						    <c:when test = "${mem=='S'}">
						        <td>Shipped</td>
						    </c:when>
						     <c:when test = "${mem=='R'}">
						        <td>Returned</td>
						    </c:when>
						     <c:when test = "${mem=='U'}">
						        <td>Undelivered</td>
						    </c:when>
						    <c:otherwise>
						    	<td>In-Transit</td> 
						    </c:otherwise>
					  	</c:choose>
						<%-- <td>
						<c:out value="${mem}"/></td> --%>
					 </c:if>
					 <c:set var="a" value="${a+1}"/>
				</c:forEach>
				</tr>
	
			</c:forEach>
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
			</center>
		
	
	
	</c:otherwise>


</c:choose>


</form>
</body>
</head>
</html>