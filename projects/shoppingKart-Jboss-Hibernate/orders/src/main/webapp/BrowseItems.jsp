
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Browser Items</title>
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/resource/css/style3.css">
               
        <script>	
	function disableall() 
	{
		
        document.getElementById("max").disabled = true;
        document.getElementById("min").disabled = true;
        document.getElementById("button").disabled = false;
        document.getElementById("mySelect").disabled = true; 
        document.getElementById("submit").disabled = false; 
        
		document.getElementById("h1").disabled = false;
		document.getElementById("h2").disabled = false;
		document.getElementById("h3").disabled = false;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
	}
	function enableprice()
	{		
		document.getElementById("mySelect").disabled = true; 
        document.getElementById("max").disabled = false;
        document.getElementById("min").disabled = false;
        document.getElementById("button").disabled = false;
        document.getElementById("submit").disabled = false; 
    
		document.getElementById("h1").disabled = true;
		document.getElementById("h2").disabled = true;
		document.getElementById("h3").disabled = false;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
		/*document.getElementById("mb1").disabled=true;
		 document.getElementById("pb1").disabled=false; */

	}
	function enable() 
	{		
		 document.getElementById("submit").disabled = false; 
         document.getElementById("max").disabled = true;
         document.getElementById("min").disabled = true;
         document.getElementById("button").disabled = false;	
         document.getElementById("mySelect").disabled = false; 
       
		document.getElementById("h1").disabled = false;
		document.getElementById("h2").disabled = false;
		document.getElementById("h3").disabled = true;
		document.getElementById("rb").disabled = true;
		document.getElementById("mb").disabled = true;
	}
	function onlyNumbers(evt) 
	{
        document.getElementById("submit").disabled = false;
        document.getElementById("mb").disabled =true;
		var e = event || evt;
		var charCode = e.which || e.keyCode;
		if (charCode > 31 && (charCode<48 || charCode>57))
			return false;
		return true;
	}
	function hbDisable1()
	{
		document.getElementById("b2").disabled = true;
		document.getElementById("b3").disabled = false;
		document.getElementById("b4").disabled = false;
		document.getElementById("hb1").disabled = true;
		document.getElementById("mb").disabled = false;
		document.getElementById("button").disabled = false;
		
		
		
		
	}
	function hbDisable2()
	{
	
		document.getElementById("b3").disabled = true;
		document.getElementById("b2").disabled = false;
		document.getElementById("b1").disabled = false;
		document.getElementById("hb1").disabled = true;
		document.getElementById("mb").disabled = false;
		document.getElementById("button").disabled = false;
	}
	function hbDisable4()
	{
		document.getElementById("b2").disabled = false;
		document.getElementById("b1").disabled = false;
		document.getElementById("b4").disabled = false;
		document.getElementById("hb1").disabled = true;
		document.getElementById("mb").disabled = false;
		document.getElementById("button").disabled = false;
	}
	function hbDisable3()
	{
		document.getElementById("b1").disabled = false;
		document.getElementById("b3").disabled = false;
		document.getElementById("b4").disabled = false;
		document.getElementById("hb1").disabled = true;
		document.getElementById("mb").disabled = false;
		document.getElementById("button").disabled = false;
	}
	
	function ApplyEnable(){
		document.getElementById("mb").disabled = false;
		document.getElementById("button").disabled = true;
		document.getElementById("itemTextId").text= false; 
	}
	
	function click(){
		document.getElementById("hb1").disabled = false;
		document.getElementById("button").disabled = false;
		
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
	function fun()
	{
		var mySelect = document.getElementById("mySelect").value;
		console.log('value of the selected sdthts item ' + mySelect);
			return mySelect;
	}
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
		<c:choose>
                                  <c:when test="${button=='List by Manufacturer' }">
                                         <div class="col-xs-6">
                                <input type="radio" id="r1" name="rdbutton"  value="All" onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6" disabled="disabled">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" checked onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" id="mySelect" onchange="selectedItemFn()" >
                                     <c:forEach items="${manu}" var="option">
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
                                   </select><br><br>
                                </div>
                              </div>
                              
                                 
                              <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                                    <input type="radio" id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                    <c:choose>
                                       <c:when test="${max>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:when test="${min>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:otherwise>
                                              Max:
                                                  <input id="max" name="text2" type="number"  selected value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       
                                       </c:otherwise>
                                    
                                    </c:choose>
                                    
                                </div> 
                            </div> 
                                  
                                  
                                  </c:when>
                                         
                                  
                                  <c:when test="${button=='All'}">
                                                       <div class="col-xs-6">
                                <input type="radio" id="r1" name="rdbutton"  value="All" checked onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6" disabled="disabled">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" id="mySelect" onchange="selectedItemFn()" >
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
                                   </select><br><br>
                                </div>
                              </div>
                              
                                 
                              <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                                    <input type="radio" id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                     <c:choose>
                                       <c:when test="${max>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:when test="${min>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:otherwise>
                                              Max:
                                                  <input id="max" name="text2" type="number"  selected value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       
                                       </c:otherwise>
                                    
                                    </c:choose>
                                    
                                </div> 
                            </div> 
                                  
                                  </c:when>
                                  
                                  <c:when test="${button=='List by Price'}">
                                                       <div class="col-xs-6">
                                <input type="radio" id="r1" name="rdbutton"  value="All" onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6" disabled="disabled">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" id="mySelect" onchange="selectedItemFn()" >
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
                                   </select><br><br>
                                </div>
                              </div>
                              
                                 
                              <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                                    <input type="radio" id="r3" name="rdbutton" checked value="List by Price" onclick="enableprice()" selected><label>PriceRange: </label>
                                    <c:choose>
                                       <c:when test="${max>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="${max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" value="${min}" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:when test="${min>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number"  value="${max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="${min}" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:otherwise>
                                              Max:
                                                  <input id="max" name="text2" type="number"  selected value="${max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" selected value="${min}" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       
                                       </c:otherwise>
                                    
                                    </c:choose>
                                    
                                </div> 
                            </div> 
                                  
                                  </c:when>
                                  
                                  <c:otherwise>
                                                <div class="col-xs-6">
                                <input type="radio" id="r1" name="rdbutton"  value="All" checked onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6" disabled="disabled">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" id="mySelect" onchange="selectedItemFn()" disabled="disabled">
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
                                   </select><br><br>
                                </div>
                              </div>
                              
                                 
                              <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                                    <input type="radio" id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                   
                                    
                                    <c:choose>
                                       <c:when test="${max>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number" disabled="disabled" value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number"disabled="disabled" value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:when test="${min>1}">
                                               Max:
                                                  <input id="max" name="text2" type="number" disabled="disabled" value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number"disabled="disabled" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       </c:when>
                                       <c:otherwise>
                                              Max:
                                                  <input id="max" name="text2" type="number" disabled="disabled" selected value="1" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number"disabled="disabled" selected value="0" onkeypress="return onlyNumbers()">
                                       <br><br>
                                       
                                       </c:otherwise>
                                    
                                    </c:choose>
                                    
                                </div> 
                            </div> 
                                  
                                         
                                  </c:otherwise>
                                  
                                  
                           </c:choose>

				
                            <%-- <div class="col-xs-6">
                                <input type="radio" id="r1" name="rdbutton"  value="All" checked onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6" disabled="disabled">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" id="mySelect" onchange="selectedItemFn()" disabled="disabled">
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
                                   </select><br><br>
                                </div>
                              </div>
                              
                                 
                              <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                                    <input type="radio" id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                    Max:
                                    <input id="max" name="text2" type="number" disabled="disabled" value="1" onkeypress="return onlyNumbers()">
                                    Min:
                                    <input id="min" name="text1" type="number"disabled="disabled" value="0" onkeypress="return onlyNumbers()">
                                    <br><br>
                                </div> 
                            </div>  --%>
                        <center>
                              <div class="apply"> 
                                  <input type="submit" id="submit" name="man_button" value="Apply" onclick="click()" disabled="disabled">
                              </div> 
                            </center>
                            
            <!-- <div class="selector">
				    <div class="col-xs-6">  
                <input type="radio" id="r1" name="rdbutton" value="all" onclick="disableall()"><label for="all">All</label><br><br>
             		</div>
              <div class="maufacturer">  
               <div class="col-xs-6" disabled="disabled">
                <input type="radio" id="r2" name="rdbutton" value="View by Manufacturer" onclick="enable()"><label for="all">View by Manufacturer</label>
                 <select name="filter" id="filter" onchange="selectedItemFn()" disabled="disabled"><br><br>
                 </select>
                 </div>
                 </div>
                 <div class="pricerange"> 
                                <div class="dropdown" disabled="disabled">
                <input type="radio" id="r3" name="rdbutton" value="View by Price Range" onclick="disableprice()"><label for="all">View by Price Range</label><br>
                Max:
                <input id="Input1" type="number" onkeypress="return onlyNumbers()" disabled="disabled" >
                Min:
                <input id="Input2" type="number" onkeypress="return onlyNumbers()" disabled="disabled" ><br><br>
                </div>
                </div> -->
                <!-- <div class="select" disabled="disabled"><br>
                    <div class="change">
                        <input type="radio" id="r4" name="rdbutton" value="pricerange"><label for="pricerange">PriceRange</label>
                         <label for="min" >Min:</label>
                        <input id="Input1" type="text" name="text1" onkeypress="return onlyNumbers()" disabled="disabled">
                        <label for="max">Max:</label>
                        <input id="Input2" type="text" name="text2" onkeypress="return onlyNumbers()" disabled="disabled">
                    </div>
                </div> -->
                
                <input type="hidden" id="name" name="name" value="${name}">
					<input type="hidden" id="h1" name="text1" value="${min}" size="3"maxlength="1" disabled="disabled"> > 
					<input type="hidden" id="h2" name="text2" value="${max}" size="3" maxlength="1" disabled="disabled"> > 
					<input type="hidden" id="h3" name="category" value="${category}" disabled="disabled"> >
					<input type="hidden" id="hb1" name="navButton" value="first">
					<input type="hidden" id="mb" name="man_button" value="Apply"> >
					<input type="hidden" id="in" name="currentIndex" value="1">
					<input type="hidden" id="rb" name="rdbutton" value="${button}" disabled="disabled">
					<input type="hidden" name="idName" id="idName" value=0> 		
					
					<div class="text-error">${error_text}</div>
                <!-- <div class="filter"><br>                                                                                                                    
                                                          
                </div>  -->                                     										
            <div class="ItemsDisplay">
                <div class="right-side">
                
              		<div class="itemText" id="itemTextId">${itemAdd}
              		</div>
                    <input type="submit" id="addbutton" name="add_tocart" value="Add To Cart" disabled="disabled" onclick="ApplyEnable()">
                    <input type="hidden" name="add_tocart" id="button" value="reverse" >
                    
                </div>
                
               
            
            <div class="table">
               <center>   <table>
                    <thead>
                      <tr>
                        <th class="col-select">Select</th>
                        <th class="col-name">Name</th>
                        <th class="col-price">Price</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${list}" var="i">						
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
                   </center> <br><br> 
                   
                   
                   
                 <div class="forward">
       				<center>
				<div class="pagination">
					<!-- <input type="submit"id="first-button" name="navButton" value="First"> -->
					
					<c:choose>
					
						<c:when test="${rowRestrict>1}">
							<input type="submit"id="first-button" id="b1" name="navButton" value="First" disabled="disabled"  onclick="hbDisable1()">
							<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous" disabled="disabled"  onclick="hbDisable3()">
							<input type="submit"id="Next-button" id="b3" name="navButton" value="Next" disabled="disabled"  onclick="hbDisable4()">
							<input type="submit"id="last-button" id="b4" name="navButton" value="Last" disabled="disabled"  onclick="hbDisabl2()">
						</c:when>
					
					
					
						<c:when test="${buttonClicked=='First' || buttonClicked=='first,First'}">
							<input type="submit"id="first-button" id="b1" name="navButton" value="First"  onclick="hbDisable1()">
						<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous" disabled="disabled"  onclick="hbDisable3()">
						
						<c:choose>
							<c:when test="${nextValueBegin>1 }">
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next" isabled="disabled"  onclick="hbDisable4()">
							</c:when>
							
							<c:otherwise>
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next"  onclick="hbDisable4()">
							</c:otherwise>
						</c:choose>
						
						<input type="submit"id="last-button" id="b4" name="navButton" value="Last"  onclick="hbDisable2()">
						
						</c:when>
						
						
						<c:when test="${buttonClicked=='Last' || buttonClicked=='first,Last'}">
							<input type="submit"id="first-button" id="b1" name="navButton" value="First">
						
						<c:choose>
						
							
							<c:when test="${nextValueBegin>1 }">
									<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous"  disabled="" onclick="hbDisable1()">
							</c:when>
							
							<c:otherwise>
								<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous" onclick="hbDisable3()">
							</c:otherwise>
						</c:choose>
						<input type="submit"id="Next-button" id="b3" name="navButton" value="Next" disabled="disabled"  onclick="hbDisable4()">
						<input type="submit"id="last-button" id="b4" name="navButton" value="Last"  onclick="hbDisable2()">
						</c:when>
						
						<c:when test="${buttonClicked== 'Next' || buttonClicked=='first,Next' || nextValueBegin>1}">
							<input type="submit"id="first-button" id="b1" name="navButton" value="First" onclick="hbDisable1()">
							<c:choose>
							
								<c:when test="${nextValue>-1 || nextValueBegin>1}">
								<input type="submit"id="Previous-button" name="navButton" id="b2" value="Previous"  onclick="hbDisable3()">				
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next" disabled="disabled"  onclick="hbDisable4()">
								</c:when>
								
								<c:otherwise>
								<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous"  onclick="hbDisable3()">				
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next"  onclick="hbDisable4()">
								</c:otherwise>
								
							</c:choose>
							<input type="submit"id="last-button" id="b4" name="navButton" value="Last"  onclick="hbDisable2()">
							
						</c:when>
						
						<c:when test="${buttonClicked=='Previous' || buttonClicked=='first,Previous'}">
							<input type="submit"id="first-button" id="b1" name="navButton" value="First"  onclick="hbDisable1()">
							<c:choose>
							
								<c:when test="${previousValue>5}">
								<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous"  onclick="hbDisable3()">					
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next"  onclick="hbDisable4()">
								</c:when>
								
								<c:otherwise>
								<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous" disabled="disabled"  onclick="hbDisable3()">					
								<input type="submit"id="Next-button" id="b3" name="navButton" value="Next"  onclick="hbDisable4()">
								</c:otherwise>
								
							</c:choose>
						<input type="submit"id="last-button" id="b4" name="navButton" value="Last"  onclick="hbDisable2()">
							
						</c:when>
				
						<c:otherwise>
							<input type="submit"id="first-button" id="b1" name="navButton" value="First"  onclick="hbDisable1()">
						<input type="submit"id="Previous-button" id="b2" name="navButton" value="Previous" disabled="disabled"  onclick="hbDisable3()">				
						<input type="submit"type id="Next-button" id="b3" name="navButton" value="Next"  onclick="hbDisable4()">
						<input type="submit"id="last-button" id="b4" name="navButton" value="Last"  onclick="hbDisable2()">
						
						</c:otherwise>
					</c:choose>
						<!-- <input type="submit"id="last-button" name="navButton" value="Last"> -->
				</div>
			</center>
       </div>
 
          
                   
                   
                   
                   
                   
                   
               <%--            
                <div class="forward">
                   <center> 
	                    <input type="submit" id="b1" name="navButton" value="first" onclick="hbDisable1()" checked>
	                    <input type="submit" id="b2" name="navButton" value="previous" onclick="hbDisable3()"> 
	                    <input type="submit" id="b3" name="navButton" value="next" onclick="hbDisable4()"> 
	                     <input type="submit" id="b4" name="navButton" value="last" onclick="hbDisable2()"> 
                    </center> 
                    
                </div>--%>
                <div id="result"></div> 
            </div>
             </div>
              </form>
             </div>           
            
       
   
	</body>
</html>

 