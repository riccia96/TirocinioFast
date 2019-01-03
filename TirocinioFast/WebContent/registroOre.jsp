<%@page import="java.util.ArrayList"%>
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

<%ArrayList<TirocinioBean> disponibiliRegistro = (ArrayList<TirocinioBean>)request.getSession().getAttribute(""); %>

<h3 class="intestazione">Gestione del registro</h3>

<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Registro ore relativo all'Attivit&agrave; di Tirocinio (DOWNLOAD SOLO QUANDO RICHIESTA ACCETTATA)</th>
    <th style="text-align: center">Azienda</th>
    <th style="text-align: center">Tutor</th>
    <th></th>
  </tr>
  <% if (disponibiliRegistro.size()>0){
  		for (int i = 0; i < disponibiliRegistro.size(); i++){
  			TirocinioBean t = disponibiliRegistro.get(i);
  			AziendaBean a = ();
  			TutorBean t = ();  		
	  %>
  <tr>
    <td><a href="documentoRegistroOre.jsp">Attivit&agrave; di Tirocinio N.<%= t.() %></a></td>
    <td><%= a.getNome() %></td>
    <td><%= t.getCognome() + t.getNome() %></td>
    <td>UPLOAD DOPO DOWNLOAD</td>
  </tr>
  <%} %>
  </table>
<%} %>
<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>