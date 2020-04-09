<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Order Details</title>

<!-- <link rel="stylesheet" type="text/css" href="resource/css/style.css"> -->
<style><%@include file="/resources/css/style.css"%></style>

</head>
<body background="blue">
<form id="reg" action="orders" method="POST">
	<div class="container">
		<header>
		<div class="center-align">Shopping Cart </div>
		<ul class="right-align">
			<li><a href="BrowseItems" >Home</a></li>
			<li><a href="orders" >Orders</a></li>
			<li><a href="cart" >Cart</a></li>				             
		</ul>
	   
		<div class="right">
			
			<a href="login">logout </a> 

		</div>
		<%-- <label class="user">${username}</label> --%>
		<label class="user">User</label>

	</header>
	</div>
 <br>
  <br>
 <div class="order">&nbsp;&nbsp;&nbsp; Order Details</div><br><br>
<br>
<br>
<div class="orderstable">
	<center>
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
			
				
			<%-- <c:forEach items="${orders}" var="j">					 					
 			<tr id="color2">
				 <td>${j.getName()}</td> 
				<td>${j.getPrice()}</td> 
				<td>${j.getQuantity()}</td>
				<td>${j.getOrder_Id()}</td>
				<td>${j.getOrdered_Date()}</td>	
				<td>${j.getDeliver_Date()} </td>
				 <td>${j.getShipping_Status()} </td> 
				 <td>${j}</td> 
				<td>${j}</td> 
				<td>${j}</td>
				<td>${j}</td>
				<td>${j}</td>	
				<td>${j} </td>
				 <td>${j} </td>
				 </tr>
				 </c:forEach> --%>
				 </table>
				 </center>
				 </div><br><br>
				 <div>
				 <center>
				 			<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" onchecked>
							<input type="submit" id="b1" name="navButton" value="previous" onclick="hbDisable2()" >
							<input type="submit" id="b1" name="navButton" value="next" onclick="hbDisable3()" >
							<input type="submit" id="b1" name="navButton" value="last" onclick="hbDisable4()" >
							<%-- <c:choose>
		         			
						    <c:when test = "${navButton=='first'}">
						       <input type="text" name="inc" value=${inc}+2>
						    </c:when>
						       <c:when test = "${navButton=='previous'}">
						       <input type="text" name="inc" value=${inc}-2>
						    </c:when>
						        <c:when test = "${navButton=='next'}">
						       <input type="text" name="inc" value=${inc}+2>
						    </c:when>
						        <c:when test = "${navButton=='last'}">
						       <input type="text" name="inc" value=8>
						    </c:when>
						    <c:otherwise>
						    	<input type="text" name="inc" value=0>
						    </c:otherwise>
					  	</c:choose> --%>
				 </center>
				 </div>

<!-- <html>
<head>
<title>Order Details</title>
<link rel="stylesheet" type="text/css" href="/resource/css/style5.css">
<link rel="stylesheet" type="text/css" href="/resource/css/style4.css">
</head>
<body background="blue">
		<div class="header">
		  <div class="left-align">Shopping Cart</div>
			<div class="right-align">
				<a href="#">Logout</a>
				<a href="#">Username</a>
				<a href="#">Order</a>
				<a href="#">Cart</a>
				<a href="#">Home</a>
			</div>			
		 </div>
		
	</body> -->
<!-- <script>

function hbDisable3() {	
	
	document.getElementById("b3").disabled = false;	
}
function hbDisable4() {	
	document.getElementById("b2").disabled = false;	
}
function hbDisable1() {
	
	document.getElementById("b2").disabled = true;
	document.getElementById("b3").disabled = false;
}
function hbDisable2() {
	document.getElementById("b2").disabled = false;
	document.getElementById("b3").disabled = true;
}


</script>  -->
<!-- <body>
 <br>
  <br>
 <div class="order">&nbsp&nbsp&nbsp Order Details</div> -->

<%-- <form method="POST">

	<div class="orderstable">
	
	<c:choose>
		<c:when test="${tempLowPre==1}">
			<center>
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
				
			<c:forEach items="${orders}" var="j">					 					
 			<tr id="color2">
				<td>${j.getName()}</td> 
				<td>${j.getPrice()}</td> 
				<td>${j.getQuantity()}</td>
				<td>${j.getOrder_Id()}</td>
				<td>${j.getOrdered_Date()}</td>	
				<td>${j.getDeliver_Date()} </td>
				 
				<c:choose>
         			<c:when test = "${j.getShipping_Status()=='S'}">
				        <td>Shipped</td>
				    </c:when>
				         
				    <c:when test = "${j.getShipping_Status()=='D'}">
				        <td>Delivered</td>
				    </c:when>
				     <c:when test = "${j.getShipping_Status()=='R'}">
				        <td>Returned</td>
				    </c:when>
				     <c:when test = "${j.getShipping_Status()=='U'}">
				        <td>Undelivered</td>
				    </c:when>
				    <c:otherwise>
				    	<td>In-Transit</td> 
				    </c:otherwise>
				  </c:choose>
			</tr> 						 	
			</c:forEach>  									
		
	</table>
	</center>
	<input type="hidden" id="username" name="name" value="Ashok">	
	<br>
	<div class="forward">${noOrders}
	<center>
		
		<!-- input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" checked> -->
			<c:choose>
			<c:when test="${rowRestrict>1}">
							<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" disabled="disabled">
							<input type="submit" id="b1" name="navButton" value="previous" onclick="hbDisable1()" disabled="disabled">
							<input type="submit" id="b1" name="navButton" value="next" onclick="hbDisable1()" disabled="disabled">
							<input type="submit" id="b1" name="navButton" value="last" onclick="hbDisable1()" disabled="disabled">

						</c:when>
				
         			<c:when test = "${button=='last'}">
				       	<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" >
						<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()" >
						<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()" disabled="disabled">  
				        <input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()"> 
				    </c:when>	
				    			         				   
				     <c:when test = "${button=='previous'}">
				     	<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" >
				     		<c:choose>
								<c:when test="${prevValue>-1}">
									<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()" disabled="disabled">
									<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()">  
								
								</c:when>
								
								<c:otherwise> 
								
										<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()" >
										<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()">  
								
								</c:otherwise>
							</c:choose>
						<input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()"> 
				    </c:when>
				     <c:when test = "${button=='next'}">
						<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" checked>
							<c:choose>
								<c:when test="${NextValue>0}">
									<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()" >
									<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()"  disabled="disabled">  
								
								</c:when>
								
								<c:otherwise>
								
										<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()" >
										<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()">  
								
								</c:otherwise>
							</c:choose>
							<input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()"> 						
				    </c:when>
				    <c:otherwise>
				    	<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" checked>
						<input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()"  disabled="disabled" >
						<input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()" > 
						<input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()">  
				    </c:otherwise>
			</c:choose>
		<!-- <input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()">  -->
		</center>
		</div>
		</c:when>
		
		<c:otherwise>
		
			<br/>
							<center><div class="EmptyMessage">No Items in the Orders</div></center>
		
		</c:otherwise>
	
	
	</c:choose>
	
	</div>
	
					
</form> --%>
</form>
</body>
</head>
</html>