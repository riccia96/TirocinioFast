<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.*" %>
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

<%ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("convenzioneA"); %>
<%AziendaBean aziende = (AziendaBean) request.getSession().getAttribute("azienda"); %>


<h3 class="intestazione">Gestione della richiesta di convenzione effettuata</h3>


<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Richiesta convenzione</th>
    <th style="text-align: center">Status</th>
    <th></th>
  </tr>
  
  <tr>
    <td><a href="GestioneConvenzione?azioneConvenzione=selezionaConvenzione&idConv=<%=convenzione.getId()%>">Richiesta N.<%= convenzione.getId() %></a></td>
    <%if (convenzione.isConvalida()==true) { %>
    <td><img alt="verde" src="img/verde.png" width="50px" height="50px"> </td>
    <% }
    else { %>
     <td><img alt="giallo" src="img/giallo.png" width="50px" height="50px"> </td>   
     <% } %>
    <%if (convenzione.getUrl().equals("")){ %>
    <td>
    	<form action="GestioneDocumento" method="POST">
  			Seleziona PDF convenzione firmato con gli allegati richiesti<br>
  			(Convenzione + visura camerale + documento di riconoscimento del rappresentante legale)<br>
  			<input type="file" name="nomeFileConvenzione" accept=".pdf" requider><br>
  			<input type="submit" name = "azioneDocumento" value= "uploadConvenzione">
		</form>
</td>
<% } else { %>
<td>Convenzione gi&agrave; presentata!</td>
<%} %>
  </tr>

  </table>


<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>