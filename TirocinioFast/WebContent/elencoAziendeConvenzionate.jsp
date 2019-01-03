<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ page import="java.util.ArrayList" %>
<%@ page import="Bean.*" %>
<%@ page import="Model.*" %>
<%@ page import="java.sql.*" %> 
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aziende Convenzionate</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>

<%@include file = "ricerca.jsp" %>

<% ArrayList<AziendaBean> convenzioni = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende");

			 if (convenzioni.size()>0 && convenzioni.size()%2==0) { %>
						<% for(int i = 0; i < convenzioni.size()/2 ; i++) { %>
							<div class="contenitore">	
							<% for(int j=0; j < 2 && (j+(i*2))<convenzioni.size() ; j++) { 
							AziendaBean a = convenzioni.get(j+(i*2));  %>
							<div class="card">
							<img class="card__image" src="<%= a.getLogo() %>" alt="<%= a.getNome() %>">
							<div class="card__copy">
							<h3>"<%= a.getNome() %>"</h3>
							<p><%= a.getIndirizzo() %></p>
							<p><%= a.getDescrizione() %></p>
							<button name = "azioneUtente" value="visualizzaScheda" id="visualizzaSchedaButton" class=" button" type="submit">Visualizza scheda azienda</button> 
							</div>
							</div>
							<% } %>
							</div>
					<% } %>
					<% } 
					if (convenzioni.size()>0 && convenzioni.size()%2!=0) { %>
					<% for(int i = 0; i < convenzioni.size()/2 +1 ; i++) { %>
							<div class="contenitore">
							<% for(int j=0; j < 2 && (j+(i*2))<convenzioni.size() ; j++) { 
							AziendaBean a = convenzioni.get(j+(i*2));  %>
							<div class="card">
							<img class="card__image" src="<%= a.getLogo() %>" alt="<%= a.getNome() %>">
							<div class="card__copy">
							<h3>"<%= a.getNome() %>"</h3>
							<p><%= a.getIndirizzo() %></p>
							<p><%= a.getDescrizione() %></p>
							<button name = "azioneUtente" value="visualizzaScheda" id="visualizzaSchedaButton" class=" button" type="submit">Visualizza scheda azienda</button> 
							</div>
							</div>
							<% } %>
							</div>>
					<% } %>
					<% } %>
					
					<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
					
		