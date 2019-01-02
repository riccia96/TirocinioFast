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

<h3 class="perForm">Registrazione azienda</h3>

<form class="dialogo" action="GestioneUtente" method="POST" style="margin-left:25%;width: 700px;">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

    <input type="text" placeholder="Nome azienda" name="nome" required>
	<br>
    <input type="text" placeholder="Partita Iva" name="iva" required>
    <br>
    <input type="text" placeholder="Rappresentante azienda" name="ceo" required>
    <br>
    <input type="text" placeholder="Sede" name="sede" required>
    <br>
    <input type="text" placeholder="E-mail" name="email" required>
    <br>
    <input type="text" placeholder="Telefono" name="telefono" required>
    <br>
    <input type="text" placeholder="Username" name="username" required>
    <br>
    <input type="password" placeholder="Password" name="password" required>
    <br>
    <input type="password" placeholder="Conferma password" name="conferma" required>
    <br>
    <input type="text" placeholder="Film preferito? (utilizzato per recupero password)" name="domanda" required>
    <br>
    <div class ="new">
    <button name ="azioneUtente" value="registraAzienda" id="registratiButton" class=" button" type="submit">Registrati</button> 
  </div>

</form>

<%@include file = "footer.jsp" %> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>