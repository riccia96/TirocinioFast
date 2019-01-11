<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
 	AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("azienda");
	ConvenzioneBean doc = (ConvenzioneBean) request.getSession().getAttribute("doc");
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

<p>L'azienda <%= azienda.getNome() %> con sede in <%= azienda.getIndirizzo() %> rappresentata dal dott./sig. <%= azienda.getCeo() %> nato a <%= doc.getLuogoNascitaCeo() %> il <%= doc.getDataNascitaCeo() %>, con N. dipendenti <%= doc.getNumeroDipendenti() %>, referente tirocini <%= doc.getReferente() %> tel. <%= doc.getTelefonoReferente() %> e-mail. <%= doc.getEmailReferente() %></p>
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

<p>L'azienda si occupa di: <%=azienda.getDescrizione() %></p>
<br>
<p>I tirocinanti saranno impiegati sull'attività di: <%= doc.getAttivita() %> </p>
<br>
<br>

<p>Docente del Dipartimento di Informatica con cui eventualmente si è già in contatto per questa attività: Prof/Prof.ssa <%= doc.getTutorAccademico() %> </p>
<br>
<br>
<br>

<h4>Luogo e data</h4>
<h4 style="margin-left: 65%">Timbro e Firma del Legale Rappresentante</h4>
<br>
<br>

<div class ="new">
    <button value="download" id="downloadButton" class=" button" type="submit" onclick="download()">Download</button> 
</div>

<script> 
function download() {
	document.getElementById("downloadButton").style.display = "none";
	window.print()
} 
</script> 
</body>
</html>