<%@page import="Bean.AziendaBean"%>
<%@page import="Bean.StudenteBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@include file="navbar.jsp"%>

	<%@include file="menu.jsp"%>

	<div style="margin-left: 25%; height: 1200px; width: 700px;">


		<form class="dialogo" name="form" id="registrazione"
			action="GestioneUtente" method="POST"
			style="position: absolute; width: 700px;">

			<input type="radio" name="tipo" value="studente" id="radioS"
				onclick="myAccFunc()">Studente <input type="radio"
				name="tipo" value="azienda" id="radioA" onclick="myAccFunc()">Azienda

			<div class="imgcontainer">
				<img src="img\avatar-default-icon.png" alt="Avatar" class="avatar">
			</div>

			<input type="text" placeholder="Nome" name="nome" required
				id="nomeStudente"> <br> <input type="text"
				placeholder="Cognome" name="cognome" required id="cognomeStudente">
			<br> <input type="text" placeholder="Luogo di nascita"
				name="luogo" required id="luogoNascitaStudente"> <br> <input
				type="text" placeholder="Data di nascita" name="data" required
				id="dataNascitaStudente"> <br> <input type="text"
				placeholder="Indirizzo di residenza" name="indirizzo" required
				id="indirizzoStudente"> <br> <input type="text"
				placeholder="Città di residenza" name="citta" required
				id="cittaStudente"> <br> <input type="text"
				placeholder="Codice Fiscale" name="codice" required
				id="codiceFiscaleStudente"> <br> <input type="text"
				placeholder="Matricola" name="matricola" required
				id="matricolaStudente"> <br> <input type="text"
				placeholder="E-mail" name="email" required id="emailStudente">
			<br> <input type="text" placeholder="Numero di telefono"
				name="telefono" required id="telefonoStudente"> <br> <input
				type="text" placeholder="Username" name="username" required
				id="usernameStudente"> <br> <input type="password"
				placeholder="Password" name="password" required
				id="passwordStudente"> <br> <input type="password"
				placeholder="Conferma password" name="conferma" required
				id="confermaStudente"> <br> <input type="text"
				placeholder="Film preferito? (utilizzato per recupero password)"
				name="domanda" required id="domandaStudente"> <br> <input
				type="text" placeholder="Nome azienda" name="nome" required
				id="nomeAzienda"> <br> <input type="text"
				placeholder="Partita Iva" name="iva" required id="partitaIvaAzienda">
			<br> <input type="text" placeholder="Rappresentante azienda"
				name="ceo" required id="rappresentanteAzienda"> <br> <input
				type="text" placeholder="Sede" name="sede" required id="sedeAzienda">
			<br> <input type="text" placeholder="E-mail" name="email"
				required id="emailAzienda"> <br> <input type="text"
				placeholder="Telefono" name="telefono" required id="telefonoAzienda">
			<br> <input type="text" placeholder="Username" name="username"
				required id="usernameAzienda"> <br> <input
				type="password" placeholder="Password" name="password" required
				id="passwordAzienda"> <br> <input type="password"
				placeholder="Conferma password" name="conferma" required
				id="confermaAzienda"> <br> <input type="text"
				placeholder="Film preferito? (utilizzato per recupero password)"
				name="domanda" required id="domandaAzienda"> <br>

			<div class="new">
				<button name="azioneUtente" value="registrati" id="registratiButton"
					class=" button" type="submit">Registrati</button>
			</div>

		</form>

	</div>


	<%@include file="footer.jsp"%>

	<script>
		$(document).ready(function() {
			$("#nomeAzienda").hide();
		});
		
		function myAccFunc() {
			var x = document.getElementById("radioA");
			var y = document.getElementById("radioS");
			if (x.checked) {
				$("#nomeAzienda").show();
				$("#partitaIvaAzienda").show();
				$("#rappresentanteAzienda").show();
				$("#sedeAzienda").show();
				$("#emailAzienda").show();
				$("#telefonoAzienda").show();
				$("#usernameAzienda").show();
				$("#passwordAzienda").show();
				$("#confermaAzienda").show();
				$("#domandaAzienda").show();

				$("#nomeStudente").hide();
				$("#cognomeStudente").hide();
				$("#luogoNascitaStudente").hide();
				$("#dataNascitaStudente").hide();
				$("#indirizzoStudente").hide();
				$("#cittaStudente").hide();
				$("#codiceFiscaleStudente").hide();
				$("#matricolaStudente").hide();
				$("#emailStudente").hide();
				$("#telefonoStudente").hide();
				$("#usernameStudente").hide();
				$("#passwordStudente").hide();
				$("#confermaStudente").hide();
				$("#domandaStudente").hide();

			}
			if (y.checked) {
				$("#nomeStudente").show();
				$("#cognomeStudente").show();
				$("#luogoNascitaStudente").show();
				$("#dataNascitaStudente").show();
				$("#indirizzoStudente").show();
				$("#cittaStudente").show();
				$("#codiceFiscaleStudente").show();
				$("#matricolaStudente").show();
				$("#emailStudente").show();
				$("#telefonoStudente").show();
				$("#usernameStudente").show();
				$("#passwordStudente").show();
				$("#confermaStudente").show();
				$("#domandaStudente").show();
			
				$("#nomeAzienda").hide();
				$("#partitaIvaAzienda").hide();
				$("#rappresentanteAzienda").hide();
				$("#sedeAzienda").hide();
				$("#emailAzienda").hide();
				$("#telefonoAzienda").hide();
				$("#usernameAzienda").hide();
				$("#passwordAzienda").hide();
				$("#confermaAzienda").hide();
				$("#domandaAzienda").hide();
				
			}
		}
	</script>



	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>