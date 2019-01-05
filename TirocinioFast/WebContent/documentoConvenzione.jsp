<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
 	AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("azienda");
	ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzione");
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

<p>L'azienda <%= azienda.getNome() %> con sede in <%= azienda.getIndirizzo() %> rappresentata dal dott./sig. <%= azienda.getCeo() %> nato a <%= convenzione.getLuogoNascitaCeo() %> il <%= convenzione.getDataNascitaCeo() %>, con N. dipendenti <%= convenzione.getNumeroDipendenti() %>, referente tirocini <%= convenzione.getReferente() %> tel. <%= convenzione.getTelefonoReferente() %> e-mail. <%= convenzione.getEmailReferente() %></p>
<br>
<br>

<h3 style="margin-left: 50%">CHIEDE</h3>
<br>
<br>

<p>L'attivazione di una Convenzione con il Dipartimento di Informatica al fine di poter ospitare studenti del Corso di Laurea in Informatica per attivit� di tirocinio curriculare ed extracurriculare.</p>
<br>
<br>
<br>

<h3>Segue una breve desrizione delle attivit� sulle quali potrenno essere impiegati i tirocinanti</h3>
<br>

<p>L'azienda si occupa di: <%=azienda.getDescrizione() %></p>
<br>
<p>I tirocinanti saranno impiegati sull'attivit� di: <%= convenzione.getAttivita() %> </p>
<br>
<br>

<p>Docente del Dipartimento di Informatica con cui eventualmente si � gi� in contatto per questa attivit�: Prof/Prof.ssa <%= convenzione.getTutorAccademico() %> </p>
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