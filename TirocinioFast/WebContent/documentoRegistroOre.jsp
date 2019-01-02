<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img alt="Logo" src="img\logo_standard.png" width="200px" height="200px" style="margin-left: 40%; margin-top: 5%">
<br>
<br>

<h1 align="center">UNIVERSIT&Agrave; DEGLI STUDI DI SALERNO</h1>
<br>
<br>
<br>

<h2 align="center">DIPARTIMENTO DI INFORMATICA</h2>
<br>
<br>
<br>

<h2 align="center">REGISTRO ORE DI TIROCINIO</h2>
<br>
<br>

<h2 align="center">LAUREA TRIENNALE</h2>
<br>
<h2 align="center">IN</h2>
<br>
<h2 align="center">INFORMATICA</h2>

<br>
<h2 align="center">A.A 2018 - 19</h2>

<br>
<h4 align="center">Cognome Nome matricola XXXXXXXXX</h4>

<br>
<h3 align="center">REGISTRO ORE DI TIROCINIO</h3>
<br>
<h3 align="center">LAUREA Triennale</h3>
<h4 align="center">in</h4>
<h3 align="center">Informatica</h3>
<br>
<br>
<h3 align="center">A.A 2018 - 19</h3>
<br>
<br>
<p>Studente: XXXXXXX </p> <br>
<p>Matricola: XXXXXX</p> <br>
<p>Luogo di nascita: XXXXXX </p> <br>
<p>Data di nascita: XXXXXX </p> <br>
<p>Ore di Stage: XXX </p> <br>
<p>Struttura ospitante: XXXXXX </p> <br>
<p>Tutor interno: XXXXXX </p> <br>
<p>Tutor esterno: XXXXX </p> <br>
<p align="right">Tutor Interno (Firma)</p>
<br>
<p align="right">Il responsabile dell'Ente ospitante e/o Presidente del C.A.D </p>
<div class ="new">
    <button name = "azioneUtente" value="download" id="downloadButton" class=" button" type="submit" onclick="download()">Download</button> 
</div>

<script> 
function download() {
	document.getElementById("downloadButton").style.display = "none";
	window.print()
} 
</script> 
</body>
</html>