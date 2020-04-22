



  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Browser Items</title>
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
       <style><%@include file="/resources/css/browsecss.css"%></style>               
        <script type="text/javascript">	
		function preback(){window.history.forward();}
		setTimeout("preback()",0);
		window.onunload=function(){null};
	function disableall() 
	{	
        document.getElementById("max").disabled = true;
        document.getElementById("min").disabled = true;/* 
        document.getElementById("button").disabled = false; */
        document.getElementById("mySelect").disabled = true; 
    }
	function enableprice()
	{		
		document.getElementById("mySelect").disabled = true; 
        document.getElementById("max").disabled = false;
        document.getElementById("min").disabled = false;
	}
	function enable() 
	{		
         document.getElementById("max").disabled = true;
         document.getElementById("min").disabled = true;
         document.getElementById("mySelect").disabled = false; 
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
	            <!-- <input type="hidden" name="username" value="null"> -->
	            <li><a href="javascript:document.submitForm2.submit()">Logout</a></li>
	            </form>
            </div>
            <label class="user">${name}</label>
<form method="POST"> 

            <input type="hidden" name="username" value="${name}">
        </header>
        </div>

				<div class="selector">
		<%-- <c:choose>
                                  <c:when test="${button=='List by Manufacturer' }"> --%>
                                  <div class="col-xs-6">
                                  <input type="hidden" name="radioButtonValue" value="${radioButtonValueTextBox}"> 
                                 <input type="hidden" name="categoryValue" value="${category}"> 
                                  
                                 <!--  disableall() -->
                             	<c:choose>
                             		<c:when test="${radioButtonValueTextBox=='Manufacturer'}">
                             		
                             				   <input type="radio" id="r1" name="rdbutton"  value="All" onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6">
                                    <input type="radio" id="r2" checked name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
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
                                <div class="dropdown" >
                                    <input type="radio" id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                    			  Max:
                                                  <input id="max" name="text2" type="number" disabled="disabled" selected value="${Max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" name="text1" type="number" disabled="disabled" selected value="${Min}" onkeypress="return onlyNumbers()">
  
                                </div> 
                            </div> 		
                            
                         		</c:when>                           		
                             		<c:when test="${radioButtonValueTextBox=='Price'}">                           		
                             		   <input type="radio" id="r1" name="rdbutton"  value="All" onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" disabled="disabled" id="mySelect" onchange="selectedItemFn()" >
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
                                <div class="dropdown" >
                                    <input type="radio" checked id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                    			  Max:
                                                  <input id="max"  name="text2" type="number"  selected value="${Max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min"  name="text1" type="number" selected value="${Min}" onkeypress="return onlyNumbers()">
                                   <br> 
                                   <div class="error"> ${error}</div>
                                </div> 
                            </div> 
                             		
                             		</c:when>
                             	
                             		<c:otherwise>
                             		
                             		   <input type="radio" checked id="r1" name="rdbutton"  value="All" onclick="disableall()"><label for="all">All</label><br><br>
                            </div>                            
                             <div class="manufacturer">
                                <div class="col-xs-6">
                                    <input type="radio" id="r2" name="rdbutton" value="List by Manufacturer" onclick="enable()"><label for="manufacturer">Manufacturer</label>&nbsp;&nbsp; 
                                    <select name="category" disabled="disabled" id="mySelect" onchange="selectedItemFn()" >
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
                                <div class="dropdown" >
                                    <input type="radio"  id="r3" name="rdbutton" value="List by Price" onclick="enableprice()" ><label>PriceRange: </label>
                                    			  Max:
                                                  <input id="max" disabled="disabled" name="text2" type="number"  selected value="${Max}" selected onkeypress="return onlyNumbers()">
                                                  Min:
                                                  <input id="min" disabled="disabled" name="text1" type="number" selected value="${Min}" onkeypress="return onlyNumbers()">                                 
                                </div> 
                            </div>                         		
                             		</c:otherwise>                         	
                             	</c:choose>                                                             
     						<center>
                              <div class="apply"> 
                                  <input type="submit" id="submit" name="man_button" value="Apply" onclick="click()">
                              </div> 
                            </center>                                         
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
                      
                      
                      <c:forEach items="${members}" var="member">
							  <c:set var="a" value="1"/>
								
								<tr>
								<td><input type="radio" name="adding" value= ${i.getId()} id="adding" onclick="add()"></td>									
								
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
									 <c:set var="a" value="${a+1}"/>
									 </c:forEach>
								</tr>							
							</c:forEach>
                      </tbody>                         
                                                  
                  </table>
                   </center> <br><br> 
                   
                   
                   
                 <div class="forward">
       				<center>
				<div class="pagination">
											<input type="hidden" name="tableStart" value="${start}"><%--  ${manufacturerSize}  ${maxTableSize} --%>
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
       </div>
                <div id="result"></div> 
            </div>
             </div>
              </form>
             </div>           
	</body>
</html>