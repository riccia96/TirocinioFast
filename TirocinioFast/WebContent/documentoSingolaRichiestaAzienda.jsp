<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<img alt="Logo" src="img\logo.png" height="180px" width="800px">

<h3 style="margin-left: 50%";>PROGETTO FORMATIVO DI ORIENTAMENTO</h3>
<h3 style="margin-left: 50%";>ai sensi del D.M 25 marzo 1998 n.142</h3>
<br>
<br>

<p>Tirocinante XXXXXXXX, Nato a XXXXXXXX, il XXXXXXXXXX, Residente in XXXXXXXXXX, Via XXXXXXXXXXX, Cod. Fiscale XXXXXXXXX, Recapito telefonico XXXXXXXXXXXX, E-mail XXXXXXXXXX </p>
<br>

<h3>Attuale condizione</h3>
<br>
<p>Studente universitario iscritto al X anno del Corso di Laurea Triennale in Informatica, matr. XXXXXX presso l'Universit� degli Studi di Salerno per l'anno accademico XXXX/XXXX con tirocinio curriculare pari a X CFU</p>
<br>
<p>Portatore di Handicap: XX
<br>
<br>
<p>Azienda/Ente ospitante: XXXXXXXXX
<br>
<p>Sede del Tirocinio (stabilimento/reparto/ufficio): XXXXXXXXX
<br>
<p>Tempi di accesso ai locali aziendali: XXXXXXXXXX
<br>
<p>Periodo di tirocinio (max 12 mesi): X mesi, dal XXX al XXX per totale ore: XXX</p>
<br>
<p>Tutor accademico: XXXXXXX</p>
<br>
<p>Tutor azienda/ente: XXXXX, tel. XXXXXXX, e-mail XXXXXXXXXX</p>
<br>
<p>Polizze assicurative: <b>INAL Gestione per conto dello Stato prevista dal combinato disposto dagli artt. 127 e 190 del <u>T.U. INAL (DPR N. 1124/65)</u> e regolamentato dal D.M. 10.10.85:</b>
<br>
<b>Infortuni posizione 261044627 Compagnia Generali</b>
<br>
<b>Responsabilit&agrave; Civile Terzi Compagnia Generali 261044624</b></p>
<br>
<br>
<p>Obiettivi e modalit� del tirocinio: XXXXXXXXXXXXXXXXXXXXXXX</p>
<br>
<p>Eventuali facilitazioni previste: XXXXXXXXXXXXXXXXXXXXXX</p>
<br>
<h4>Obblighi per il tirocinante:</h4>
<br>
<ul>
  <li>Seguire le indicazioni dei tutori e fare riferimento ad essi su qualsiasi Esigenza di tipo organizzativo ed altre evenienze;</li>
  <li>Rispettare gli obblighi di riservatezza per quanto attiene ai dati, alle Informazioni e conoscenze in merito all'attivit&agrave; di ricerca dell'Ente/Azienda, acquisiti durante e dopo lo svolgimento del tirocinio;</li>
  <li>Rispettare i regolamenti aziendali e le norme in materia di igiene e sicurezza.</li>
</ul>
<br>

<h4>Fisciano, </h4>
<br>
<h4>Ente/Azienda (timbro e firma)</h4>
<br>
<br>
<h4>Tutor aziendale</h4>
<br>
<br>
<h4>Tutor Accademico </h4>
<br>
<br>
<h4>Presidente del Consiglio Didattico <br> e/o Direttore del Dipartimento</h4>
<br>
<br>
<h4>Firma per visione e accettazione del tirocinante</h4>

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