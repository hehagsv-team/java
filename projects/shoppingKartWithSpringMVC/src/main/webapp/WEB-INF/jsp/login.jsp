<html>
<head>
<title>First Web Application</title>
</head>
<body>
 
  SIGN IN<br>
  <form method="post">
   Name:<br><input type="text" name="name"/>
   <br>
   Address:<br> <input type="text" name="address"/>
   <br>
   <input name ="SIGN IN"  value ="SIGN IN" type="submit"/>
   <br>
    <font color="red">${ errorMessage}</font>
   </form>
</body>
</html>