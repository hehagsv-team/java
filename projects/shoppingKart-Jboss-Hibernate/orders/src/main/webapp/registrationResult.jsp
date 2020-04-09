<%--
    JBoss, Home of Professional Open Source
    Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
    contributors by the @authors tag. See the copyright.txt in the
    distribution for a full listing of individual contributors.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet" type="text/css" href="resources/css/screen.css" />
 -->
 <style><%@include file="/resources/css/style.css"%></style>
 <title>Order Details</title>
</head>
<body>
<!-- <li><a href="register.do">.</a></li> -->
<form id="reg" action="" method="GET">
<h4>Order Details</h4>
<table class="simpletablestyle">
<thead>
<tr>
	<th>Name</th>
	<th>Price</th>
	<th>Quantity</th>
	<th>Order_Id</th>
	<th>Ordered_Date</th>
	<th>Delivered_Date</th>
	<th>Shipping_Status</th>
</tr>
</thead>
<tbody>
<c:forEach items="${orders}" var="j">
	<tr>
		<td><c:out value="${j.getName()}"/></td>
		<td><c:out value="${j.getPrice()}"/></td>
		<td><c:out value="${j.getQuantity()}"/></td>
        <td><c:out value="${j.getOrder_Id()}"/></td>
		<td><c:out value="${j.getOrdered_Date()}"/></td>
		<td><c:out value="${j.getDeliver_Date()} "/></td>
		<td><c:out value="${j.getShipping_Status()}"/></td>
	</tr>
</c:forEach>
</tbody>
</table>	
</form>
</body>
</html>