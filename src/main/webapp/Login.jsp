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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/resources/css/screen2.css"%></style>
<title>registrationPage.jsp</title>

		<script type="text/javascript">
		function preback(){window.history.forward();}
		setTimeout("preback()",0);
		window.onunload=function(){null};
		</script>
</head>
<body background="blue">


	<div class="loginbox">
	   <IMG SRC="<%=request.getContextPath()%>/resources/gfx/avatar.png" class="avatar">  
    <h1>Login Here</h1>
    <form id="reg" action="BrowseItems" method="GET">
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
</body></html>
