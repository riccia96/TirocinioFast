<%@page import="Bean.ImpiegatoBean"%>
<%@page import="Bean.TutorBean"%>
<%@page import="Model.TutorAccademicoDAO"%>
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
	<li><a href="#">Attività tirocinio</a>
	<li><a href="#">Convenzioni aziende</a>
	<li><a href="#">Elenco aziende convenzionate</a>
	<li><a href="#">Logout</a>
<%}
else { %>
	<li><a href="#">Home</a>
	<li><a href="#">Registrati</a>
<%} %>

</ul>

<div style="margin-left:25%;height:500px;width: 700px;">
<form id="login" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>

    <input type="text" placeholder="Username" name="uname" required>
	<br>
    <input type="password" placeholder="Password" name="psw" required>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="login" id="loginButton" class=" button" type="submit">Login</button> 
    <br>
    <span class="dimenticata"><a href="#">Password dimenticata?</a></span>
    </div>
</form>
  
</div>

<footer class="footer">
	<a href="#"><img src="img/logo2.png" alt="unisa" width="400px" height="100px" ></a>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>