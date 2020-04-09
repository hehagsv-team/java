<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Browser Items</title>
<!-- <link rel="stylesheet" type="text/css" href="/resource/css/style3.css"> -->
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style3.css"> --%>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style3.css"/> --%>
<style><%@include file="/resources/css/style3.css"%></style>
	
<script>	
	
	function selectedItemFn()
	{
		console.log('value of the selected sdthts item '
				+ document.getElementById("mySelect").value);
		document.getElementById("h3").value = document
				.getElementById("mySelect").value;
		console.log('value of the text item h3='
				+ document.getElementById("h3").value);
		document.getElementById("submit").disabled =false;
		document.getElementById("mb").disabled =true;
	}
	function disableall() {
		document.getElementById("mySelect").disabled = true;
		document.getElementById("input1").disabled = true;
		document.getElementById("input2").disabled = true;
		document.getElementById("h1").disabled = false;
		document.getElementById("h2").disabled = false;
		document.getElementById("h3").disabled = false;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
		/* document.getElementById("mb1").disabled=false;
		document.getElementById("pb1").disabled=false;*/
	}
	function disableprice() {
		document.getElementById("mySelect").disabled = true;
		document.getElementById("input1").disabled = false;
		document.getElementById("input2").disabled = false;
		document.getElementById("h1").disabled = true;
		document.getElementById("h2").disabled = true;
		document.getElementById("h3").disabled = false;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
		/*document.getElementById("mb1").disabled=true;
		 document.getElementById("pb1").disabled=false; */

	}
	function enable() {
		document.getElementById("mySelect").disabled = false;
		document.getElementById("input1").disabled = true;
		document.getElementById("input2").disabled = true;
		document.getElementById("h1").disabled = false;
		document.getElementById("h2").disabled = false;
		document.getElementById("h3").disabled = true;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
		/*document.getElementById("mb1").disabled=false;
		document.getElementById("pb1").disabled=false; */
	}
	function add()
	{
		/*  document.getElementById("adding").disabled =false;  */
		/* document.getElementById("itemTextId").disabled =true; */
		document.getElementById("itemTextId").style.display = "text";
		document.getElementById("addbutton").disabled =false;
		document.getElementById("button").disabled =true;
/* 		document.getElementById("mb1").disabled =true;*/
 		document.getElementById("idName").value = null; 
		var ele = document.getElementsByName('adding'); 
		
        
        for(i = 0; i < ele.length; i++) 
        { 
            if (ele[i].checked)
            {
            document.getElementById("idName").value = ele[i].value;
            }
        } 		
	}
	
</script>               
</head>
    <body>
        <div class="container">
            <header>
			<div class="center-align">Shopping Cart</div>
			<ul class="right-align">
                <li><a href="BrowseItems.jsp" >Home</a></li>
                <li><a href="orders.jsp" >Orders</a></li>
                <li><a href="cart" >Cart</a></li>				             
            </ul>          
            <div class="right"> 
                <a href="login">logout</a>
            </div>
            <label class="user">${username}</label>
        </header>
        </div>
	<form method="POST"> 
				<div class="selector">
				<div id="rates">
					<li><input type="radio" name="rdbutton" id="r1" value="All"
						onclick="disableall()">All</li>
					<li><input type="radio" name="rdbutton" id="r2"
						value="List by Manufacturer" onclick="enable()">View by
						Manufacturer</li>
					<li><input type="radio" name="rdbutton" id="r3"
						value="List by Price" onclick="disableprice()">View by
						Price Range</li>

				</div>
				<div class="text" disabled="disabled">
					<h3>
						Price Range: &nbsp&nbsp &nbsp&nbsp
						<!-- disabled="disabled" 
											disabled="disabled" -->
						<small> Min:<input type="text" value="0" name="text1"
							size="3" id="input1" maxlength="10"
							onkeypress="return onlyNumbers()" disabled="disabled">
							&nbsp&nbspMax:
						</small> <input type="text" value="1" name="text2" size="3" id="input2"
							maxlength="10" onkeypress="return onlyNumbers();"
							disabled="disabled"> &nbsp
					</h3>
					<input type="hidden" name="order"  value="">
					<input type="hidden" id="h1" name="text1" value="${min}" size="3"maxlength="10"> 
					<input type="hidden" id="h2" name="text2" value="${max}" size="3" maxlength="10"> 
					<input type="hidden" id="h3" name="category" value="${category}">
					<input type="hidden" id="hb1" name="navButton" value="first">
					<input type="hidden" id="mb" name="man_button" value="Apply">
					<input type="hidden" id="in" name="currentIndex" value="1">
					<input type="hidden" id="rb" name="rdbutton" value="${button}">
					<input type="hidden" id="rb" name="name" value="${name}">
					<!-- <button id="pb1" onclick="check()" name="price_button" value="price_checker">check</button>-->
					<div class="text-error">${error_text}</div>
				</div>
				
				<h3>
					Filter:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<select id="mySelect" name="category" onchange="selectedItemFn()"
						disabled="disabled">
						<c:forEach items="${manu}" var="option">
					<%-- <c:out value="${category}"/> <c:out value="${option.getName()}"/> --%>

							<c:choose>
								<c:when test="${fn:contains(category, option.getName())}">
									<option name="something" value="${option.getName()}" selected>${option.getName()}</option>
								</c:when>
								<c:otherwise>
									<option name="something" value="${option.getName()}">${option.getName()}</option>
								</c:otherwise>
							</c:choose>

						</c:forEach>

					</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<!-- <button id="mb1" name="man_button" value="man_checker" >click me</button>  -->
					<input type="submit" id="mb1" name="man_button" value="Apply"
						onclick="click()">
					<!-- <input id="radio-hide" checked type="radio" name="rdbutton" id="r3" value="None" onclick="disableprice()"> -->
				</h3>
			</div>
			<div class="ItemsDisplay">
                <div class="right-side">
                
              		<div class="itemText" id="itemTextId">${itemAdd}
              		</div>
                    <input type="submit" id="addbutton" name="add_tocart" value="Add To Cart" disabled="disabled" onclick="ApplyEnable()">
                    <input type="hidden" name="add_tocart" id="button" value="reverse" >
                    
                </div>
                
               
            
            <div class="table">
               <table>
                    <thead>
                      <tr>
                        <th class="col-select">Select</th>
                        <th class="col-name">Name</th>
                        <th class="col-price">Price</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${items}" var="i">						
							<tr>
							 	<input type="hidden" name="currentIndex" value=${i.getRowNum()}>
								
								<td><input type="radio" name="adding" value= ${i.getId()} id="adding" onclick="add()"></td>									
								<td>${i.getName()}</td>
								<td>${i.getPrice()}</td>
<%-- 								<td>${i.get }</td>	 --%>																																																				
							</tr>	
                      </c:forEach>
                      </tbody>                         
                                                  
                  </table>
             </div>     
           </div>
	</form>
  </body>
</html>
