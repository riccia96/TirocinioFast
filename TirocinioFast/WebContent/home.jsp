<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.*"%>
<%
	String tipoUh = (String) request.getSession().getAttribute("tipoUtente");
	StudenteBean sh = new StudenteBean();
	AziendaBean ah = new AziendaBean();
	TutorBean th = new TutorBean();
	ImpiegatoBean ih = new ImpiegatoBean();

	if (tipoUh.equals("studente")) {
		sh = (StudenteBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoUh.equals("azienda")) {
		ah = (AziendaBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoUh.equals("tutor")) {
		th = (TutorBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoUh.equals("impiegato")) {
		ih = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body> 

	<%@include file="navbar.jsp"%>

	<%@include file="menu.jsp"%>

	<%
		if (tipoUh.equals("studente")) {
	%>
	<img style="margin-left: 50%" alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px">

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= sh.getNome() %></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= sh.getCognome() %></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= sh.getMatricola() %></td>
		</tr>
		<tr>
			<td>Luogo nascita</td>
			<td><%= sh.getLuogoNascita() %></td>
		</tr>
		<tr>
			<td>Data nascita</td>
			<td><%= sh.getDataNascita() %></td>
		</tr>
		<tr>
			<td>Indirizzo di residenza</td>
			<td><%= sh.getIndirizzo() %></td>
		</tr>
		<tr>
			<td>Citt&agrave; di residenza</td>
			<td><%= sh.getCitta() %></td>
		</tr>
		<tr>
			<td>Codice Fiscale</td>
			<td><%= sh.getCodiceFiscale() %></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%= sh.getEmail() %></td>
		</tr>
		<tr>
			<td>Telefono</td>
			<td><%= sh.getTelefono() %></td>
		</tr>
	</table>
	<%
		}
		if (tipoUh.equals("azienda")) {
	%>
	 <%if(!(ah.getLogo().equals(""))){%>
 	<img style="margin-left: 35%" alt="Logo"
		src="<%=ah.getLogo()%>" width="500px" height="300px">
 <%} %>
	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome azienda</td>
			<td><%= ah.getNome() %></td>
		</tr>
		<tr>
			<td>Rappresentante</td>
			<td><%= ah.getCeo() %></td>
		</tr>
		<tr>
			<td>Sede</td>
			<td><%= ah.getIndirizzo() %></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%= ah.getEmail() %></td>
		</tr>
		<tr>
			<td>Telefono</td>
			<td><%= ah.getTelefono() %></td>
		</tr>
		<tr>
			<td>Partita Iva</td>
			<td><%= ah.getPartitaIva() %></td>
		</tr>
	</table>
<% if(ah.getLogo().equals("")){ %>
	<div class="new">
	
		<a href="completaScheda.jsp">
		<button id="visualizzaSchedaButton" class=" button" type="submit">Scheda azienda</button></a>
	</div>
	<%} %>
	<%
		}
		if (tipoUh.equals("tutor")) {
	%>
	<img style="margin-left: 50%" alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px">

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= th.getNome()%></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= th.getCognome()%></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= th.getMatricola() %></td>
		</tr>
	</table>

	<%
		}
		if (tipoUh.equals("impiegato")) {
	%>

	<img style="margin-left: 50%" alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px">

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= ih.getNome()%></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= ih.getCognome()%></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= ih.getMatricola()%></td>
		</tr>
	</table>

	<%
		}
	%>

	<%@include file="footer.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>