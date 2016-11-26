<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Administrador CEDA</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" type="text/css" href="mystyle.css">

	<script>
        $(document).ready(function() {                        
            $('#agregarSeccion').click(function(event) {  
            	var nombre=$('#nombreSeccion').val();
             	$.post('agregarSeccionServlet',{nombreSeccion:nombre},function(responseText) { 
					alert(responseText);
                });
            });
        });
	</script>
	<script>
        $(document).ready(function() {                        
            $('#agregarElemento').click(function(event) {  
             	$.post('pruebaServlet',{},function(responseText) { 
					alert(responseText);
                });
            });
        });
	</script>
</head>
<body>
<div class="w3-container" align = "center" style="background: #02003a;color:white;">
	<h1>Administrador CEDA</h1>
</div>

<ul>
	<div align = "center"> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" style="width:330px;250px;" > </div>
	<li><a href="admin.jsp" style="border-top: 5px solid black;"><span>Modificar Plantilla</span></a></li>
	<li><a href="login.jsp"><span>Cerrar sesión</span></a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:1000px;">
	<button class="accordion">Agregar Sección</button>
	<div class="panel">
		<form id="form1">
		<label for="nombreSeccion">Nombre de la sección</label>
		<input type="text" name="nombreSeccion">
	
		<label for="vigenciaSeccion">Vigencia</label>
		<input type="text" name="vigenciaSeccion">
		<input id="agregarSeccion" type="submit" value = "Agregar Sección">	
		</form>
	</div>

	<button class="accordion">Agregar Elemento</button>
	<div class="panel">
		<form id="form2">
		<label for="nombreElemento">Nombre del elemento</label>
		<input type="text" name="nombreElemento">
	
		<label for="vigenciaElemento">Vigencia</label>
		<input type="text" name="vigenciaElemento">
		<input name="agregarElemento" type="submit" value = "Agregar Elemento">	
		</form>
	</div>
	
	<button class="accordion">Eliminar Sección</button>
	<div class="panel">
		<form id="form3">
		<label for="nombreSeccionEliminar">Nombre de la sección</label>
		<input type="text" name="nombreSeccionEliminar">
	
		<label for="vigenciaSeccionEliminar">Vigencia</label>
		<input type="text" name="vigenciaSeccionEliminar">
		<input id="eliminarSeccion" type="submit" value = "Eliminar Sección">	
		</form>
	</div>
	
	<button class="accordion">Eliminar Elemento</button>
	<div class="panel">
		<form id="form4">
		<label for="nombreElementoEliminar">Nombre del elemento</label>
		<input type="text" name="nombreElementoEliminar">
	
		<label for="vigenciaElementoEliminar">Vigencia</label>
		<input type="text" name="vigenciaElementoEliminar">
		<input name="eliminarElemento" type="submit" value = "Eliminar Elemento">	
		</form>
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