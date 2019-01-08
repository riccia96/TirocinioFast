<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Bean.*" %>
<% String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");

if(tipoUtente.equals("studente")){
	QuestionarioStudenteBean questionarioStud = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
}else{
	ArrayList<QuestionarioStudenteBean> questionariS = (ArrayList<QuestionarioStudenteBean>) request.getSession().getAttribute("");
}
ArrayList<QuestionarioAziendaBean> questionariA = (ArrayList<QuestionarioAziendaBean>) request.getSession().getAttribute("");
ArrayList<TirocinioBean> tirocini = (ArrayList<TirocinioBean>) request.getSession().getAttribute("listaTirocini");
ArrayList<StudenteBean> studenti = (ArrayList<StudenteBean>) request.getSession().getAttribute("listaStudenti");
ArrayList<TutorBean> tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("listaTutors");
ArrayList<AziendaBean> aziende = (ArrayList<AziendaBean>) request.getSession().getAttribute("listaAziende");
StudenteBean studente = new StudenteBean();
AziendaBean azienda = new AziendaBean();
TutorBean tutor = new TutorBean();
TirocinioBean tirocinio = new TirocinioBean();
QuestionarioStudenteBean qs = new QuestionarioStudenteBean();
QuestionarioAziendaBean qa = new QuestionarioAziendaBean();%>

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

<h3 class="intestazione">Gestione dei questionari valutativi</h3>

<% if (tipoUm.equals("studente")){ %>
  <% if (questionariS.size()>0){ %>
<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Questionario</th>
    <th style="text-align: center">Azienda</th>
    <th style="text-align: center">Tutor</th>
    <th style="text-align: center">Titolo tirocinio</th>
    <th></th>
  </tr>
  		<%for (int i = 0; i < questionariS.size(); i++){
  			qs = questionariS.get(i);
  			
  			for (int z = 0; z < aziende.size(); z++) {
  				azienda = aziende.get(z);
  				if (qs.getAzienda().equals(azienda.getUsername())){
  					break;
  				}
  			}
  			
  			for (int j = 0; j < tutors.size(); j++){
  				tutor = tutors.get(j);
  				if(qs.getTutorAccademico().equals(tutor.getUsername())){
  					break;
  				}
  			}
  			  		
	  %>
  <tr>
    <td><a href="#">Questionario N.<%=qs.getId() %></a></td>
    <td><%= azienda.getNome() %></td>
    <td>Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %></td>
    <td><%= qs.getTitolo() %></td>
    <%if (qs.getUrl().equals("")){ %>
        <td>
    	<form>
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoStudente" accept=".pdf"><br>
  			<input type="submit">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
  <% } %>
</table>
<% 	} else { %>
	 <script type="text/javascript">
  		var r=alert("Non sono presenti questionari da compilare");
 		window.location.href = 'home.jsp';
 	 </script>
<%}
} 

if (tipoUm.equals("azienda")){ 
	 if (questionariA.size()>0){ %>
	<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="margin-left: 10%">Questionario</th>
    <th style="margin-left: 10%">Studente</th>
    <th style="margin-left: 10%">Tutor</th>
    <th style="margin-left: 10%">Titolo tirocinio</th>
    <th></th>
  </tr>
  <%for (int i = 0; i < questionariA.size(); i++){
  			qa = questionariA.get(i);
  			
  			for (int z = 0; z < studenti.size(); z++) {
  				studente = studenti.get(z);
  				if (qa.getStudente().equals(studente.getUsername())){
  					break;
  				}
  			}
  			
  			for (int j = 0; j < tutors.size(); j++){
  				tutor = tutors.get(j);
  				if(qa.getTutorAccademico().equals(tutor.getUsername())){
  					break;
  				}
  			}
  			  		
	  %>
  <tr>
    <td><a href="#">Questionario N.<%=qa.getId() %></a></td>
    <td><%= studente.getCognome() + " " + studente.getNome() %></td>
    <td>Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %></td>
    <td><%= qa.getTitoloTirocinio()%></td>
   <%if (qa.getUrl().equals("")){ %>
        <td>
    	<form>
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoAzienda" accept=".pdf"><br>
  			<input type="submit">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
  <% } %>
</table>
<% 	}  else { %>
<script type="text/javascript">
	window.location.href = 'nessunaRisorsa.jsp';
</script>
<%} 
} %>

<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>