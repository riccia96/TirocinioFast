<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%ArrayList<TirocinioBean> tirocini = (ArrayList<TirocinioBean>) request.getSession().getAttribute("listaTirociniConclusi"); %>
<%ArrayList<AziendaBean> aziende = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende"); %>
<%ArrayList<StudenteBean> studenti = (ArrayList<StudenteBean>) request.getSession().getAttribute("listaStudenti"); %>
<%ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("listaTutors");
StudenteBean studente = new StudenteBean();
AziendaBean azienda = new AziendaBean();
TutorBean tutor = new TutorBean();
TirocinioBean tirocinio = new TirocinioBean();
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

<h3 class="intestazione">Gestione dei tirocini conclusi</h3>

<% if (tirocini.size()>0){
	if (tipoUm.equals("impiegato")) {
	%>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Azienda</th>
    <th style="text-align: center;">Tutor</th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  tirocinio = tirocini.get(i);
	  for (int s=0; s<studenti.size(); s++){
		  studente = studenti.get(s);
		  
		  if (tirocinio.getStudente().equals(studente.getUsername())){
			  break;
		  }
	  }
	  
	  for (int t = 0; t < tutors.size(); t++){
		  tutor = tutors.get(t);
		  
		  if(tirocinio.getTutorAccademico().equals(tutor.getUsername())){
			  break;
		  }
	  }
	  
	  for (int a = 0; a < aziende.size(); a++){
		  azienda = aziende.get(a);
		  
		  if (tirocinio.getAzienda().equals(azienda.getUsername())){
			  break;
		  }
	  }
	  %>
  <tr>
    <td><a href="#">RichiestaN.<%=tirocinio.getId() %></a></td>
    <td><%=studente.getCognome() + " " + studente.getNome() %></td>
    <td>Prof/Prof.ssa <%=tutor.getCognome() + tutor.getNome() %> </td>
    <td><%=azienda.getNome() %></td>
  </tr>
  <%} %>
  </table>
  <%}
 
  if (tipoUm.equals("studente")){ %>
 <table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di Inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Azienda</th>
    <th style="text-align: center;">Tutor</th>
    <th style="text-align: center;">Status</th>
    <th></th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  tirocinio = tirocini.get(i);
	  
	  for (int t = 0; t < tutors.size(); t++){
		  tutor = tutors.get(t);
		  
		  if(tirocinio.getTutorAccademico().equals(tutor.getUsername())){
			  break;
		  }
	  }
	  
	  for (int a = 0; a < aziende.size(); a++){
		  azienda = aziende.get(a);
		  
		  if (tirocinio.getAzienda().equals(azienda.getUsername())){
			  break;
		  }
	  } %>
  <tr>
    <td><a href="#">RichiestaN.<%=tirocinio.getId() %></a></td>
    <%if (tirocinio.isConvalidaAzienda()==true){ %>
    <td><img alt="verde" src="img/verde.png"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
	<%} if (tirocinio.isConvalidaTutor()==true){ %>
	<td><img alt="verde" src="img/verde.png"></td>
     <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
    <%} if (tirocinio.isConvalidaRichiesta()==true){ %>
    <td><img alt="verde" src="img/verde.png"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
  </tr>
  <%} %>
  </table>
 <%} 
  } 
 } else {%>
  <script type="text/javascript">
 var r=alert("Non sono presenti tirocini conclusi");
 window.location.href = 'home.jsp';
 </script>
  <% } %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>