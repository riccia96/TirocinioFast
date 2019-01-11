<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.*"%>
<%
AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("questSAzienda");
StudenteBean studente = (StudenteBean) request.getSession().getAttribute("studente");
TutorBean tutor = (TutorBean) request.getSession().getAttribute("questSTutor");
ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("questionarioSConvenzione");
QuestionarioStudenteBean questionarioStudente = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
ArrayList<String> scelte = (ArrayList<String>) request.getSession().getAttribute("risposte");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table style="margin-left: 0%; width:100%; border: 1px solid black;">
  <tr>
    <th style="border: 1px solid black;"><img alt="Logo" src="img\logo2.png" width="300px" height="70px"></th>
    <th style="border: 1px solid black;"><img alt="Logo" src="img\logo.png" width="300px" height="70px"></th>
    <th style="border: 1px solid black;"><label>Data compilazione </label></th>
  </tr>
  <tr>
    <td colspan="3" align="center"><b>QUESTIONARIO PER IL TIROCINANTE <br> CORSO DI LAUREA IN INFORMATICA</b></td>
  </tr>
</table>
<br>
<br>
<h4>Tirocinante: <%=studente.getCognome() + " " + studente.getNome() %>, Periodo di svolgimento del tirocinio: <%=questionarioStudente.getPeriodo() %>, Titolo del tirocinio: <%= questionarioStudente.getTitolo() %></h4>
<br>
<br>
<h4>Ente Ospitante: <%=azienda.getNome() %>, Sede del Tirocinio: <%= azienda.getIndirizzo() %>, Tutor Ente Ospitante: <%=convenzione.getReferente() %>, E-mail tutor: <%= convenzione.getEmailReferente() %></h4>
<br>
<br>
<h4>Tutor Accademico: Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %></h4> 
<br>
<br>
<h4>Relativamente al progetto di Tirocinio e all'Esperienza:</h4>
<br>
<h4>Le attivit&agrave; svolte sono state coerenti con le conoscenze possedute: <%=scelte.get(0) %></h4>
<br>
<h4>Il tirocinio ha migliorato la formazione tecnica: <%=scelte.get(1) %></h4>
<br>
<h4>Il tirocinio ha migliorato le soft skill (capacit&agrave; di relazionarsi, di lavorare in team, organizzarsi...): <%=scelte.get(2) %></h4>
<br>
<h4>La durata del tirocinio &egrave; stata adeguata agli obiettivi del progetto: <%=scelte.get(3) %></h4>
<br>
<h4>Valutazione complessiva dell'esperienza: <%=scelte.get(4) %></h4>
<br>
<br>
<h4>Relativamente all'Ente Ospitante:</h4>
<br>
<h4>Mansioni assegnate: <%=scelte.get(5) %></h4>
<br>
<h4>Ambiete di lavoro: <%=scelte.get(6) %></h4>
<br>
<h4>Competenze tecniche presenti: <%=scelte.get(7) %></h4>
<br>
<h4>Logistica e supporto strumentale: <%=scelte.get(8) %></h4>
<br>
<h4>Assistenza del tutor Ente Ospitante: <%=scelte.get(9) %></h4>
<br>
<br>
<h4>Relativamente alle strutture universitarie addette alla gestione dei Tirocini</h4>
<br>
<h4>Hanno fornito informazioni chiare ed esaustive: <%=scelte.get(10) %></h4>
<br>
<h4>Hanno fornito assistenza e disponibilità: <%=scelte.get(11) %></h4>
<br>
<h4>I servizi/informazioni fornite via Web sono esaustivi: <%=scelte.get(12) %></h4>
<br>
<h4>Eventuali osservazioni: <%=scelte.get(13) %></h4>
<br>
<br>
<h4 align="center">Firma del Tirocinante</h4>
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