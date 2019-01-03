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

<%ArrayList<ConvenzioneBean> convenzioniInviate = (ArrayList<ConvenzioneBean>) request.getSession().getAttribute(""); %>

<h3 class="intestazione">Gestione della richiesta di convenzione effettuata</h3>

<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Richiesta convenzione</th>
    <th style="text-align: center">Status</th>
    <th></th>
  </tr>
  <% if (convenzioniInviate.size()>0){
  		for(int i = 0; i< convenzioniInviate.size(); i++){
  			ConvenzioneBean c = convenzioniInviate.get(i);
  			%>
  <tr>
    <td><a href="mostraPDF.jsp">Richiesta N.<%= c.get() %></a></td>
    <%if (c.isConvalida()==true) { %>
    <td><img alt="verde" src="img/verde.png"> </td>
    <% }
    else { %>
     <td><img alt="giallo" src="img/giallo.png"> </td>   
     <% 	}
   		 }
    }%>
    <td>
    	<form>
  			Seleziona PDF convenzione firmato con gli allegati richiesti<br>
  			(Convenzione + visura camerale + documento di riconoscimento del rappresentante legale)<br>
  			<input type="file" name="servletPerSalvereDocumento" accept=".pdf" requider><br>
  			<input type="submit">
		</form>
</td>
  </tr>
  </table>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>