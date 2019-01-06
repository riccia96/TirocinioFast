<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="Bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imposta Password</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
 
<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="recupero" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

    <input type="password" placeholder="Nuova password" name="password" required>
	<br>
    <input type="password" placeholder="Conferma nuova password" name="conferma" required>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="impostaPassword" id="ReimpostaButton" class=" button" type="submit">Avanti</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>