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

<h3 class="perForm">Compilazione questionario valutativo</h3>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="questionarioAzienda" action="GestioneDocumento" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="questionarioAzienda" class="avatar">
  </div>

	<input type="text" placeholder="Titolo del tirocinio" name="titolo" required>
    <br>
    <input type="text" placeholder="Posizione ricoperta dal tutor aziendale" name="posizione" required>
	<br>
	<input type="text" placeholder="Perido di tirocinio (dal giorno - al giorno)" name ="periodo" required>
	<br>
	<label>Relativamente al progetto di tirocinio:</label>
	<br>
	<br>
    <p class="question">La durata del tirocinio &egrave; stata adeguata agli obiettivi formativi</p><select class="scelte" name="prima"><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/eccessiva</option></select>
	<br>
    <p class="question">Gli obiettivi formativi previsti sono stati raggiunti</p><select name="seconda" class="scelte"><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/completamente</option></select>
    <br>
    <p class="question">Il tirocinio formativo &egrave; utile all'Ente Ospitante</p><select name="terza" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>Relativamente al tirocinante:</label>
    <br>
    <br>
    <p class="question">Competenze informatiche possedute in ingresso</p><select name="quarta" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
	<br>
    <p class="question">Competenze acquisite al termine del tirocinio nella specifica disciplina</p><select name="quinta" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
    <br>
    <p class="question">Motivazione e interesse</p><select name="sesta" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto buono</option></select>
    <br>
    <p class="question">Soft skill (capacit&agrave; di relazionarsi, di comunicare, di lavorare in team ...)</p><select name="settima" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
   	<br>
    <label>Relativamente alle strutture universitarie addette alla gestione dei Tirocini</label>
    <br>
    <br>
    <p class="question">Hanno fornito informazioni chiare ed esaustive</p><select name="ottava" class="scelte""><option value="uno" >1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
	<br>
    <p class="question">Hanno fornito assistenza e disponibilità</p><select name="nona" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <p class="question">I servizi/informazioni fornite via Web sono esaustivi</p><select name="decima" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <label>Eventuali osservazioni:</label>
    <br>
    <textarea name ="undici" style="margin-left: 10%" rows="4" cols="50"></textarea>
    <br>
    <div class ="new">
    <button name = "azioneDocumento" value="compilaQuestionarioAzienda" id="questionarioAziendaButton" class=" button" type="submit">Invia questionario</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>