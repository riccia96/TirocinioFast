<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
 	AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("azienda");
	StudenteBean studente = (StudenteBean) request.getSession().getAttribute("studente");
	TutorBean tutor = (TutorBean) request.getSession().getAttribute("tutor");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3 style="margin-left: 65%";>Al Direttore del Dipartimento di Informatica</h3>
<h3 style="margin-left: 65%";>Prof. Alfredo De Santis</h3>
<br>
<br>
<br>

<h4>Oggetto: Richiesta attivazione Convenzione per Tirocini Curriculari ed Extracurriculari</h4>
<br>
<br>
<br>

<p>L'azienda XXXX con sede in XXXX rappresentata dal dott./sig. XXXX nato a XXXX il XXXX, con N. dipendenti XXXX, referente tirocini XXXX tel. XXXX e-mail. XXXX</p>
<br>
<br>

<h3 style="margin-left: 50%">CHIEDE</h3>
<br>
<br>

<p>L'attivazione di una Convenzione con il Dipartimento di Informatica al fine di poter ospitare studenti del Corso di Laurea in Informatica per attività di tirocinio curriculare ed extracurriculare.</p>
<br>
<br>
<br>

<h3>Segue una breve desrizione delle attività sulle quali potrenno essere impiegati i tirocinanti</h3>
<br>

<p>XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXx</p>
<br>
<br>
<br>

<p>Docente del Dipartimento di Informatica con cui eventualmente si è già in contatto per questa attività: XXXXXXX </p>
<br>
<br>
<br>

<h4>Luogo e data</h4>
<h4 style="margin-left: 65%">Timbro e Firma del Legale Rappresentante</h4>
<br>
<br>

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