<html>
<head>
<title>First Web Application</title>
</head>
<body>
  <center>
  <h1><font color="blue">SIGN IN</font></h1><hr /><br>
  <form method="post">
   Name:<br><input type="text" name="name"/>
   <br>
   <br>
   Address:<br> <input type="text" name="address"/>
   <br>
   <br>
   <input name ="SIGN IN"  value ="SIGN IN" type="submit"/>
   <br>
   <u><h3><font color="blue">Forgot Password?</font></h3></u>
 
    <font color="red">${ errorMessage}</font>
   </form>
   <br>
   
   <form action="/NewUser">
     <hr>
   <h3>New User</h3>
   <input name="SIGN UP" value="SIGN UP" type="submit"/>
   </form>
   </center>
</body>
</html>