<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	String tipoDocumento = (String) request.getSession().getAttribute("tipoDocumento");
	ConvenzioneBean convenzione = new ConvenzioneBean();
	TirocinioBean tirocinio = new TirocinioBean();
	QuestionarioAziendaBean questionarioA = new QuestionarioAziendaBean();
	QuestionarioStudenteBean questionarioS = new QuestionarioStudenteBean();
	if(tipoDocumento.equals("convenzione")){
		convenzione = (ConvenzioneBean) request.getSession().getAttribute("pdfConv");
	} else if(tipoDocumento.equals("tirocinio")){
    	tirocinio = (TirocinioBean) request.getSession().getAttribute("richiesta");
	} else if(tipoDocumento.equals("questionarioAzienda")){
    	questionarioA = (QuestionarioAziendaBean) request.getSession().getAttribute("questionarioAzienda");
	} else if(tipoDocumento.equals("questionarioStudente")){
    	questionarioS = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%if(tipoDocumento.equals("convenzione")){%>
<title>Documento convenzione</title>
</head>
<body>
<%if(!convenzione.getUrl().equals("")){ %>
<embed width="100%" height="550px" src="<%= convenzione.getUrl()%>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;"> 
</div>
<%} %>
</body>
<%} %>
<%if(tipoDocumento.equals("tirocinio")){ %>
<title>Documento tirocinio</title>
</head>
<body>
<%if(!tirocinio.getUrl().equals("")){ %>
<embed width="100%" height="550px" src="<%= tirocinio.getUrl()%>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;"> 
</div>
<%} %>
</body>
<%} %>
<%if(tipoDocumento.equals("questionarioStudente")){ %>
<title>Documento questionario studente</title>
</head>
<body>
<%if(!questionarioS.getUrl().equals("")){ %>
<embed width="100%" height="550px" src="<%= questionarioS.getUrl()%>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;"> 
</div>
<%} %>
</body>
<%} %>
<%if(tipoDocumento.equals("questionarioAzienda")){ %>
<title>Documento questionario azienda</title>
</head>
<body>
<%if(!questionarioA.getUrl().equals("")){ %>
<embed width="100%" height="550px" src="<%= questionarioA.getUrl()%>">
<div style="text-align: center; margin-bottom: 10px; margin-left: 10%; margin-top: 40px;"> 
</div>
<%} %>
</body>
<%} %>
</html>