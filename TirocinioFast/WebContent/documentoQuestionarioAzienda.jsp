<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <th style="border: 1px solid black;"><label>Data compilazione xx/xx/xx</label></th>
  </tr>
  <tr>
    <td colspan="3" align="center"><b>QUESTIONARIO RILEVAZIONE GRADO DI SODDISFAZIONE DELL'ENTE OSPITANTE <br> ATTIVIT&Agrave; DI TIROCINIO - CORSO DI LAUREA IN INFORMATICA</b></td>
  </tr>
</table>
<br>
<br>
<h4>Ente Ospitante: XXXXXX, Sede Tirocinio: XXXXXX, Citt&agrave;: XXXX, Tutor Ente Ospitante: XXXXXXXX, Posizione ricoperta: XXXXXXX, E-mail tutor: XXXXXXXX</h4>
<br>
<br>
<h4>Tutor Accademico: XXXXXXXXX, Tirocinante: XXXXXXX, Periodo di svolgimento del tirocinio: XXXXXXXXX, Titolo del tirocinio: XXXXXXXXX</h4> 
<br>
<br>
<h4>Relativamente al progetto di tirocinio:</h4>
<br>
<h4>La durata del tirocinio &egrave; stata adeguata agli obiettivi formativi: X</h4>
<br>
<h4>Gli obiettivi formativi previsti sono stati raggiunti: X</h4>
<br>
<h4>Il tirocinio formativo &egrave; utile all'Ente Ospitante: X</h4>
<br>
<br>
<h4>Relativamente al tirocinante:</h4>
<br>
<h4>Competenze informatiche possedute in ingresso: X</h4>
<br>
<h4>Competenze acquisite al termine del tirocinio nella specifica disciplina: X</h4>
<br>
<h4>Motivazione e interesse: X</h4>
<br>
<h4>Soft skill (capacit&agrave; di relazionarsi, di comunicare, di lavorare in team ...): X</h4>
<br>
<br>
<h4>Relativamente alle strutture universitarie addette alla gestione dei Tirocini</h4>
<br>
<h4>Hanno fornito informazioni chiare ed esaustive: X</h4>
<br>
<h4>Hanno fornito assistenza e disponibilit�: X</h4>
<br>
<h4>I servizi/informazioni fornite via Web sono esaustivi: X</h4>
<br>
<h4>Eventuali osservazioni: X</h4>
<br>
<br>
<h4 align="center">Firma del Tutor dell'Ente Ospitante e Timbro dell'Ente Ospitante</h4>
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