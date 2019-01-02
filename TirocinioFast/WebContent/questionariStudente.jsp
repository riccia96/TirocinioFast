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

<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th>Tirocinio N.XXXXX</th>
    <th>Studente</th>
    <th>Tutor</th>
    <th>Titolo tirocinio</th>
    <th></th>
    <th>STATUS</th>
  </tr>
  <tr>
    <td>Numero 200</td>
    <td>Mario De Cicco</td>
    <td>Prof.ssa Filomena Ferrucci</td>
    <td>Studio i media server</td>
    <td>
    	<form>
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoAzienda"><br>
  			<input type="submit">
		</form>
		</td>
	<<td>PALLINO</td>
  </tr>
</table>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>