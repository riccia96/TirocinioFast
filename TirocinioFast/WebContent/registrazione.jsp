<%@page import="Bean.AziendaBean"%>
<%@page import="Bean.StudenteBean"%>
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

<div style="margin-left:25%;height:1200px;width: 700px;">

  
<form class="dialogo" name="form" id="registrazione" action="GestioneUtente" method="POST" style="position:absolute;width: 700px;">
 	
 	<input type="radio" name="tipo" value="studente" id="radioS" onclick="myAccFunc()">Studente
	<input type="radio" name="tipo" value="azienda" id="radioA" onclick="myAccFunc()">Azienda
 
  <div class="imgcontainer">
    <img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
  </div>
	
    <input type="text" placeholder="Nome" name="nome" required id="nomeStudente">

	<input type="text" placeholder="Nome azienda" name="nome" required id="nomeAzienda">
	
    <div class ="new">
    <button name = "azioneUtente" value="registrati" id="registratiButton" class=" button" type="submit">Registrati</button> 
  </div>

</form>
  
</div>


<%@include file = "footer.jsp" %>

<script>

$(document).ready(function(){
	$("#nomeAzienda").hide();
});


function myAccFunc() {
    var x = document.getElementById("radioA");
    var y = document.getElementById("radioS");
    if(x.checked) {
   	 	$("#nomeAzienda").show();
		$("#nomeStudente").hide();
    }
    if(y.checked) {
   	 	$("#nomeAzienda").hide();
		$("#nomeStudente").show();
    }
}
</script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>