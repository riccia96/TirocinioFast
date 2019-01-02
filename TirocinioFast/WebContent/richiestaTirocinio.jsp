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

<div style="margin-left:25%;width: 700px;">
<form class="dialogo" id="richiestaTirocinio" action="GestioneUtente" method="POST">
  <div class="imgcontainer">
    <img src="img\convenzione.png" alt="Convenzione" class="avatar">
  </div>

    <input type="text" placeholder="Anno accademico" name="anno" required>
	<br>
    <input style="width: 80%; padding: 12px 20px; margin: 8px 0; margin-left: 10%; display: inline-block; border: 1px solid #ccc; box-sizing: border-box;" type="number" placeholder="CFU tirocinio" name="cfu" required>
    <br>
    <label>Tutor accademico
    <select name="tutor" style="margin-left: 25%;"><option value="nomeTutor">Prof.ssa Ferrucci Filomena</option></select></label>
    <br>
    <label>Handicap?
    <input style="margin-left: 40%" type="radio" name="tutor" value="si">SI
    <input type="radio" name="tutor" value="no" checked>NO
    </label>
    <br>
    <div class ="new">
    <button name = "azioneUtente" value="richiestaTirocinio" id="richiestaTirocinioButton" class=" button" type="submit">Richiedi inizio attivit&agrave; tirocinio</button> 
    </div>
</form>
  
</div>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>