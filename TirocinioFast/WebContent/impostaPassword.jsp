<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Imposta Password</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
 
<%@include file = "navbar.jsp" %>

<ul id="menu">
<li><a href="index.jsp">Home</a></li>
<li><a href="registraStudente.jsp">Registra studente</a></li>
<li><a href="registraAzienda.jsp">Registra azienda</a></li>
</ul>

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
    <button name = "azioneUtente" value="impostaPassword" id="reimpostaButton" class=" button" type="submit">Avanti</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>


<script src="js/bootstrap.min.js"></script>
</body>
</html>