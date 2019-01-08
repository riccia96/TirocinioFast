<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, Bean.*"%>
    <%
    	ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("tutors");
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

<h3 class="perForm">Compilazione di una richiesta di convenzione</h3>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" action="GestioneConvenzione" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Convenzione" class="avatar">
  </div>

    <input type="text" placeholder="Luogo di nascita del rappresentante" name="luogoNascitaR" required>
	<br>
    <input type="text" placeholder="Data di nascita del rappresentante" name="dataNascitaR" required>
    <br>
    <input type="text" placeholder="Numero dipendenti" name="numeroDipendenti" required>
	<br>
    <input type="text" placeholder="Referente tirocini" name="referente" required>
    <br>
    <input type="text" placeholder="Telefono del referente" name="telefono" required>
    <br>
    <input type="text" placeholder="E-mail del referente" name="email" required>
	<br>
	<label>Descrizione delle attivit&agrave; svolte</label>
    <textarea style= "margin-left: 10%" rows="4" cols="50" name="descrizioneAttivita"></textarea>
    <br>
    <p>Eventuale docente di riferimento</p>
    <select class ="scelte" name="tutor">
    <% for(TutorBean t : tutors){ %><option value="<%=t.getUsername()%>"><%=t.getNome()+" "+t.getCognome()%></option>
    <%} %></select></label>
    <br>
    <div class ="new">
    <button name = "azioneConvenzione" value="richiestaConvenzione" id="convenzioneButton" class=" button" type="submit">Richiedi convenzione</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>