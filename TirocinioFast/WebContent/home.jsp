<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	String tipoU = (String) request.getSession().getAttribute("tipoUtente");
	StudenteBean s = new StudenteBean();
	AziendaBean a = new AziendaBean();
	TutorBean t = new TutorBean();
	ImpiegatoBean i = new ImpiegatoBean();

	if (tipoU.equals("studente")) {
		s = (StudenteBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoU.equals("azienda")) {
		a = (AziendaBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoU.equals("tutor")) {
		t = (TutorBean) request.getSession().getAttribute("utenteSessione");
	}
	if (tipoU.equals("impiegato")) {
		i = (ImpiegatoBean) request.getSession().getAttribute("utenteSessione");
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

	

	<%
		if (tipoU.equals("studente")) {
	%>
	<a href="index.jsp" style="margin-left: 50%"><img alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px"></a>

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= s.getNome() %></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= s.getCognome() %></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= s.getMatricola() %></td>
		</tr>
		<tr>
			<td>Luogo nascita</td>
			<td><%= s.getLuogoNascita() %></td>
		</tr>
		<tr>
			<td>Data nascita</td>
			<td><%= s.getDataNascita() %></td>
		</tr>
		<tr>
			<td>Indirizzo di residenza</td>
			<td><%= s.getIndirizzo() %></td>
		</tr>
		<tr>
			<td>Citt&agrave; di residenza</td>
			<td><%= s.getCitta() %></td>
		</tr>
		<tr>
			<td>Codice Fiscale</td>
			<td><%= s.getCodiceFiscale() %></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%= s.getEmail() %></td>
		</tr>
		<tr>
			<td>Telefono</td>
			<td><%= s.getTelefono() %></td>
		</tr>
	</table>
	<%
		}
		if (tipoU.equals("azienda")) {
	%>
	<a href="index.jsp" style="margin-left: 35%"><img alt="Logo"
		src="img\timthumb.png" width="500px" height="300px"></a>

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome azienda</td>
			<td><%= a.getNome() %></td>
		</tr>
		<tr>
			<td>Rappresentante</td>
			<td><%= a.getCeo() %></td>
		</tr>
		<tr>
			<td>Sede</td>
			<td><%= a.getIndirizzo() %></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%= a.getEmail() %></td>
		</tr>
		<tr>
			<td>Telefono</td>
			<td><%= a.getTelefono() %></td>
		</tr>
		<tr>
			<td>Partita Iva</td>
			<td><%= a.getPartitaIva() %></td>
		</tr>
	</table>

	<div class="new">
		<button name="azioneUtente" value="visualizzaScheda"
			id="visualizzaSchedaButton" class=" button" type="submit">Scheda
			aziendale</button>
	</div>
	<%
		}
		if (tipoU.equals("tutor")) {
	%>
	<a href="index.jsp" style="margin-left: 50%"><img alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px"></a>

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= t.getNome()%></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= t.getCognome()%></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= t.getMatricola() %></td>
		</tr>
	</table>

	<%
		}
		if (tipoU.equals("impiegato")) {
	%>

	<a href="index.jsp" style="margin-left: 50%"><img alt="Logo"
		src="img\avatar-default-icon.png" width="150px" height="150px"></a>

	<table style="margin-left: 30%; width: 700px;">
		<tr>
			<td>Nome</td>
			<td><%= i.getNome()%></td>
		</tr>
		<tr>
			<td>Cognome</td>
			<td><%= i.getCognome()%></td>
		</tr>
		<tr>
			<td>Matricola</td>
			<td><%= i.getMatricola()%></td>
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