<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="bean.*"%>
<%
	TirocinioBean tirocinio = new TirocinioBean();
	QuestionarioStudenteBean questionarioStudente = new QuestionarioStudenteBean();
	QuestionarioAziendaBean questionarioAzienda = new QuestionarioAziendaBean();
	String convalida = (String) request.getSession().getAttribute("convalida");
	ConvenzioneBean convenzione = new ConvenzioneBean();
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(convalida.equals("tirocinio")){ 
tirocinio = (TirocinioBean) request.getSession().getAttribute("tirocinio");
questionarioStudente = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
questionarioAzienda = (QuestionarioAziendaBean) request.getSession().getAttribute("questionarioAzienda");%>
<embed width="100%" height="550px" src="<%= tirocinio.getUrl() %>">
<embed width="100%" height="550px" src="<%= tirocinio.getRegistroOre() %>">
<embed width="100%" height="550px" src="<%= questionarioStudente.getUrl() %>">
<embed width="100%" height="550px" src="<%= questionarioAzienda.getUrl() %>">

<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;">
	<form action="GestioneDocumento" method="POST">
	<input type="hidden" name="idTirocinio" value="<%= tirocinio.getId() %>">
	<input type="hidden" name="tipo" value="tirocinio">
    <button name = "azioneDocumento" value="accettaAttivita" id="accettaAttivitaButton" class=" button" type="submit" style="background-color: orange;color: white; padding: 14px 20px; margin: 8px 0; margin-bottom: 10px; border: none; cursor: pointer; color: black;">Conferma fine attività di tirocinio</button> 
	</form>
</div>
<%} else {
convenzione = (ConvenzioneBean) request.getSession().getAttribute("doc");%>
<embed width="100%" height="550px" src="<%= convenzione.getUrl() %>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;">
	<form action="GestioneDocumento" method="POST">
	<input type="hidden" name="idConvenzione" value="<%= convenzione.getId() %>">
	<input type="hidden" name="tipo" value="convenzione">
    <button name = "azioneDocumento" value="accettaAttivita" id="accettaAttivitaButton" class=" button" type="submit" style="background-color: orange;color: white; padding: 14px 20px; margin: 8px 0; margin-bottom: 10px; border: none; cursor: pointer; color: black;">Conferma fine attività di tirocinio</button> 
	</form>
</div>
<%} %>

</body>
</html>