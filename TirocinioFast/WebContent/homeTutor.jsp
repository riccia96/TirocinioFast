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

<a href="homeStudente.jsp" style="margin-left:50%"><img alt="Logo" src="img\avatar-default-icon.png" width="150px" height="150px"></a>

<table style="margin-left:30%; width: 700px;">
  <tr>
    <td>Nome </td>
    <td>NOME</td>
  </tr>
  <tr>
    <td>Cognome</td>
    <td>COGNOME</td>
  </tr>
  <tr>
    <td>Matricola</td>
    <td>MATRICOLA</td>
  </tr>
</table>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>