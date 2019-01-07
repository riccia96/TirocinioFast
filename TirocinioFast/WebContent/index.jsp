<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
 
<%@include file ="navbar.jsp"%>

<ul id="menu">
<li><a href="index.jsp">Home</a></li>
<li><a href="registraStudente.jsp">Registra studente</a></li>
<li><a href="registraAzienda.jsp">Registra azienda</a></li>
</ul>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="login" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

    <input type="text" placeholder="Username" name="username" required>
	<br>
    <input type="password" placeholder="Password" name="password" required>
    <br>
    <div class ="new">
    <button name ="azioneUtente" value="login" id="loginButton" class="button" type="submit">Login</button> 
    <br>
    <span class="dimenticata"><a href="recuperaPassword.jsp">Password dimenticata?</a></span>
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script>
$(document).ready(function(){
	$("#loginButton").click(function(){
		
		$.post("/TirocinioFast/GestioneUtente",
				{
					"azioneUtente" : "login",
				},
				function(responseTxt, statusTxt, xhr){
					if(responseTxt=="password no")
						alert("Password non corretta!");
					if(responseTxt=="username no")
						alert("Username non corretta o inesistente!");
			});
	});
});
</script>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>