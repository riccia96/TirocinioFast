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
    <td colspan="3" align="center"><b>QUESTIONARIO PER IL TIROCINANTE <br> CORSO DI LAUREA IN INFORMATICA</b></td>
  </tr>
</table>
<br>
<br>
<h4>Tirocinante: XXXXXXX, Periodo di svolgimento del tirocinio:XXXXXXXX, Titolo del tirocinio:XXXXXXXXXX</h4>
<br>
<br>
<h4>Ente Ospitante: XXXXXX, Sede del Tirocinio: XXXXXX, Citt&agrave;: XXXX, Tutor Ente Ospitante: XXXXXXXX, E-mail tutor: XXXXXXXX</h4>
<br>
<br>
<h4>Tutor Accademico: XXXXXXXXX</h4> 
<br>
<br>
<h4>Relativamente al progetto di Tirocinio e all'Esperienza:</h4>
<br>
<h4>Le attivit&agrave; svolte sono state coerenti con le conoscenze possedute: X</h4>
<br>
<h4>Il tirocinio ha migliorato la formazione tecnica: X</h4>
<br>
<h4>Il tirocinio ha migliorato le soft skill (capacit&agrave; di relazionarsi, di lavorare in team, organizzarsi...): X</h4>
<br>
<h4>La durata del tirocinio &egrave; stata adeguata agli obiettivi del progetto: X</h4>
<br>
<h4>Valutazione complessiva dell'esperienza: X</h4>
<br>
<br>
<h4>Relativamente all'Ente Ospitante:</h4>
<br>
<h4>Mansioni assegnate: X</h4>
<br>
<h4>Ambiete di lavoro: X</h4>
<br>
<h4>Competenze tecniche presenti: X</h4>
<br>
<h4>Logistica e supporto strumentale: X</h4>
<br>
<h4>Assistenza del tutor Ente Ospitante: X</h4>
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
<h4 align="center">Firma del Tirocinante</h4>
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