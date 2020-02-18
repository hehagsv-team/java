<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Browser Items</title>
<link rel="stylesheet" type="text/css" href="/resource/css/style3.css">
<script>
	function alert() {
		//window.alert("hello world");
		//   	 document.getElementById("demo22").innerHTML = "Hello World";.
		// 	 document.getElementById("input2").innerHTML = "Hello World";
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
	function onlyNumbers(evt) {
		var e = event || evt;
		var charCode = e.which || e.keyCode;
		if (charCode > 31 && (charCode<48 || charCode>57))
			return false;
		return true;
	}
	function hbDisable() {
		document.getElementById("hb1").disabled = true;
		document.getElementById("b2").disabled = false;
		document.getElementById("b3").disabled = false;

		document.getElementById("rb").disabled = false;
		document.getElementById("mb").disabled = false;
	}
	function hbDisable1() {
		document.getElementById("hb1").disabled = true;
		document.getElementById("b2").disabled = true;
		document.getElementById("b3").disabled = false;
		document.getElementById("rb").disabled = false;
		document.getElementById("mb").disabled = false;
	}
	function hbDisable2() {
		document.getElementById("hb1").disabled = true;
		document.getElementById("b3").disabled = true;
		document.getElementById("b2").disabled = false;
		document.getElementById("rb").disabled = false;
		document.getElementById("mb").disabled = false;
	}

	/*  var GLOBAL_selectedItem;
	function selectedItemFn() {   	
		
		console.log("Inside function functiondup");
		 var mySelect = document.getElementById ("mySelect").value;
		 GLOBAL_selectedItem = document.getElementById ("mySelect").value;
		console.log ('value of the selected item '+mySelect);
	// 		mySelect.options[selectElement.selectedIndex].value
	// 		var str = document.getElementById("category");

	     alert(mySelect.value);
	   
	    
	}  */
	function fun() {
		var mySelect = document.getElementById("mySelect").value;
		console.log('value of the selected sdthts item ' + mySelect);
		//		mySelect.options[selectElement.selectedIndex].value
		//		var str = document.getElementById("category");

		return mySelect;

	}
	function selectedItemFn() {
		console.log('value of the selected sdthts item '
				+ document.getElementById("mySelect").value);
		document.getElementById("h3").value = document
				.getElementById("mySelect").value;
		console.log('value of the hidden item h3='
				+ document.getElementById("h3").value);
	}
	/* function click(){
	 document.getElementById("h3").value=selectedItemFn(); 
	} */
</script>
</head>
<body>
<table class=top>
              <th><h2>Shopping Cart</h2></th>
             <th id="one"><h3>${name}<h3></th> 
              <th id="two"><li></li></th>             
       </table>
 
	<header>
<!-- 	<div class="left-align">
		<p>Shopping Cart</p>
	</div>  -->
	<div class="right-align">
		<li><a href=""><p>User
				<p></a></li>
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
					<!-- disabled="disabled" -->
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

					<input type="hidden" id="h1" name="text1" value="0" size="3"
						maxlength="10"> <input type="hidden" id="h2"
						name="text2" value="1" size="3" maxlength="10"> <input
						type="hidden" id="h3" name="category" value="LG">
					<input type="hidden" id="hb1" name="navButton" value="first">
					<input type="hidden" id="mb" name="man_button" value="Apply">
					<input type="hidden" id="in" name="currentIndex" value="1">
					<input type="hidden" id="rb" name="rdbutton" value="All">
					<!-- 			      <button id="pb1" onclick="check()" name="price_button" value="price_checker">check</button> 
 -->
					<div class="text-error">${error_text}</div>
				</div>
				<!-- disabled="disabled" -->
				<h3>
					Filter:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<select id="mySelect" name="category" onchange="selectedItemFn()"
						disabled="disabled">
						<c:forEach items="${man}" var="option">
<c:out value="${category}"/> <c:out value="${option.getName()}"/>

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
			<!-- 		</form>										-->
			<div class="ItemsDisplay">
				<div class="left-side">
					<p>select items: ${button_value}</p>
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
								<input type="hidden" name="currentIndex" value=${i.getRowNum()}>
								<td><input type="radio" name="" value=""></td>
								<td>${i.getId()}</td>
								<td>${i.getName()}</td>
								<td>${i.getPrice()}</td>
							</tr>

						</c:forEach>

					</table>
					<!-- <div class="forward">
                           <a href='' type="submit" id="b1" name="navButton" value="first" class="previous round" onclick="hbDisable1()" checked>&#8249;&#8249;</a>
                           <a href='' type="submit" id="b2" name="navButton" value="previous" class="previous round" onclick="hbDisable()">&#8249;</a>
                           <a href='' type="submit" id="b3" name="navButton" value="next" class="next round" onclick="hbDisable()">&#8250;</a>
                           <a href='' type="submit" id="b4" name="navButton" value="last" class="next round" onclick="hbDisable2()">&#8250;&#8250;</a>
                           </div>
			</div> -->
					<div class="forward">
						<input type="submit" id="b4" name="navButton" value="last"
							onclick="hbDisable2()"> <input type="submit" id="b3"
							name="navButton" value="next" onclick="hbDisable()"> <input
							type="submit" id="b2" name="navButton" value="previous"
							onclick="hbDisable()"> <input type="submit" id="b1"
							name="navButton" value="first" onclick="hbDisable1()" checked>
					</div>
		</form>
	</div>

	</div>

</body>
</html>