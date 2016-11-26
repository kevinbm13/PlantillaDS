<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height:90%;">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Iniciar sesión</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" type="text/css" href="mystyle.css">
</head>
<body>
<body style="height:90%;">
<div class="w3-container" align = "center" style="background: #02003a;color:white;">
	<h1>Iniciar Sesión</h1>
</div>

<div align = "center"> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" alt="Mountain View" style="margin-bottom:15px;width:22%;height:16%;"> </div>

<div class="container" style="min-height:90%;height:90%;margin-left:33%;margin-right:33%;">
	<form align= "center">
	<label for="username" align="center">Username</label>
	<input type="text" placeholder="Nombre de usuario" required="" id="username" name="username" align = "center" />
	<label for="password" align="center">Password</label>
	<input type="password" placeholder="Contraseña" required="" id="password" name="password" align = "center"/>
	<input type="submit" value="Iniciar Sesión" style="margin-left: 0%;margin-bottom: 12%;"/>
	</form>
</div>


</body>
<footer class="w3-container" align = "center" style="background: #02003a;color:white;clear: both;position: relative;z-index: 10;height: 3em;">
	<p>Acceso a Página de Administración de Base de datos</p>
</footer>

</html>