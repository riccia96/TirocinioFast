<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, Bean.*"%>  
<%
	ArrayList<ConvenzioneBean> convenzioni = (ArrayList<ConvenzioneBean>) request.getSession().getAttribute("richiesteConvenzioni");
	ArrayList<AziendaBean> listaAziende = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende");
	AziendaBean a = new AziendaBean();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%@include file = "navbar.jsp" %>

<%@include file = "menu.jsp" %>


<h3 class="intestazione">Gestione delle richieste di convenzione</h3>
 <% if (convenzioni.size()>0){%>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center;">Richieste di Convenzione</th>
    <th style="text-align: center;">Azienda</th>
    <th></th>
  </tr>
 <%for (int i = 0; i < convenzioni.size(); i++){
  			ConvenzioneBean c = convenzioni.get(i);
  			for (int s = 0; s < listaAziende.size(); s++){
  				a = listaAziende.get(s); 
  				
  				if (c.getAzienda().equals(a.getUsername())){
  					break;
  				}
  			}
  					
	  %>
  <tr>
    <td><a href="GestioneDocumento?azioneDocumento=selezionaConvenzione&idConv=<%=c.getId()%>">RichiestaN<%= c.getId() %></a></td>
    <td><%=a.getNome() %></td>
    <%if(!c.isConvalida()){ %>
    <td>
    	<form action="GestioneDocumento" method="POST">
  			Seleziona PDF richista di convenzione firmata<br>
  			<input type="file" name="nomeFileConvenzione" accept=".pdf"><br>
  			<input type="hidden" name = "idConvenzione" value="<%=c.getId()%>">
  			<input type="submit" name="azioneDocumento" value="uploadConvenzione">
		</form>
</td>
<%} else {%>
<td>Convenzione gi&agrave; caricata! </td>
<%} %>
  </tr>
  <% } %>
  </table>
<% } else { %>
 <script type="text/javascript">
 window.location.href = 'nessunaRisorsa.jsp';
 </script>
 <% } %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>