<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="Bean.*" %>
<% String tipoU = (String) request.getSession().getAttribute("tipoUtente");

 if(tipoU.equals("studente")){
	 StudenteBean s = (StudenteBean) request.getSession().getAttribute("utenteSessione");
 }
 if(tipoU.equals("azienda")){
	 AziendaBean a = (AziendaBean) request.getSession().getAttribute("utenteSessione"); 
 }
 if(tipoU.equals("tutor")){
	 TutorBean s = (TutorBean) request.getSession().getAttribute("utenteSessione");
 }
 if(tipoU.equals("impiegato")){
	 ImpiegatoBean a = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione"); 
 }


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
 
<%@include file ="navbar.jsp"%>

<%@include file ="menu.jsp"%>

<% if (tipoU.equals("studente")){ %>
<a href="index.jsp" style="margin-left:50%"><img alt="Logo" src="img\avatar-default-icon.png" width="150px" height="150px"></a>

<table style="margin-left:30%; width: 700px;">
  <tr>
    <td>Nome </td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Cognome</td>
    <td>COGNOME</td>
  </tr>
  <tr>
    <td>Matricola</td>
    <td>MATRICOLA</td>
  </tr>
  <tr>
    <td>Luogo nascita</td>
    <td>LUOGO</td>
  </tr>
  <tr>
    <td>Data nascita</td>
    <td>DATA</td>
  </tr>
  <tr>
    <td>Indirizzo di residenza</td>
    <td>INDIRIZZO</td>
  </tr>
  <tr>
    <td>Citt&agrave; di residenza</td>
    <td>CITTA</td>
  </tr>  
  <tr>
    <td>Codice Fiscale</td>
    <td>CF</td>
  </tr>
  <tr>
    <td>E-mail</td>
    <td>EMAIL</td>
  </tr>
  <tr>
    <td>Telefono</td>
    <td>TELEFONO</td>
  </tr>
</table>
<%}
if (currentAzienda != null){ %>
	<a href="index.jsp" style="margin-left:35%"><img alt="Logo" src="img\timthumb.png" width="500px" height="300px"></a>

<table style="margin-left:30%; width: 700px;">
  <tr>
    <td>Nome azienda</td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Rappresentante</td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Sede</td>
    <td>SEDE</td>
  </tr>
  <tr>
    <td>E-mail</td>
    <td>E-MAIL</td>
  </tr>
  <tr>
    <td>Telefono</td>
    <td>TELEFONO</td>
  </tr>
  <tr>
    <td>Partita Iva</td>
    <td>PI</td>
  </tr>  
</table>

<div class ="new">
    <button name = "azioneUtente" value="visualizzaScheda" id="visualizzaSchedaButton" class=" button" type="submit">Scheda aziendale</button> 
    </div>
<%}
if(currentTutor != null) { %>
<a href="index.jsp" style="margin-left:50%"><img alt="Logo" src="img\avatar-default-icon.png" width="150px" height="150px"></a>

<table style="margin-left:30%; width: 700px;">
  <tr>
    <td>Nome </td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Cognome</td>
    <td>COGNOME</td>
  </tr>
  <tr>
    <td>Matricola</td>
    <td>MATRICOLA</td>
  </tr>
</table>

<%}
if(currentImpiegato != null) { %>

<a href="index.jsp" style="margin-left:50%"><img alt="Logo" src="img\avatar-default-icon.png" width="150px" height="150px"></a>

<table style="margin-left:30%; width: 700px;">
  <tr>
    <td>Nome </td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Cognome</td>
    <td>COGNOME</td>
  </tr>
  <tr>
    <td>Matricola</td>
    <td>MATRICOLA</td>
  </tr>
</table>

<% } %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>