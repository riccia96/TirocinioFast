<%@page import="Bean.ImpiegatoBean"%>
<%@page import="Bean.TutorBean"%>
<%@page import="Model.TutorDAO"%>
<%@page import="Bean.AziendaBean"%>
<%@page import="Bean.StudenteBean"%>
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
<%
StudenteBean currentStudente = (StudenteBean)session.getAttribute("currentSessionStudente");
if (currentStudente != null){ %>
	<li><a href="#">Area Personale</a></li>
	<li><a href="#">Ricerca azienda</a></li>
	<li><a href="#">Richiesta tirocinio</a></li>
	<li><a href="#">Registro ore</a></li>
	<li><a href="#">Questionario</a></li>
	<li><a href="#">Logout</a></li>	
<%}
AziendaBean currentAzienda = (AziendaBean)session.getAttribute("currentSessionAzienda");
if (currentAzienda != null){ %>
	<li><a href="#">Area Personale</a></li>
	<li><a href="#">Convenzione</a></li>
	<li><a href="#">Richieste tirocinio</a></li>
	<li><a href="#">Logout</a></li>
<%} 
TutorBean currentTutor = (TutorBean)session.getAttribute("currentSessionTutor");
if (currentTutor != null) { %>
	<li><a href="#">Area Personale</a></li>
	<li><a href="#">Richieste tirocinio</a></li>
	<li><a href="#">Logout</a></li>
<%} 
ImpiegatoBean currentImpiegato = (ImpiegatoBean)session.getAttribute("currentSessionImpiegato");
if (currentImpiegato != null) { %>
	<li><a href="#">Area Personale</a>
	<li><a href="#">Richieste tirocinio</a>
	<li><a href="#">Attivit� tirocinio</a>
	<li><a href="#">Convenzioni aziende</a>
	<li><a href="#">Elenco aziende convenzionate</a>
	<li><a href="#">Logout</a>
<%}
else { %>
	<li><a href="#">Home</a>
	<li><a href="#">Registrati</a>
<%} %>

</ul>

<div style="margin-left:25%;height:1200px;width: 700px;">
<form name="tipo">
  	<input type=radio onclick="cambia()" name=radioB checked>Studente
	<input type=radio onclick="cambia()" name=radioB>Azienda
</form>
<form name="form0" id="registrazione" action="GestioneUtente" method="POST" style="position:absolute;width: 700px;">
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
    <input type="text" placeholder="Citt� di residenza" name="citta" required>
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
    <input type="password" placeholder="Conferma password" name="password" required>
    <br>
    <input type="text" placeholder="Film preferito? (utilizzato per recupero password)" name="domanda" required>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="registrati" id="registratiButton" class=" button" type="submit">Registrati</button> 
  </div>

</form>

<form name="form1" id="registrazione" action="GestioneUtente" method="POST" style="visibility:hidden;position:absolute;width: 700px;">
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
    <input type="password" placeholder="Conferma password" name="password" required>
    <br>
    <input type="text" placeholder="Film preferito? (utilizzato per recupero password)" name="domanda" required>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="registrati" id="registratiButton" class=" button" type="submit">Registrati</button> 
  </div>

</form>
  
</div>


<footer class="footer">
	<a href="#"><img src="img/logo2.png" alt="unisa" width="400px" height="100px" ></a>
</footer>

<script> 
function cambia() { 
y=document.tipo.radioB;
for(i=0;i<y.length;i++){
if(y[i].checked)document.forms["form"+i].style.visibility='visible'
else document.forms["form"+i].style.visibility='hidden';
}
} 
</script> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>