<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registra Strudente</title>
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

<h3 class="perForm">Registrazione studente</h3>

<div style="margin-left:25%;width: 700px;">

<form class="dialogo" action="GestioneUtente" method="POST" ;width: 700px;">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

    <input type="text" placeholder="Nome" name="nome" required>
	<br>
    <input type="text" placeholder="Cognome" name="cognome" required>
    <br>
    <input type="text" placeholder="Luogo di nascita" name="luogo" required>
    <br>
    <input type="text" placeholder="Data di nascita" name="data" required>
    <br>
    <input type="text" placeholder="Indirizzo di residenza" name="indirizzo" required>
    <br>
    <input type="text" placeholder="Citt&agrave; di residenza" name="citta" required>
    <br>
    <input type="text" placeholder="Codice Fiscale" name="codice" required>
    <br>
    <input type="text" placeholder="Matricola" name="matricola" required>
    <br>
    <input type="text" placeholder="E-mail" name="email" required>
    <br>
    <input type="text" placeholder="Numero di telefono" name="telefono" required>
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
    <button name = "azioneUtente" value="registraStudente" id="registraStudenteButton" class="button" type="submit">Registrati</button> 
  </div>

</form>


  
</div>


<%@include file = "footer.jsp" %> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>