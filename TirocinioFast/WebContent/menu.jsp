<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Bean.*"%>
<%

	String tipo = (String) request.getSession().getAttribute("tipoUtente");
	
		if (tipo.equals("studente")) {
			StudenteBean s = (StudenteBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipo.equals("azienda")) {
			AziendaBean a = (AziendaBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipo.equals("tutor")) {
			TutorBean s = (TutorBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipo.equals("impiegato")) {
			ImpiegatoBean a = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
		}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

	<ul id="menu">
		<%
			if (tipo.equals("studente")) {
		%>
		<li><a href="Gestioneutente?azioneUtente=areaPersonale">Area Personale</a></li>
		<li><a href="GestioneTirocinio?azioneTirocinio=elencoAziende">Ricerca azienda</a></li>
		<li><a href="#">Richiesta tirocinio</a></li>
		<li><a href="#">Registro ore</a></li>
		<li><a href="#">Questionario</a></li>
		<li><a href="GestioneUtente?azioneUtente=logout">Logout</a></li>
		<%
			}
			if (tipo.equals("azienda")) {
		%>
		<li><a href="Gestioneutente?azioneUtente=areaPersonale">Area Personale</a></li>
		<li><a href="#">Convenzione</a></li>
		<li><a href="#">Richieste tirocinio</a></li>
		<li><a href="#">Logout</a></li>
		<%
			}
			if (tipo.equals("tutor")) {
		%>
		<li><a href="#">Area Personale</a></li>
		<li><a href="#">Richieste tirocinio</a></li>
		<li><a href="#">Logout</a></li>
		<%
			}
			if (tipo.equals("impiegato")) {
		%>
		<li><a href="#">Area Personale</a>
		<li><a href="#">Richieste tirocinio</a>
		<li><a href="#">Attività tirocinio</a>
		<li><a href="#">Convenzioni aziende</a>
		<li><a href="#">Elenco aziende convenzionate</a>
		<li><a href="#">Logout</a> <%
 	} %>
	</ul>

</body>
</html>