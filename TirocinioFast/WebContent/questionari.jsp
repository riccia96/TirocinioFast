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

<h3 class="intestazione">Gestione dei questionari valutativi</h3>

<% if (tipo.equals("studente")){ %>
<%ArrayList<QuestionarioStudenteBean> questionariS = (ArrayList<QuestionarioStudenteBean>) request.getSession().getAttribute("");}%>
  <% if (questionariS.size()>0){ %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Tirocinio N.XXXXX</th>
    <th style="text-align: center">Azienda</th>
    <th style="text-align: center">Tutor</th>
    <th style="text-align: center">Titolo tirocinio</th>
    <th></th>
  </tr>
  		<%for (int i = 0; i < questionariS.size(); i++){
  			QuestionarioStudenteBean qs = questionariS.get(i);
  			AziendaBean a = ();
  			TutorBean t = ();  		
	  %>
  <tr>
    <td>Questionario N.<%=xxx %></td>
    <td><%= a.getNome() %></td>
    <td><%= t.getCognome() + t.getNome() %></td>
    <td><%= qs.getTitolo() %></td>
    <%if (qs.getUrl().equals("")){ %>
        <td>
    	<form>
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoStudente" accept=".pdf"><br>
  			<input type="submit">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
  <% } %>
</table>
<% 	}

if (tipo.equals("azienda")){ 
ArrayList<QuestionarioAziendaBean> questionariA = (ArrayList<QuestionarioAziendaBean>) request.getSession().getAttribute(""); }
	 if (questionariA.size()>0){ %>
	<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="margin-left: 10%">Tirocinio N.XXXXX</th>
    <th style="margin-left: 10%">Studente</th>
    <th style="margin-left: 10%">Tutor</th>
    <th style="margin-left: 10%">Titolo tirocinio</th>
    <th></th>
  </tr>
  <% for (int i = 0; i < questionariA.size(); i++){
  			QuestionarioAziendaBean qa = questionariA.get(i);
  			StudenteBean s = ();
  			TutorBean t = ();  		
	  %>
  <tr>
    <td>Questionario N.<%=xxx %></td>
    <td><%= s.getCognome() + s.getNome() %></td>
    <td><%= t.getCognome() + t.getNome() %></td>
    <td><%= qa.getTitoloTirocinio()%></td>
   <%if (qa.getUrl().equals("")){ %>
        <td>
    	<form>
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoAzienda" accept=".pdf"><br>
  			<input type="submit">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
  <% } %>
</table>
<% 	} %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>