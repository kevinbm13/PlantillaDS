<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Gestor Curricular</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<script src="dist/sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">

	
</head>
<body>
<div class="w3-container" align = "center" style="background: #02003a;color:white;">
	<h1>Gestor Curricular</h1>
</div>

<ul>
	<li> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" style="width:100%;" > </li>
	<li><a href="admin.jsp" style="border-top: 5px solid black;"><span>Modificar Datos Generales</span></a></li>
	<li><a href="login.jsp"><span>Cerrar sesi�n</span></a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:1000px;">
	<button class="accordion">Modificar Aspectos Generales</button>
	<div class="panel">
		
		<% Controlador controlador = new Controlador();controlador.crearEstructura("plantilla.xml");%>
		<% for(int count=0; count<controlador.obtenerElementos().size(); count++){ %>
		<label for="<%= controlador.obtenerElementos().get(count).getId() %>">
		<%= controlador.obtenerElementos().get(count).getNombre() %></label>
    	<input type="text" id="<%= controlador.obtenerElementos().get(count).getId() %>
    	" value="<%= controlador.obtenerElementos().get(count).getContenido() %>">   
		<%} %>

		<input id="modificarPlantilla" type="submit" value = "Modificar Plantilla">	
	</div>
</div>


<script>
	var acc = document.getElementsByClassName("accordion");
	var i;
	
	for (i = 0; i < acc.length; i++) {
	    acc[i].onclick = function(){
	        this.classList.toggle("active");
	        this.nextElementSibling.classList.toggle("show");
	    }
	}
</script>

</body>
</html>