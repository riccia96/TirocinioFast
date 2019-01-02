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

<a href="homeAzienda.jsp" style="margin-left:35%"><img alt="Logo" src="img\timthumb.png" width="500px" height="300px"></a>

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

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>