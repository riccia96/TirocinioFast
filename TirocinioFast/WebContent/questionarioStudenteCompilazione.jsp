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
<form class="dialogo" id="questionarioStudente" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="questionarioStudente" class="avatar">
  </div>

	<input type="text" placeholder="Titolo del tirocinio" name="titolo" required>
    <br>
    <input type="text" placeholder="Perido di tirocinio (dal giorno - al giorno)" name ="periodo" required>
	<br>
	<label>Relativamente al progetto di Tirocinio e all'Esperienza:</label>
	<br>
	<br>
    <p class="question">Le attivit&agrave; svolte sono state coerenti con le conoscenze possedute</p><select name="prima" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
	<br>
    <p class="question">Il tirocinio ha migliorato la formazione tecnica</p><select name="seconda" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <p class="question">Il tirocinio ha migliorato le soft skill (capacit&agrave; di relazionarsi, di lavorare in team, organizzarsi...)</p><select name="terza" class="scelte""><option value="uno">1/per niente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto</option></select>
    <br>
    <p class="question">La durata del tirocinio &egrave; stata adeguata agli obiettivi del progetto</p><select name="quarta" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/eccessiva</option></select>
    <br>
    <p class="question">Valutazione complessiva dell'esperienza</p><select name="quinta" class="scelte""><option value="uno">1/inutile</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto utile</option></select>
    <br>
    <label>Relativamente all'Ente Ospitante:</label>
    <br>
    <br>
    <p class="question">Mansioni assegnate</p><select name="sesta" class="scelte""><option value="uno">1/inadeguate</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/adeguate</option></select>
	<br>
    <p class="question">Ambiete di lavoro</p><select name="settima" class="scelte""><option value="uno">1/inospitale</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ospitale</option></select>
    <br>
    <p class="question">Competenze tecniche presenti</p><select name="ottava" class="scelte""><option value="uno">1/insufficienti</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottime</option></select>
    <br>
    <p class="question">Logistica e supporto strumentale</p><select name="nona" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/molto buono</option></select>
   	<br>
   	<p class="question">Assistenza del tutor Ente Ospitante</p><select name="decima" class="scelte""><option value="uno">1/insufficiente</option><option value="due">2</option><option value="tre">3</option><option value="quattro">4</option><option value="cinque">5/ottima</option></select>
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
    <textarea style="margin-left: 10%" rows="4" cols="50"></textarea>
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