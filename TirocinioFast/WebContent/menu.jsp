<%@page import="Bean.ImpiegatoBean"%>
 <%@page import="Bean.TutorBean"%>
 <%@page import="Bean.AziendaBean"%>
 <%@page import="Bean.StudenteBean"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Insert title here</title>
 </head>
 <body>
 
  <ul id="menu">
 <%
 StudenteBean currentStudente = (StudenteBean)session.getAttribute("currentSessionStudente");
 if (currentStudente != null){ %>
 	<li><a href="#">Area Personale</a></li>
 	<li><a href="#">Ricerca azienda</a></li>
 	<li><a href="#">Richiesta tirocinio</a></li>
 	<li><a href="#">Registro ore</a></li>
 	<li><a href="#">Questionario</a></li>
 	<li><a href="#">Logout</a></li>	
 <%}
 AziendaBean currentAzienda = (AziendaBean)session.getAttribute("currentSessionAzienda");
 if (currentAzienda != null){ %>
 	<li><a href="#">Area Personale</a></li>
 	<li><a href="#">Convenzione</a></li>
 	<li><a href="#">Richieste tirocinio</a></li>
 	<li><a href="#">Logout</a></li>
 <%} 
 TutorBean currentTutor = (TutorBean)session.getAttribute("currentSessionTutor");
 if (currentTutor != null) { %>
 	<li><a href="#">Area Personale</a></li>
 	<li><a href="#">Richieste tirocinio</a></li>
 	<li><a href="#">Logout</a></li>
 <%} 
 ImpiegatoBean currentImpiegato = (ImpiegatoBean)session.getAttribute("currentSessionImpiegato");
 if (currentImpiegato != null) { %>
 	<li><a href="#">Area Personale</a>
 	<li><a href="#">Richieste tirocinio</a>
 	<li><a href="#">Attività tirocinio</a>
 	<li><a href="#">Convenzioni aziende</a>
 	<li><a href="#">Elenco aziende convenzionate</a>
 	<li><a href="#">Logout</a>
 <%}
 else { %>
 	<li><a href="index.jsp">Home</a>
 	<li><a href="registraAzienda.jsp">Registra azienda</a>
 	<li><a href="registraStudente.jsp">Registra studente</a>
 <%} %>
 
  </ul>
 
  </body>
 </html>