<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img id="logo" alt="Logo" src="img\LogoTF.png" height="120px" width="300px"></a>
    <a href="#"><img id="unisa" alt="Unisa" src="img\logo_standard.png" width="100px" height="100px"></a>  
    </div>
 </nav>

<ul id="menu">
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="#news">News</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="#about">About</a></li>
</ul>

<div style="margin-left:25%;height:500px;">
<form id="login" action="/action_page.php">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>
	<br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="login" id="loginButton" class=" button" type="submit">Login</button> 
    <br>
    <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </div>

</form>
  
</div>

<footer class="footer">
	<a href="#"><img src="img/logo2.png" alt="unisa" width="400px" height="100px" ></a>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>