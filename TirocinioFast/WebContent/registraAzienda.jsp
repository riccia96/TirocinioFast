<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Registra Azienda</title>
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
    <button name ="azioneUtente" value="registraAzienda" id="registraAziendaButton" class=" button" type="submit">Registrati</button> 
  </div>

</form>

<%@include file = "footer.jsp" %>

<script>
$(document).ready(function(){
	$("#registraAziendaButton").click(function(){
		
		$.post("/TirocinioFast/GestioneUtente",
				{
					"azioneUtente" : "registraAzienda",
				},
				function(responseTxt, statusTxt, xhr){
					if(responseTxt=="email gia' esistente")
						alert("E-mail inserita già corrisponde ad un account!");
					if(responseTxt=="nome azienda gia' esistente")
						alert("Nome azienda inserito già corrisponde ad un account!");
					if(responseTxt=="username gia' esistente")
						alert("Matricola inserita già corrisponde ad un account!");
					if(responseTxt=="password non corrispondenti")
						alert("Le password inserite non  corrispondono!");
					if(responseTxt=="formato risposta sbagliato")
						alert("Il formato inserito nel campo 'Risposta' non è corretto!");
					if(responseTxt=="formato password sbagliato")
						alert("Il formato inserito nel campo 'Password' non è corretto!");
					if(responseTxt=="formato username sbagliato")
						alert("Il formato inserito nel campo 'Username' non è corretto!");
					if(responseTxt=="formato telefono sbagliato")
						alert("Il formato inserito nel campo 'Telefono' non è corretto!");
					if(responseTxt=="formato email sbagliato")
						alert("Il formato inserito nel campo 'E-mail' non è corretto!");
					if(responseTxt=="formato indirizzo sbagliato")
						alert("Il formato inserito nel campo 'Indirizzo' non è corretto!");
					if(responseTxt=="formato ceo sbagliato")
						alert("Il formato inserito nel campo 'CEO' non è corretto!");
					if(responseTxt=="formato pi sbagliato")
						alert("Il formato inserito nel campo 'Partita Iva' non è corretto!");
					if(responseTxt=="formato nome sbagliato")
						alert("Il formato inserito nel campo 'Nome azienda' non è corretto!");
			});
	});
});
</script> 

<script src="js/bootstrap.min.js"></script>
</body>
</html>