<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% TirocinioBean tiro = (TirocinioBean) request.getSession().getAttribute("richiestaTiro"); %>
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

<h3 class="perForm">Completamento di una richiesta di tirocinio</h3>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="compilazioneAzienda" action="GestioneTirocinio" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Richiesta" class="avatar">
  </div>

    <input type="text" placeholder="Sede tirocinio" name="sede" required>
	<br>
    <input type="text" placeholder="Tempi di accesso ai locali" name="tempi" required>
    <br>
    <input type="text" placeholder="Periodo tirocinio (indicativo)" name="periodo" required>
	<br>
    <input type="text" placeholder="Obiettivi tirocinio" name="obiettivi" required>
    <br>
    <input type="text" placeholder="Eventuali facilitazioni" name="facilitazioni" >
    <br>
    <div class ="new">
    <button name = "azioneTirocinio" value="tirocinioDatiAzienda" id="compilazioneAziendaButton" class=" button" type="submit">Invia</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>