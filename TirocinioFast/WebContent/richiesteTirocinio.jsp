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

<%ArrayList<TirocinioBean> tirocini = (ArrayList<TirocinioBean>) request.getSession().getAttribute(""); %>

<h3 class="intestazione">Gestione delle richieste di tirocinio</h3>

<% if (tirocini.size()>0){
	if (tipo.equals("impiegato")) {
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
	  TirocinioBean t = tirocini.get(i);
	  StudenteBean s = ();
	  TutorBean tu = ();
	  AziendaBean a = ();%>
  <tr>
    <td><a href="mostraPDF.jsp">RichiestaN. <%=xxx %></a></td>
    <td><%=s.getCognome() + s.getNome() %></td>
    <td><%=t.getCognome() + t.getNome() %> </td>
    <td><%=a.getNome() %></td>
    <% if(t.isConvalidaAzienda()==true && t.isConvalidaTutor()==true && t.isConvalidaStudente()==true) { %>
    <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioFirmata" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload</td>
<%} %>
  </tr>
  <%} %>
  </table>
  <%}
 
 if (tipo.equals("azienda")){ %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Tutor</th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  TirocinioBean t = tirocini.get(i);
	  StudenteBean s = ();
	  TutorBean tu = ();%>
  <tr>
    <td><a href="compilazioneCampiAzienda.jsp">RichiestaN. <%=xxx %></a></td>
    <td><%=s.getCognome() + s.getNome() %></td>
    <td><%=tu.getCognome() + tu.getNome() %></td>
    <td>
    	<form action="GestioneTirocinio" method="POST">
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioFirmata" accept=".pdf"><br>
  			<input type="submit" name="inoltroAT">
		</form>
</td>
  </tr>
  <%} %>
</table>
<%} 
 
 if (tipo.equals("tutor")) { %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Studente</th>
    <th style="text-align: center;">Azienda</th>
    <th></th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  TirocinioBean t = tirocini.get(i);
	  StudenteBean s = ();
	  AziendaBean a = ();%>
  <tr>
    <td><a href="mostraPDF.jsp">RichiestaN. <%=xxx %></a></td>
    <td><%=s.getCognome() + s.getNome() %></td>
    <td><%=a.getNome() %></td>
    <% if(t.isConvalidaAzienda()==true) { %>
    <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioTutor" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload</td>
<%} %>
  </tr>
  <%} %>
  </table>
  <%}
 
 if (tipo.equals("studente")){ %>
 <table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richiesta di Inizio Attivit&agrave; di Tirocinio</th>
    <th style="text-align: center;">Azienda</th>
    <th style="text-align: center;">Tutor</th>
    <th style="text-align: center;">Status</th>
    <th></th>
  </tr>
  <% for (int i = 0; i < tirocini.size(); i++){
	  TirocinioBean t = tirocini.get(i);%>
  <tr>
    <td><a href="mostraPDF.jsp"><%=xxx %></a></td>
    <%if (t.isConvalidaAzienda()==true){ %>
    <td><img alt="verde" src="img/verde.png"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
	<%} if (t.isConvalidaTutor()==true){ %>
	<td><img alt="verde" src="img/verde.png"></td>
     <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
    <%} if (t.isConvalidaRichiesta()==true){ %>
    <td><img alt="verde" src="img/verde.png"></td>
    <%} else { %>
    <td><img alt="giallo" src="img/giallo.png"></td>
    <%} if (t.isConvalidaAzienda()==true && t.isConvalidaTutor()==true) { %>
        <td>
    	<form>
  			Seleziona PDF richista inizio attivit&agrave; di tirocinio firmata<br>
  			<input type="file" name="attivitaTirocinioTutor" accept=".pdf"><br>
  			<input type="submit">
		</form>
</td>
<%} else { %>
<td> Appena sar&agrave; possibile potrai effettuare l'upload</td>
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