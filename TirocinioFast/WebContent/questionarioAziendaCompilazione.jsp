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
<form class="dialogo" id="questionarioAzienda" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="questionarioAzienda" class="avatar">
  </div>

	<input type="text" placeholder="Titolo del tirocinio" name="titolo" required>
    <br>
    <input type="text" placeholder="Posizione ricoperta dal tutor aziendale" name="posizione" required>
	<br>
	<label>Relativamente al progetto di tirocinio:</label>
	<br>
    <label>La durata del tirocinio &egrave; stata adeguata agli obiettivi formativi</label><select name="prima" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/eccessiva</option></select>
	<br>
    <label>Gli obiettivi formativi previsti sono stati raggiunti</label><select name="seconda" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/completamente</option></select>
    <br>
    <label>Il tirocinio formativo &egrave; utile all'Ente Ospitante</label><select name="terza" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <br>
    <label>Relativamente al tirocinante:</label>
    <br>
    <label>Competenze informatiche possedute in ingresso</label><select name="quarta" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
	<br>
    <label>Competenze acquisite al termine del tirocinio nella specifica disciplina</label><select name="quinta" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
    <br>
    <label>Motivazione e interesse</label><select name="sesta" style="margin-left: 25%;"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto buono</option></select>
    <br>
    <label>Soft skill (capacit&agrave; di relazionarsi, di comunicare, di lavorare in team ...)</label><select name="settima" style="margin-left: 25%;"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
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
    <button name = "azioneUtente" value="questionarioAzienda" id="questionarioAziendaButton" class=" button" type="submit">Invia questionario</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>