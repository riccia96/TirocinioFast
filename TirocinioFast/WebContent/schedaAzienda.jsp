<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Bean.*"%>
<%
	AziendaBean a = (AziendaBean) request.getSession().getAttribute("aziendaSelezionata");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Scheda Azienda</title>
</head>
<body>

	<%@include file="navbar.jsp"%>

	<%@include file="menu.jsp"%>
	
<div id = "contenitore">	
	<figure class="azienda-figure"><div class="images"><img src="<%=a.getLogo()%>" alt="images-azienda"/></div>
 
  <figcaption>
    <h3><%=a.getNome()%></h3>
    <p><%=a.getDescrizione()%></p>
    <div class="sede">
      <%=a.getIndirizzo()%>
    </div>
  </figcaption>
  <form action="GestioneTirocinio" method="POST">
  <input type="hidden" name="aziendaSelezionata" value="<%=a.getUsername()%>">
  <button name ="azioneTirocinio" value="inoltraRichiesta" type="submit">Invia richiesta </button> </form>
</figure>
</div>
<%@include file="footer.jsp"%>
</body>
</html>