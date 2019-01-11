<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.*"%>
<%

	String tipoUm = (String) request.getSession().getAttribute("tipoUtente");
	
		if (tipoUm.equals("studente")) {
			StudenteBean sm = (StudenteBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipoUm.equals("azienda")) {
			AziendaBean am = (AziendaBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipoUm.equals("tutor")) {
			TutorBean tm = (TutorBean) request.getSession().getAttribute("utenteSessione");
		}
		if (tipoUm.equals("impiegato")) {
			ImpiegatoBean im = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
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
			if (tipoUm.equals("studente")) {
		%>
		<li><a href="GestioneUtente?azioneUtente=areaPersonale">Area Personale</a></li>
		<li><a href="GestioneTirocinio?azioneTirocinio=elencoAziende">Ricerca azienda</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio">Richiesta tirocinio</a></li>
		<li><a href="GestioneTirocinio?azioneTirocinio=attivitaConvalidate">Tirocini conclusi</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=registroOre">Registro ore</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=questionarioStudente">Questionario</a></li>
		<li><a href="GestioneUtente?azioneUtente=logout">Logout</a></li>
		<%
			}
			if (tipoUm.equals("azienda")) {
		%>
		<li><a href="GestioneUtente?azioneUtente=areaPersonale">Area Personale</a></li>
		<li><a href="GestioneConvenzione?azioneConvenzione=apriForm">Convenzione</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio">Richieste tirocinio</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=questionarioAzienda">Questionari</a>
		<li><a href="GestioneUtente?azioneUtente=logout">Logout</a></li>
		<%
			}
			if (tipoUm.equals("tutor")) {
		%>
		<li><a href="GestioneUtente?azioneUtente=areaPersonale">Area Personale</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio">Richieste tirocinio</a></li>
		<li><a href="GestioneUtente?azioneUtente=logout">Logout</a></li>
		<%
			}
			if (tipoUm.equals("impiegato")) {
		%>
		<li><a href="GestioneUtente?azioneUtente=areaPersonale">Area Personale</a>
		<li><a href="GestioneDocumento?azioneDocumento=elencoRichiesteTirocinio">Richieste tirocinio</a>
		<li><a href="GestioneDocumento?azioneDocumento=tirociniConclusi">Attività tirocinio</a>
		<li><a href="GestioneDocumento?azioneDocumento=attivitaConvalidate">Tirocini conclusi</a></li>
		<li><a href="GestioneDocumento?azioneDocumento=elencoRichiesteConvenzioni">Convenzioni aziende</a>
		<li><a href="GestioneDocumento?azioneDocumento=convenzioniConvalidate">Convenzioni accettate</a></li>
		<li><a href="GestioneTirocinio?azioneTirocinio=elencoAziende">Elenco aziende convenzionate</a>
		<li><a href="GestioneUtente?azioneUtente=logout">Logout</a> <%
 	} %>
	</ul>

</body>
</html>