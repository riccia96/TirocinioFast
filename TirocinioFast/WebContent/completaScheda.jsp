<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Completa Scheda Azienda</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
 
<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<h3 class="perForm">Compilazione della scheda aziendale</h3>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="login" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Convenzione" class="avatar">
  </div>

	<label>Carica l'immagine del logo dell'azienda</label><br>
    <input type="file" name="logo" accept=".jpg,.jpeg,png" required>
	<br>
	<label>Descrizione delle attività su cui saranno impiegati i tirocinanti</label><br>
    <textarea style="margin-left: 13%" rows="4" cols="50" name="descrizione"></textarea>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="salvaScheda" id="compilaSchedaButton" class=" button" type="submit">Salva scheda</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>