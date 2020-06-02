<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/resources/css/screen2.css"%></style>
<title>registrationPage.jsp</title>
</head>
<body background="blue">
	<div class="loginbox">
	  <IMG SRC="<%= request.getContextPath() %>\resources\gfx\avatar.png" class="avatar"> 
    <h1>Login Here</h1>
    <form id="reg" action="register.do" method="POST">
    	<p>Username:</p>
    	<input type="text" name="name" id=name  value="${users.name}" placeholder="Enter username">
        <input type="submit" id="register" name"  " value="login">  
         <p id="error">${errorMessage}</p>   
           
        <%-- <p>
            <label style="color: green;width: 100%;text-align: left;">${infoMessage}</label> 
        </p> --%>
        <%-- <p>
             <label style="color: red; width: 100%;text-align: left;">${errorMessage}</label>
        </p> --%>
    </form>
    </div>
</body>
</html>
