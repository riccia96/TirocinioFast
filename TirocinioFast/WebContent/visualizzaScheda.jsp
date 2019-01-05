<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="Bean.*"%>
<%
	AziendaBean a = (AziendaBean) request.getSession().getAttribute("aziendaSelezionata");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scheda Azienda</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<%
	AziendaBean azienda = (AziendaBean) request.getSession().getAttribute("aziendaSelezionata");
%>

<h3 class="intestazione">Informazioni sull'azienda</h3>

<div style="margin-left:25%;width: 700px;" class="dialogo">
    <img src="<%=azienda.getLogo() %>" alt="logo" >

	<h3><%= azienda.getNome() %></h3>
	<br>
	<p><%= azienda.getDescrizione() %></p>
	<p><%= azienda.getIndirizzo() %></p>
	<p><%= azienda.getEmail() %></p>
	<p><%= azienda.getTelefono()%></p>
    <div class ="new">
    <input type="hidden" name="aziendaSelezionata" value="<%=a.getUsername()%>">
    <button name = "azioneTirocinio" value="inoltraRichiesta" id="inoltraRichiestaTirocinioButton" class=" button" type="submit">Invia richiesta di tirocinio</button> 
    </div>
  
</div>

<%@include file = "footer.jsp" %>
</body>
</html>