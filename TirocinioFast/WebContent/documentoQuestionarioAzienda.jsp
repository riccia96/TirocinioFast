<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.*"%>
<%
 	AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("questSAzienda");
	StudenteBean studente = (StudenteBean) request.getSession().getAttribute("questStudente");
	TutorBean tutor = (TutorBean) request.getSession().getAttribute("questSTutor");
	ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("questionarioAConvenzione");
	QuestionarioAziendaBean questionarioAzienda = (QuestionarioAziendaBean) request.getSession().getAttribute("questionarioAzienda");
	ArrayList<String> scelte = (ArrayList<String>) request.getSession().getAttribute("risposteA");
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
    <td colspan="3" align="center"><b>QUESTIONARIO RILEVAZIONE GRADO DI SODDISFAZIONE DELL'ENTE OSPITANTE <br> ATTIVIT&Agrave; DI TIROCINIO - CORSO DI LAUREA IN INFORMATICA</b></td>
  </tr>
</table>
<br>
<br>
<h4>Ente Ospitante: <%= azienda.getNome() %>, Sede Tirocinio: <%= azienda.getIndirizzo() %>, Tutor Ente Ospitante: <%= convenzione.getReferente() %>, Posizione ricoperta: <%= questionarioAzienda.getPosizioneRicoperta() %>, E-mail tutor: <%=convenzione.getEmailReferente()%> </h4>
<br>
<br>
<h4>Tutor Accademico: Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %>, Tirocinante: <%= studente.getCognome() + " " + studente.getNome() %>, Periodo di svolgimento del tirocinio: <%= questionarioAzienda.getPeriodoTirocinio() %>, Titolo del tirocinio: <%= questionarioAzienda.getTitoloTirocinio() %></h4> 
<br>
<br>
<h4>Relativamente al progetto di tirocinio:</h4>
<br>
<h4>La durata del tirocinio &egrave; stata adeguata agli obiettivi formativi: <%= scelte.get(0) %></h4>
<br>
<h4>Gli obiettivi formativi previsti sono stati raggiunti: <%= scelte.get(1) %></h4>
<br>
<h4>Il tirocinio formativo &egrave; utile all'Ente Ospitante: <%= scelte.get(2) %></h4>
<br>
<br>
<h4>Relativamente al tirocinante:</h4>
<br>
<h4>Competenze informatiche possedute in ingresso: <%= scelte.get(3) %></h4>
<br>
<h4>Competenze acquisite al termine del tirocinio nella specifica disciplina: <%= scelte.get(4) %></h4>
<br>
<h4>Motivazione e interesse: <%= scelte.get(5) %></h4>
<br>
<h4>Soft skill (capacit&agrave; di relazionarsi, di comunicare, di lavorare in team ...): <%= scelte.get(6) %></h4>
<br>
<br>
<h4>Relativamente alle strutture universitarie addette alla gestione dei Tirocini</h4>
<br>
<h4>Hanno fornito informazioni chiare ed esaustive: <%= scelte.get(7) %></h4>
<br>
<h4>Hanno fornito assistenza e disponibilità: <%= scelte.get(8) %></h4>
<br>
<h4>I servizi/informazioni fornite via Web sono esaustivi: <%= scelte.get(9) %></h4>
<br>
<h4>Eventuali osservazioni: <%= scelte.get(10) %></h4>
<br>
<br>
<h4 align="center">Firma del Tutor dell'Ente Ospitante e Timbro dell'Ente Ospitante</h4>
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