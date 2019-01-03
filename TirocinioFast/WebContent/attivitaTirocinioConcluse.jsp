<%@page import="Control.ManagerUtente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.*" %>
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

<%ArrayList<TirocinioBean> conclusi = (ArrayList<TirocinioBean>) request.getSession().getAttribute("");%>


<h3 class="intestazione"> Gestione dei tirocini conclusi</h3>

<% if(conclusi.size()>0){ %>
<table style="margin-left: 25%; width: 1000px; height: 80%;">
  <tr>
    <th style="text-align: center">Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center">Studente</th>
    <th style="text-align: center">Tutor</th>
    <th style="text-align: center">Azienda</th>
  </tr>
  <%  for (int i = 0; i< conclusi.size(); i++){ 
	  TirocinioBean tirocinio = conclusi.get(i);
	  StudenteBean s;
	  TutorBean t;
	  AziendaBean b;
	  %>
  <tr>
    <td><a href="mostraPDFConferma.jsp">Richiesta N.<%= tirocinio.get()%></a></td>
    <td><%= studente %></td>
    <td><%= tutor %> </td>
    <td><%= azienda %></td>
  </tr>
  <%} %>
  </table>
  <%} %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>