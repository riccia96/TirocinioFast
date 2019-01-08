<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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

<script>
$(document).ready(function(){
	$("#registraStudenteButton").click(function(){
		
		$.post("/TirocinioFast/GestioneUtente",
				{
					"azioneUtente" : "registraStudente",
				},
				function(responseTxt, statusTxt, xhr){
					if(responseTxt=="email gia' esistente")
						alert("E-mail inserita già corrisponde ad un account!");
					if(responseTxt=="matricola gia' esistente")
						alert("Matricola inserita già corrisponde ad un account!");
					if(responseTxt=="codice fiscale gia' esistente")
						alert("Codice Fiscale inserito già corrisponde ad un account!");
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
					if(responseTxt=="formato matricola sbagliato")
						alert("Il formato inserito nel campo 'Matricola' non è corretto!");
					if(responseTxt=="formato CF sbagliato")
						alert("Il formato inserito nel campo 'Codice Fiscale' non è corretto!");
					if(responseTxt=="formato citta sbagliato")
						alert("Il formato inserito nel campo 'Città' non è corretto!");
					if(responseTxt=="formato indirizzo sbagliato")
						alert("Il formato inserito nel campo 'Indirizzo' non è corretto!");
					if(responseTxt=="formato data sbagliato")
						alert("Il formato inserito nel campo 'Data di Nascita' non è corretto!");
					if(responseTxt=="formato luogo sbagliato")
						alert("Il formato inserito nel campo 'Luogo di Nascita' non è corretto!");
					if(responseTxt=="formato cognome sbagliato")
						alert("Il formato inserito nel campo 'Cognome' non è corretto!");
					if(responseTxt=="formato nome sbagliato")
						alert("Il formato inserito nel campo 'Nome' non è corretto!");
			});
	});
});
</script>

<script src="js/bootstrap.min.js"></script>
</body>
</html>