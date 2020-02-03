<html>
<head>
<title>Login Form Design</title>
    <link rel="stylesheet" type="text/css" href="/resource/css/style.css">
<body>
    <div class="loginbox">
    <img src="/images/png/avatar.png" class="avatar">
        <h1>Login Here</h1>
        <form method="POST">
            <p>Username</p>
            <input type="text" name="name" placeholder="Enter Username">
            <p>Address</p>
            <input type="text" name="address" placeholder="Enter Address">
            <input type="submit" name="" value="Login">
            <a href="#">Lost your password</a><br>
   			<a href="/NewUser">New User</a>
   			<p id="error">${errorMessage}<p>
        </form>
        
    </div>

</body>
</head>
</html>