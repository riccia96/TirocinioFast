<%@ page import="Bean.*" %>
<%@ page import="Model.*" %>
<%@ page import="Control.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%
AziendaBean currentAzienda = (AziendaBean)session.getAttribute("currentSessionAzienda");
StudenteBean currentStudente = (StudenteBean)session.getAttribute("currentSessionStudente");
TutorBean currentTutor = (TutorBean)session.getAttribute("currentSessionTutor");
ImpiegatoBean currentImpiegato = (ImpiegatoBean)session.getAttribute("currentSessionImpiegato");

if (currentStudente != null || currentAzienda != null || currentTutor != null || currentImpiegato != null){
	session.invalidate();
	response.sendRedirect("index.jsp");
}
%>