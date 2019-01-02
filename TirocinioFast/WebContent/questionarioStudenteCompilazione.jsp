<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="questionarioStudente" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="questionarioStudente" class="avatar">
  </div>

	<input type="text" placeholder="Titolo del tirocinio" name="titolo" required>
    <br>
	<label>Relativamente al progetto di Tirocinio e all'Esperienza:</label>
	<br>
    <label>Le attivit&agrave; svolte sono state coerenti con le conoscenze possedute</label><select name="prima" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
	<br>
    <label>Il tirocinio ha migliorato la formazione tecnica</label><select name="seconda" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>Il tirocinio ha migliorato le soft skill (capacit&agrave; di relazionarsi, di lavorare in team, organizzarsi...)</label><select name="terza" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>La durata del tirocinio &egrave; stata adeguata agli obiettivi del progetto</label><select name="quarta" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/eccessiva</option></select>
    <br>
    <label>Valutazione complessiva dell'esperienza</label><select name="quinta" style="margin-left: 25%;"><option value="uno">1/inutile</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto utile</option></select>
    <br>
    <label>Relativamente all'Ente Ospitante:</label>
    <br>
    <label>Mansioni assegnate</label><select name="sesta" style="margin-left: 25%;"><option value="uno">1/inadeguate</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/adeguate</option></select>
	<br>
    <label>Ambiete di lavoro</label><select name="settima" style="margin-left: 25%;"><option value="uno">1/inospitale</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ospitale</option></select>
    <br>
    <label>Competenze tecniche presenti</label><select name="ottava" style="margin-left: 25%;"><option value="uno">1/insufficienti</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
    <br>
    <label>Logistica e supporto strumentale</label><select name="nona" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto buono</option></select>
   	<br>
   	<label>Assistenza del tutor Ente Ospitante</label><select name="decima" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottima</option></select>
   	<br>
    <br>
    <label>Relativamente alle strutture universitarie addette alla gestione dei Tirocini</label>
    <br>
    <label>Hanno fornito informazioni chiare ed esaustive</label><select name="ottava" style="margin-left: 25%;"><option value="uno" >1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
	<br>
    <label>Hanno fornito assistenza e disponibilità</label><select name="nona" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>I servizi/informazioni fornite via Web sono esaustivi</label><select name="decima" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>Eventuali osservazioni:</label>
    <br>
    <textarea style="margin-left: 13%" rows="4" cols="50"></textarea>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="questionarioStudente" id="questionarioStudenteButton" class=" button" type="submit">Invia questionario</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>