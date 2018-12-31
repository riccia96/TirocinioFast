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

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="login" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Convenzione" class="avatar">
  </div>

    <input type="text" placeholder="Luogo di nascita del rappresentante" name="luogo" required>
	<br>
    <input type="text" placeholder="Data di nascita del rappresentante" name="data" required>
    <br>
    <input type="text" placeholder="Numero dipendenti" name="numero" required>
	<br>
    <input type="text" placeholder="Referente tirocini" name="referente" required>
    <br>
    <input type="text" placeholder="Telefono del referente" name="telefono" required>
    <br>
    <input type="text" placeholder="E-mail del referente" name="email" required>
	<br>
	<label>Descrizione delle attivit&agrave; svolte</label>
    <textarea name="descrizione"></textarea>
    <br>
    <input type="text" placeholder="Eventuale docente di riferimento" name="docente">
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="convenzione" id="convenzioneButton" class=" button" type="submit">Richiedi convenzione</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>