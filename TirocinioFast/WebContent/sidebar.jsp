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

<div id="wrapper">

<div id="sidebar-wrapper">
<ul class="sidebar-nav">
<li><a href="#">Account</a></li>
<li><a href="#">Account</a></li>
<li><a href="#">Account</a></li>
</ul>
</div>

<div id="page-content-wrapper">
<div class="container-fluid">
<div class="row">
<div class="col-lg-12">
<a href="#" class=" btn btn-success" id="menu-toggle">Menu</a>
<p> Cione </p>
<p>we</p>
</div>
</div>
</div>
</div>

</div>

<script>
$("#menu-toggle").click(function (e) {
	e.preventDefault();
	$("#wrapper").toggleClass("menuDisplayed");
});
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>