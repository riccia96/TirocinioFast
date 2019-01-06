<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	ConvenzioneBean convenzione = (ConvenzioneBean) request.getSession().getAttribute("pdfConv");
    TirocinioBean tirocinio = (TirocinioBean) request.getSession().getAttribute("richiesta");
    String tipoDocumento = (String) request.getSession().getAttribute("tipoDocumento");
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
</html>