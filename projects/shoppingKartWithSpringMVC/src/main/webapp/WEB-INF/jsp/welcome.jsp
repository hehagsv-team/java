<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Browser Items</title>
    <link rel="stylesheet" type="text/css" href="/resource/css/style3.css">
     <script> 
     
     function alert()
     {
    	 //window.alert("hello world");
 //   	 document.getElementById("demo22").innerHTML = "Hello World";.
   // 	 document.getElementById("input2").innerHTML = "Hello World";
     }
    function disableall()
    {
    	document.getElementById("mySelect").disabled=true; 
    	document.getElementById("input1").disabled=true;
    	document.getElementById("input2").disabled=true;
    	document.getElementById("h1").disabled=false;
    	document.getElementById("h2").disabled=false;
    	document.getElementById("h3").disabled=false;

    	/* document.getElementById("mb1").disabled=false;
    	document.getElementById("pb1").disabled=false;*/  
	}
    function disableprice()
    {
    	document.getElementById("mySelect").disabled=true;
    	document.getElementById("input1").disabled=false;
    	document.getElementById("input2").disabled=false;
    	document.getElementById("h1").disabled=true;
    	document.getElementById("h2").disabled=true;
    	document.getElementById("h3").disabled=false;
    	/*document.getElementById("mb1").disabled=true;
    	 document.getElementById("pb1").disabled=false; */
    	
    }
    function enable()
    {
    	document.getElementById("mySelect").disabled=false;
    	document.getElementById("input1").disabled=true;
    	document.getElementById("input2").disabled=true;
    	document.getElementById("h1").disabled=false;
    	document.getElementById("h2").disabled=false;
    	document.getElementById("h3").disabled=true;
    	/*document.getElementById("mb1").disabled=false;
    	document.getElementById("pb1").disabled=false; */
    } 
    function onlyNumbers(evt)
    {
    	var e= event || evt;
    	var charCode=e.which || e.keyCode;
    	if(charCode>31 && (charCode<48 || charCode>57))
    		return false;
    	return true;
    }
     </script>  
</head>
<body>
	
	<header>	
		<div class="left-align">
			<p>Shopping Cart</p>
		</div>		
		<div class="right-align">
			<li><a href=""><p>User<p></a></li>
			<li><a href=""><h3>${name}<h3></a></li>
			<li><a href=""><input type="submit" name="" value="Logout"></a></li>
		</div>
	</header>	
	<div>
	<form method="POST">
		
<!--  onclick="disableall()" 
onclick="enable()"
onclick="disableprice()"-->
		<div class="selector">
		<div id="rates">
 			<li><input type="radio" checked name="rdbutton" id="r1" value="all" onclick="disableall()">All</li>
			<li><input type="radio" name="rdbutton" id="r2" value="manufacturer" onclick="enable()">View by Manufacturer</li>
			<li><input type="radio" name="rdbutton" id="r3" value="price" onclick="disableprice()">View by Price Range</li>
		</div>
  				<div class="text" disabled="disabled"><!-- disabled="disabled" -->
				<h3> Price Range: &nbsp&nbsp &nbsp&nbsp<!-- disabled="disabled" 
											disabled="disabled" -->
			 <small> Min:<input type="text"  value="0" name="text1" size="3" id="input1" maxlength="10"  onkeypress="return onlyNumbers()" disabled="disabled">
			   &nbsp&nbspMax:</small> <input type="text" value="1" name="text2" size="3" id="input2" maxlength="10" onkeypress="return onlyNumbers();" disabled="disabled">
			      &nbsp</h3>
			      
			     <input type="hidden" id="h1" name="text1" value="0" size="3"  maxlength="10"  >
			  <input type="hidden" id="h2" name="text2" value="1" size="3" maxlength="10" >
			  <input type="hidden" id="h3" name="category" value="LG">
<!-- 			      <button id="pb1" onclick="check()" name="price_button" value="price_checker">check</button> 
 -->			    <div class="text-error">${error_text}</div> 
				</div>	
			<!-- disabled="disabled" -->
			<h3>Filter:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<select id="mySelect" name="category" 
					onchange="functiondup()" disabled="disabled">
					<!-- <option>Manufacturer</option> 
                           <option value="1">Option 1</option> 
                           <option value="2">Option 2</option> 
                           <option value="3">Option 3</option> 
                           <option value="4">Option 4</option> 
                           <option value="5">Option 5</option> 
                           <option value="6">Option 6</option>  -->
					<c:forEach items="${man}" var="category">
						<option name="something" value="${category.getName()}">${category.getName()}
						</option>
					</c:forEach>
					
				</select>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
				<!-- <button id="mb1" name="man_button" value="man_checker" >click me</button>  -->
				<input type="submit" id="mb1" name="man_button" value="Apply"></h3>
		</div>
		</form>										
		<div class="ItemsDisplay">
			<div class="left-side">
				<p>select items</p>
			</div>
			<div class="right-side">
					<input type="submit" name="" value="Add To Cart">
			</div>
			<div class="table">
				<table>
					<tr id="color1">
						<th>Select</th>
						<th>id</th>
						<th>Name</th>
						<th>Price</th>
					</tr>
					<c:forEach items="${list}" var="i">
					<tr id="color2">
					
						<td><input type="radio" name="" value=""></td>
						<td>${i.getId()}</td>
						<td>${i.getName()}</td>
						<td>${i.getPrice()}</td>
					</tr>					
					</c:forEach>
				</table>
			</div>
			<div class="image1">
				<img src="/images/png/lefta.png">
				<img src="/images/png/righta.png">
			</div>			
		</div>
	
	</div>	

</body>
</html>