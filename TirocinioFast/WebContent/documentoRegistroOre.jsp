<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img alt="Logo" src="img\logo_standard.png" width="200px" height="200px" style="margin-left: 40%;">
<br>
<br>

<h1 align="center">UNIVERSIT&Agrave; DEGLI STUDI DI SALERNO</h1>
<br>
<h2 align="center">DIPARTIMENTO DI INFORMATICA</h2>
<br>
<h2 align="center">REGISTRO ORE DI TIROCINIO</h2>
<br>

<h2 align="center">LAUREA TRIENNALE</h2>
<h2 align="center">IN</h2>
<h2 align="center">INFORMATICA</h2>
<h2 align="center">A.A 2018 - 19</h2>

<h4 align="center">Cognome Nome matricola XXXXXXXXX</h4>

<h3 align="center">REGISTRO ORE DI TIROCINIO</h3>
<h3 align="center">LAUREA Triennale</h3>
<h4 align="center">in</h4>
<h3 align="center">Informatica</h3>
<br>
<h3 align="center">A.A 2018 - 19</h3>
<br>
<p>Studente: XXXXXXX </p> 
<p>Matricola: XXXXXX</p> 
<p>Luogo di nascita: XXXXXX </p> 
<p>Data di nascita: XXXXXX </p> 
<p>Ore di Stage: XXX </p>
<p>Struttura ospitante: XXXXXX </p> 
<p>Tutor interno: XXXXXX </p> 
<p>Tutor esterno: XXXXX </p> 
<p align="right">Tutor Interno (Firma)</p>
<br>
<p align="right">Il responsabile dell'Ente ospitante e/o Presidente del C.A.D </p>
<div class ="new">
    <button name = "azioneUtente" value="download" id="downloadButton" class=" button" type="submit" onclick="download()">Download</button> 
</div>
<br>
<img alt="registro" src = "img/CCI04012019.jpg" height="650px" width="100%">

<script> 
function download() {
	document.getElementById("downloadButton").style.display = "none";
	window.print()
} 
</script> 
</body>
</html>