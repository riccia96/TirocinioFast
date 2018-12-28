<%@page import="Bean.ImpiegatoBean"%>
<%@page import="Bean.TutorBean"%>
<%@page import="Model.TutorDAO"%>
<%@page import="Bean.AziendaBean"%>
<%@page import="Bean.StudenteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@include file="navbar.jsp"%>

	<div>
		<div>
			<form id="login" action="GestioneUtente" method="POST">
				<div class="imgcontainer">
					<img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
				</div>

				<div class="container">
					<label for="username"><b>Username</b></label> <input type="text"
						placeholder="Enter Username" name="username" required> <br>
					<label for="password"><b>Password</b></label> <input
						type="password" placeholder="Enter Password" name="password"
						required> <br>
					<div class="new">
						<button name="azioneUtente" value="login" id="loginButton"
							class=" button" type="submit">Login</button>
						<br> <span class="psw"><a href="#"> Password
								dimenticata?</a></span> <span class="psw"><a href="#">Registrati
								/ </a></span>
					</div>
				</div>

			</form>
		</div>
	</div>

	<%@include file="footer.jsp"%>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>