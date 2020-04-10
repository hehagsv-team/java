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
			<table>${no}
	
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
				 </center>
				 </div><br><br>
				 <div class="forward">
				 <center>
				 		<c:choose>
				 			<c:when test = "${inc == -1}">
						      	 <center><div class="EmptyMessage">No Items in the Orders</div></center>
						    </c:when>
		         			<c:when test = "${inc <= 1}">  <!-- p-1 -->
						       <input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" onchecked>
								<input type="submit" id="b1" name="navButton" value="previous" onclick="hbDisable2()" disabled="disabled">
								<input type="submit" id="b1" name="navButton" value="next" onclick="hbDisable3()"  >
								<input type="submit" id="b1" name="navButton" value="last" onclick="hbDisable4()" >
						    </c:when>
						    <c:when test = "${inc >= count - 2}">
						       <input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" onchecked>
								<input type="submit" id="b1" name="navButton" value="previous" onclick="hbDisable2()" >
								<input type="submit" id="b1" name="navButton" value="next" onclick="hbDisable3()" disabled="disabled" >
								<input type="submit" id="b1" name="navButton" value="last" onclick="hbDisable4()" >
						    </c:when>
						    
						    <c:otherwise>
						    	<input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" onchecked>
								<input type="submit" id="b1" name="navButton" value="previous" onclick="hbDisable2()" >
								<input type="submit" id="b1" name="navButton" value="next" onclick="hbDisable3()"  >
								<input type="submit" id="b1" name="navButton" value="last" onclick="hbDisable4()" >
						    	
						    </c:otherwise>
					  	</c:choose>
				 </center>
				 </div>

</form>
</body>
</head>
</html>
