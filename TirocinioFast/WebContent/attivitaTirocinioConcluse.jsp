<%@page import="Control.ManagerUtente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bean.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%ArrayList<TirocinioBean> conclusi = (ArrayList<TirocinioBean>) request.getSession().getAttribute("listaTirociniConclusi");
ArrayList<StudenteBean> studenti = (ArrayList<StudenteBean>) request.getSession().getAttribute("listaStudenti");
ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("listaTutors");
ArrayList<AziendaBean> aziende = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende");
StudenteBean studente = new StudenteBean();
AziendaBean azienda = new AziendaBean();
TutorBean tutor = new TutorBean();
TirocinioBean tirocinio = new TirocinioBean();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>


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
	  tirocinio = conclusi.get(i);
	  	for (int s = 0; s < studenti.size(); s++){
	  		studente = studenti.get(s);
	  		if(tirocinio.getStudente().equals(studente.getUsername())){
	  			break;
	  		}
	  	}
	  	for (int t = 0; t< tutors.size();t++){
	  		tutor = tutors.get(t);
	  		if(tirocinio.getTutorAccademico().equals(tutor.getUsername())){
	  			break;
	  		}
	  	}
	  	for (int b = 0; b<aziende.size(); b++){
	  		azienda = aziende.get(b);
	  		if(tirocinio.getAzienda().equals(azienda.getUsername())){
	  			break;
	  		}
	  	}
	  %>
  <tr>
    <td><a href="GestioneTirocinio?azioneTirocinio=selezionaAttivita?idTirocinio=<%= tirocinio.getId()%>"> RichiestaN.<%= tirocinio.getId()%></a></td>
    <td><%= studente.getCognome() + " " + studente.getNome() %></td>
    <td>Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %> </td>
    <td><%= azienda.getNome() %></td>
  </tr>
  <%} %>
  </table>
<% } 
else { %>
 <script type="text/javascript">
 window.location.href = 'nessunaRisorsa.jsp';
 </script> 
 <% } %>
<%@include file = "footer.jsp" %>

<script src="js/bootstrap.min.js"></script>
</body>
</html>