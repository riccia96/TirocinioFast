<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>Ricerca</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<form name="ricerca" method="post" action="GestioneTirocinio" style="border: 1px solid orange; margin-left: 25%;">
<label>Cerca azienda per nome e/o sede <br>
<input type="search" autocomplete="on" placeholder="Nome" name="nomeAzienda">
<input type="search" autocomplete="on" placeholder="Sede Azienda" name="sedeAzienda">
<input type="image" id="ricercaAziendaButton" name="submit" src="img\icona-ricerca-dati.png" height="40px" width="40px">
<input type="hidden" name="azioneTirocinio" value="ricercaAzienda">
</label>
</form>

<script>
$(document).ready(function(){
	$("#ricercaAziendaButton").click(function(){
		
		$.post("/TirocinioFast/GestioneTirocinio",
				{
					"azioneTirocinio" : "ricercaAzienda",
				},
				function(responseTxt, statusTxt, xhr){
					if(responseTxt=="formato nome sbagliato")
						alert("Il formato inserito nel campo di ricerca 'Nome azienda' non è corretto!");
					if(responseTxt=="formato geolocalizzazione sbagliato")
						alert("Il formato inserito nel campo 'Sede azienda' non è corretto!");
			});
	});
});
</script>

<script src="js/bootstrap.min.js"></script>
</body>
</html>