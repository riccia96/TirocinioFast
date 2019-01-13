<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*" %>
<% String tipoUtente = (String) request.getSession().getAttribute("tipoUtente");
	
	AziendaBean azienda = new AziendaBean();
	TutorBean tutor = new TutorBean();
	QuestionarioStudenteBean questionarioS = new QuestionarioStudenteBean();
	ArrayList<StudenteBean> studenti = new ArrayList<StudenteBean>();
	ArrayList<TutorBean> tutors = new ArrayList<TutorBean>();
	ArrayList<QuestionarioAziendaBean> questionariA = new ArrayList<QuestionarioAziendaBean>();
	StudenteBean studente = new StudenteBean();
	QuestionarioAziendaBean qa = new QuestionarioAziendaBean();
	
	if(tipoUtente.equals("studente")){
		questionarioS = (QuestionarioStudenteBean) request.getSession().getAttribute("questionarioStudente");
		azienda = (AziendaBean) request.getSession().getAttribute("questSAzienda");
		tutor = (TutorBean) request.getSession().getAttribute("questSTutor");

	} else if(tipoUtente.equals("azienda")){
		questionariA = (ArrayList<QuestionarioAziendaBean>) request.getSession().getAttribute("tiroQuestAzienda");
		studenti = (ArrayList<StudenteBean>) request.getSession().getAttribute("studenti");
		tutors = (ArrayList<TutorBean>) request.getSession().getAttribute("tutors");
	}
	
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

<h3 class="intestazione">Gestione dei questionari valutativi</h3>

<% if (tipoUm.equals("studente")){ %>

<table style="margin-left: 25%; width: 1000px;">
  <tr>
    <th style="text-align: center">Questionario</th>
    <th style="text-align: center">Azienda</th>
    <th style="text-align: center">Tutor</th>
    <th style="text-align: center">Titolo tirocinio</th>
    <th></th>
  </tr>
  		
  <tr>
    <td><a href="GestioneDocumento?azioneDocumento=mostraQuestionario&idQ=<%=questionarioS.getId()%>">Questionario N.<%=questionarioS.getId() %></a></td>
    <td><%= azienda.getNome() %></td>
    <td>Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %></td>
    <td><%= questionarioS.getTitolo() %></td>
    <%if (questionarioS.getUrl().equals("")){ %>
        <td>
    	<form action="GestioneDocumento" metho="POST">
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoStudente" accept=".pdf"><br>
  			<input type="hidden" name="id" value="<%= questionarioS.getId() %>">
  			<input type="submit" name="azioneDocumento" value= "uploadQuestionarioStudente">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
</table>


<%} if (tipoUm.equals("azienda")){ %>
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
  <%if(!qa.getUrl().equals("")) {%>
    <td><a href="GestioneDocumento?azioneDocumento=mostraQuestionario&idQ=<%=qa.getId() %>">Questionario N.<%=qa.getId() %></a></td>
  <%} else {%>
   <td><a href="GestioneDocumento?azioneDocumento=questAziendaCompilazione&idQ=<%=qa.getId()%>">Questionario N.<%=qa.getId() %></a></td>
  <%} %>
    <td><%= studente.getCognome() + " " + studente.getNome() %></td>
    <td>Prof/Prof.ssa <%= tutor.getCognome() + " " + tutor.getNome() %></td>
    <td>Titolo Tirocinio</td>
   <%if (qa.getUrl().equals("")){ %>
        <td>
    	<form action="GestioneDocumento" method="POST">
  			Seleziona PDF del questionario relativo a questo tirocinio firmato<br>
  			<input type="file" name="questionarioFirmatoAzienda" accept=".pdf"><br>
  			<input type="hidden" name="id" value="<%=qa.getId() %>">
  			<input type="submit" name="azioneDocumento" value="uploadQuestionarioAzienda">
		</form>
		</td>
	<% } else { %>
	<td>Questionario gi&agrave; compilato!</td>
	<%} %>
  </tr>
  <% } %>
</table>
<% 	}  %>



<%@include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>