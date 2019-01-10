<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList, Bean.*"%>
<%
	ArrayList<AziendaBean> convenzionate = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Aziende Convenzionate</title>
<link rel="stylesheet" href="css/aziendeConvenzionate.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@include file="navbar.jsp"%>

	<%@include file="menu.jsp"%>

	<%@include file="ricerca.jsp"%>
	
	<%if (convenzionate.size() > 0){ %>

<div id = "contenitore" style="margin-left: 25%;" >
<table>

<td></td>
<td></td>
<td></td>
<% for(AziendaBean a: convenzionate){ %>
<tr>

<figure class="azienda-figure"><div class="images"><img src="<%=a.getLogo()%>" alt="images-azienda"/></div>
 
  <figcaption>
    <a href="GestioneTirocinio?azioneTirocinio=schedaAzienda&scheda=<%=a.getUsername()%>" class="c"><h3><%=a.getNome()%></h3></a>
    <p><%=a.getDescrizione()%></p>
    <div class="sede">
      <%=a.getIndirizzo()%>
    </div>
  </figcaption>
</figure>
</tr>
<%} %>
</div>
</table>
<%} else { %>
 <script type="text/javascript">
 window.location.href = 'nessunaRisorsa.jsp';
 </script>
 <% } %>
<%@include file="footer.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>

