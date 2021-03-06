<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, bean.*"%>
 <%
 	ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("elencoTutor");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Compilazione Richiesta Tirocinio Studente</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<h3 class="perForm">Compilazione di una richista di tirocinio</h3>

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="richiestaTirocinio" action="GestioneDocumento" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Convenzione" class="avatar">
  </div>

    <input type="text" placeholder="Anno accademico" name="annoAccademico" required>
	<br>
	<label style="margin-left: 10%">CFU</label><select style="padding-left: 15px; margin-left: 1%;" name="cfu"><option value="5">5</option><option value="6">6</option><option value="11">11</option><option value="12">12</option><option value="17">17</option><option value="18">18</option></select>    <br>
    <p class="question" style="margin-top: 2%">Tutor accademico</p>
    
    <select class ="scelte" name="tutor">
    <% for(TutorBean t : tutors){ %><option value="<%=t.getUsername()%>"><%=t.getNome()+" "+t.getCognome()%></option>
    <%} %></select></label>
    <br>
    <p class="question" style="margin-top: 2%">Handicap?</p>
    <input style="margin-left: 10%" type="radio" name="handicap" value="si">SI
    <input type="radio" name="handicap" value="no" checked>NO
    <br>
    <div class ="new">
    <button name = "azioneDocumento" value="compilaTirocinioStudente" id="richiestaTirocinioButton" class=" button" type="submit">Richiedi inizio attivit&agrave; tirocinio</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="js/bootstrap.min.js"></script>

</body>
</html>