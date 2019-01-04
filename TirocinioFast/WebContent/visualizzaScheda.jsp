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

<h3 class="intestazione">Informazioni sull'azienda</h3>

<div style="margin-left:25%;width: 700px;" class="dialogo">
    <img src="img/due.jpeg" alt="logo" >

	<label>Tutte le info</label>
    <div class ="new">
    <button name = "#" value="inviaRichiestaTirocinio" id="inviaRichiestaTirocinioButton" class=" button" type="submit">Invia richiesta di tirocinio</button> 
    </div>
  
</div>

<%@include file = "footer.jsp" %>
</body>
</html>