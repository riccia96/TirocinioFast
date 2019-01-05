<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 	ArrayList<TirocinioBean> disponibiliRegistro = (ArrayList<TirocinioBean>)request.getSession().getAttribute("registroDisponibili");
	ArrayList<AziendaBean> aziende = (ArrayList<AziendaBean>)request.getSession().getAttribute("listaAziende");
	ArrayList<TutorBean> tutors = (ArrayList<TutorBean>)request.getSession().getAttribute("listaTutor");
	TirocinioBean tirocinio = new TirocinioBean();
	AziendaBean azienda = new AziendaBean();
	TutorBean tutor = new TutorBean();
%>
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

<% %>

<h3 class="intestazione">Gestione del registro</h3>
<% if (disponibiliRegistro.size()>0){ %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Registro ore relativo all'Attivit&agrave; di Tirocinio (DOWNLOAD SOLO QUANDO RICHIESTA ACCETTATA)</th>
    <th style="text-align: center">Azienda</th>
    <th style="text-align: center">Tutor</th>
    <th></th>
  </tr>
  		<%for (int i = 0; i < disponibiliRegistro.size(); i++){
  			 	tirocinio = disponibiliRegistro.get(i);
  					
  			 	for (int a = 0; a < aziende.size(); a++){
  					azienda = aziende.get(a);
  					if (tirocinio.getAzienda().equals(azienda.getUsername())){
  						break;
  						}
  					}
  			 	
  			 	for (int t = 0; t < tutors.size(); t++){
  			 		tutor = tutors.get(t);
  			 		if (tirocinio.getTutorAccademico().equals(tutor.getUsername())){
  			 			break;
  			 		}
  			 	}
	  %>
  <tr>
    <td><a href="documentoRegistroOre.jsp">Attivit&agrave; di Tirocinio N.<%=tirocinio.getId() %></a></td>
    <td><%= azienda.getNome() %></td>
    <td>Prof/Prof.ssa<%= tutor.getCognome() + " " + tutor.getNome() %></td>
    <%if (tirocinio.getRegistroOre().equals("")){ %>
    <td>
    	<form>
  			Seleziona PDF del registro ore completato<br>
  			<input type="file" name="registroOre" accept=".pdf"><br>
  			<input type="submit">
		</form>
	</td>
	<%} else { %>
	<td>Registro ore gi&agrave; presentato!</td>
  </tr>
  <%} %>
  </table>
<%} %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>