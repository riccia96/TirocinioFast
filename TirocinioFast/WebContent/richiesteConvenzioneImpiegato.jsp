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
    <th>Richieste di Convenzione</th>
    <th>Azienda</th>
    <th></th>
  </tr>
  <tr>
    <td><a href="mostraPDF.jsp">RichiestaNxxxxxx</a></td>
    <td>NAMIRIAL SPA</td>
    <td>
    	<form>
  			Seleziona PDF richista di convenzione firmata<br>
  			<input type="file" name="attivitaTirocinio"><br>
  			<input type="submit">
		</form>
</td>
  </tr>
  </table>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>