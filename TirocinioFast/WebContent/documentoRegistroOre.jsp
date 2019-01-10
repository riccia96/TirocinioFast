<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	TirocinioBean tirocinio = (TirocinioBean)request.getSession().getAttribute("tirocinioOre");
	AziendaBean azienda = (AziendaBean)request.getSession().getAttribute("aziendaOre");
	TutorBean tutor = (TutorBean)request.getSession().getAttribute("tutorOre");

	StudenteBean studente = (StudenteBean) request.getSession().getAttribute("studenteOre");

	ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzioneOre");
%>
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

<h4 align="center"> <%=studente.getCognome() + " " + studente.getNome() + " " + studente.getMatricola()%></h4>

<h3 align="center">REGISTRO ORE DI TIROCINIO</h3>
<h3 align="center">LAUREA Triennale</h3>
<h4 align="center">in</h4>
<h3 align="center">Informatica</h3>
<br>
<h3 align="center">A.A 2018 - 19</h3>
<br>
<p>Studente: <%= studente.getCognome() + " " + studente.getNome() %> </p> 
<p>Matricola: <%= studente.getMatricola() %></p> 
<p>Luogo di nascita: <%= studente.getLuogoNascita() %> </p> 
<p>Data di nascita: <%= studente.getDataNascita() %> </p> 
<p>Ore di Stage: <%= tirocinio.getCfu()*25 %> </p>
<p>Struttura ospitante: <%=azienda.getNome() %> </p> 
<p>Tutor interno: Prof/Prof.ssa<%=tutor.getCognome() + " " + tutor.getCognome() %> </p> 
<p>Tutor esterno: <%= convenzione.getReferente() %> </p> 
<p align="right">Tutor Interno (Firma)</p>
<br>
<p align="right">Il responsabile dell'Ente ospitante e/o Presidente del C.A.D </p>
<div class ="new">
    <button name = "azioneUtente" value="download" id="downloadButton" class=" button" type="submit" onclick="download()">Download</button> 
</div>
<br>
<img alt="registro" src = "img/CCI04012019.jpg" height="650px" width="100%">
<img alt="registro" src = "img/CCI04012019.jpg" height="650px" width="100%">
<img alt="registro" src = "img/CCI04012019.jpg" height="650px" width="100%">

<script> 
function download() {
	document.getElementById("downloadButton").style.display = "none";
	window.print()
} 
</script> 
</body>
</html>