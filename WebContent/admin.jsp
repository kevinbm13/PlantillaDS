<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidad.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Administrador CEDA</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
	<link rel="stylesheet" type="text/css" href="mystyle.css">
	<script src="dist/sweetalert.min.js"></script>
	<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">

	<script>
        $(document).ready(function() {                        
            $('#agregarSeccion').click(function(event) {
            	var id=$('#idSeccion').val();
            	var nombre=$('#nombreSeccion').val();
            	var vigencia=$('#vigenciaSeccion').val();
             	$.post('agregarSeccionServlet',{id:id, nombreSeccion:nombre, vigencia:vigencia},function(responseText) { 
             		swal({title: "¡Exito!", text: responseText, type: "success"},
             			   function(){ 
             			       location.reload();
             			   }
             		);
                });
            });
        });
	</script>
	<script>
        $(document).ready(function() {                        
            $('#agregarElemento').click(function(event) {  
            	var id=$('#idElemento').val();
            	var nombre=$('#nombreElemento').val();
            	var vigencia=$('#vigenciaElemento').val();
            	var nombreSec=$('#nombreSecElemento').val();
             	$.post('agregarElementoServlet',{id:id, nombre:nombre, vigencia:vigencia, nombreSec:nombreSec},function(responseText) { 
             		swal({title: "¡Exito!", text: responseText, type: "success"},
              			   function(){ 
              			       location.reload();
              			   }
              		);
                });
            });
        });
	</script>
	<script>
        $(document).ready(function() {                        
            $('#eliminarSeccion').click(function(event) {
            	var id=$('#idSeccionEliminar').val();
            	var vigencia=$('#vigenciaSeccionEliminar').val();
             	$.post('eliminarSeccionServlet',{id:id, vigencia:vigencia},function(responseText) { 
             		swal({title: "¡Exito!", text: responseText, type: "success"},
              			   function(){ 
              			       location.reload();
              			   }
              		);
                });
            });
        });
	</script>
	<script>
        $(document).ready(function() {                        
            $('#eliminarElemento').click(function(event) {  
            	var id=$('#idElementoEliminar').val();
            	var vigencia=$('#vigenciaElementoEliminar').val();
             	$.post('eliminarElementoServlet',{id:id, vigencia:vigencia},function(responseText) { 
             		swal({title: "¡Exito!", text: responseText, type: "success"},
              			   function(){ 
              			       location.reload();
              			   }
              		);
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
	<li> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" style="width:100%;" > </li>
	<li><a href="admin.jsp" style="border-top: 5px solid black;"><span>Modificar Plantilla</span></a></li>
	<li><a href="login.jsp"><span>Cerrar sesión</span></a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:1000px;">
	<button class="accordion">Agregar Sección</button>
	<div class="panel">
		<label for="idSeccion">ID de la sección</label>
		<input type="text" id="idSeccion">
		
		<label for="nombreSeccion">Nombre de la sección</label>
		<input type="text" id="nombreSeccion">
	
		<label for="vigenciaSeccion">Vigencia</label>
		<input type="text" id="vigenciaSeccion">
		<input id="agregarSeccion" type="submit" value = "Agregar Sección">	
	</div>

	<button class="accordion">Agregar Elemento</button>
	<div class="panel">
		<label for="idElemento">ID del elemento</label>
		<input type="text" id="idElemento">
		
		<label for="nombreElemento">Nombre del elemento</label>
		<input type="text" id="nombreElemento">
		
		<label for="nombreSecElemento">Seccion a la que pertenece</label>
		<select id="nombreSecElemento">
		<% Controlador controlador = new Controlador();controlador.crearEstructura("plantilla.xml");%>
		<% for(int count=0; count<controlador.obtenerSecciones().size(); count++){ %>
    	<option value="<%= controlador.obtenerSecciones().get(count).getId() %>">
    	<%= controlador.obtenerSecciones().get(count).getId() +". "+ controlador.obtenerSecciones().get(count).getNombre() %></option>  
		<%} %>
		</select>
		<label for="vigenciaElemento">Vigencia</label>
		<input type="text" id="vigenciaElemento">
		<input id="agregarElemento" type="submit" value = "Agregar Elemento">	
	</div>
	
	<button class="accordion">Eliminar Sección</button>
	<div class="panel">
		<label for="idSeccionEliminar">ID de la sección</label>
		<select id="idSeccionEliminar">
		<% for(int count=0; count<controlador.obtenerSecciones().size(); count++){ %>
    	<option value="<%= controlador.obtenerSecciones().get(count).getId() %>">
    	<%= controlador.obtenerSecciones().get(count).getId() +". "+ controlador.obtenerSecciones().get(count).getNombre() %></option>  
		<%} %>
		</select>
	
		<label for="vigenciaSeccionEliminar">Vigencia</label>
		<input type="text" id="vigenciaSeccionEliminar">
		<input id="eliminarSeccion" type="submit" value = "Eliminar Sección">	
	</div>
	
	<button class="accordion">Eliminar Elemento</button>
	<div class="panel">
		<label for="idElementoEliminar">ID del elemento</label>
		<select id="idElementoEliminar">
		<% for(int count=0; count<controlador.obtenerElementos().size(); count++){ %>
    	<option value="<%= controlador.obtenerElementos().get(count).getId() %>">
    	<%= controlador.obtenerElementos().get(count).getId() +". "+ controlador.obtenerElementos().get(count).getNombre() %></option>  
		<%} %>
		</select>
		<label for="vigenciaElementoEliminar">Vigencia</label>
		<input type="text" id="vigenciaElementoEliminar">
		<input id="eliminarElemento" type="submit" value = "Eliminar Elemento">	
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