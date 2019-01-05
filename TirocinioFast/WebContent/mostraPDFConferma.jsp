<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	TirocinioBean tirocinio = (TirocinioBean) request.getSession().getAttribute("tirocinio");
	
	QuestionarioStudenteBean questionarioStudente = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
	
	QuestionarioAziendaBean questionarioAzienda = (QuestionarioAziendaBean) request.getSession().getAttribute("questionarioAzienda");

 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<embed width="100%" height="550px" src="<%= tirocinio.getUrl() %>">
<embed width="100%" height="550px" src="<%= tirocinio.getRegistroOre() %>">
<embed width="100%" height="550px" src="<%= questionarioStudente.getUrl() %>">
<embed width="100%" height="550px" src="<%= questionarioAzienda.getUrl() %>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;">
	<form action="GestioneTirocinio" method="POST">
	<input type="hidden" name="idTirocinio" value="<%= tirocinio.getId() %>">
    <button name = "azioneTirocinio" value="accettaAttivita" id="accettaAttivitaButton" class=" button" type="submit" style="background-color: orange;color: white; padding: 14px 20px; margin: 8px 0; margin-bottom: 10px; border: none; cursor: pointer; color: black;">Conferma fine attività di tirocinio</button> 
	</form>
</div>

</body>
</html>