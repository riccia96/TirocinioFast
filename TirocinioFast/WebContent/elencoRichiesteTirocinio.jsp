<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%ArrayList<TirocinioBean> tirocini = (ArrayList<TirocinioBean>) request.getSession().getAttribute("richiesteTirocinio"); %>
<%ArrayList<AziendaBean> aziende = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende"); %>
<%ArrayList<StudenteBean> studenti = (ArrayList<StudenteBean>) request.getSession().getAttribute("listaStudenti"); %>
<%ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("listaTutor");
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

<h3 class="intestazione">Gestione delle richieste di tirocinio</h3>

<% if (tirocini.size()>0){
	if (tipoUm.equals("impiegato")) {
	%>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richieste di inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Azienda</th>
    <th style="text-align: center;">Tutor</th>
    <th></th>
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
    <% if(tirocinio.isConvalidaAzienda()==true && tirocinio.isConvalidaTutor()==true && tirocinio.isConvalidaStudente()==true && tirocinio.isConvalidaRichiesta()==false) { %>
    <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioFirmata" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload o richiesta gi&agrave; caricata</td>
<%} %>
  </tr>
  <%} %>
  </table>
  <%}
 
 if (tipoUm.equals("azienda")){ %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Tutor</th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  
	  for (int s=0; s<studenti.size(); s++){
		  studente = studenti.get(s);
		  
		  if (tirocini.get(i).getStudente().equals(studente.getUsername())){
			  break;
		  }
	  }
	  
	  for (int t = 0; t < tutors.size(); t++){
		  tutor = tutors.get(t);
		  
		  if(tirocini.get(i).getTutorAccademico().equals(tutor.getUsername())){
			  break;
		  }
	  }
	  %>
  <tr>
    <td><a href="GestioneTirocinio?azioneTirocinio=compilaAzienda&idTiro=<%=tirocinio.getId() %>">RichiestaN.<%=tirocinio.getId() %></a></td>
    <td><%=studente.getCognome() +  " " + studente.getNome() %></td>
    <td>Prof/Prof.ssa <%=tutor.getCognome() + " " + tutor.getNome() %></td>
    <%if (tirocinio.isConvalidaAzienda()==false){ %>
    <td>
    	<form action="GestioneTirocinio" method="POST">
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioFirmata" accept=".pdf"><br>
  			<input type="submit" name="inoltroAT">
		</form>
</td>
<%} else { %>
  <td> Campi gi&agrave; compilati </td>
  <%} %>
  </tr>
  <%} %>
</table>
<%} 
 
 if (tipoUm.equals("tutor")) { %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Azienda</th>
    <th></th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  tirocinio = tirocini.get(i);
	  for (int s=0; s<studenti.size(); s++){
		  studente = studenti.get(s);
		  
		  if (tirocinio.getStudente().equals(studente.getUsername())){
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
    <td><%=studente.getCognome() + " " + studente.getNome() %></td>
    <td><%=azienda.getNome() %></td>
    <% if(tirocinio.isConvalidaAzienda()==true && tirocinio.isConvalidaTutor()==false) { %>
    <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioTutor" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload  o richiesta gi&agrave; caricata</td>
<%} %>
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
    <td><img alt="verde" src="img/verde.png" width="50px" height="50px"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png" width="50px" height="50px"></td>
	<%} if (tirocinio.isConvalidaTutor()==true){ %>
	<td><img alt="verde" src="img/verde.png" width="50px" height="50px"></td>
     <%} else { %>
    <td><img alt="giallo" src="img/giallo.png" width="50px" height="50px"></td>
    <%} if (tirocinio.isConvalidaRichiesta()==true){ %>
    <td><img alt="verde" src="img/verde.png" width="50px" height="50px"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png" width="50px" height="50px"></td>
    <%} if (tirocinio.isConvalidaAzienda()==true && tirocinio.isConvalidaTutor()==true && tirocinio.isConvalidaStudente()==false) { %>
        <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioTutor" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload  o richiesta gi&agrave; caricata</td>
<%} %>
  </tr>
  <%} %>
  </table>
 <%}
 }%>
  

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>