<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Iniciar sesión</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
		<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" type="text/css" href="mystyle.css">
		<script src="dist/sweetalert.min.js"></script>
		<link rel="stylesheet" type="text/css" href="dist/sweetalert.css">
		<script>
        $(document).ready(function() {                        
            $('#loguear').click(function(event) {  
            	var username=$('#nombreUsuario').val();
            	var pass=$('#pass').val();
            	var tipo=$('#tipo').val();
             	$.post('loginServlet',{username:username, pass:pass, tipo:tipo},function(responseText) {
             		
             		if(responseText == "Datos invalidos."){
             			swal({title: "ERROR", text: responseText, type: "error"},
                 				function(){
             						location.reload();
                 				}
                  		);
             		}else if(tipo == "CEDA"){
             			swal({title: "¡Bienvenido!", text: responseText, type: "success"},
                 				function(){
             						window.location.href = "http://localhost:8080/PlantillaDS/admin.jsp";
                 				}
                  		);
 					}else if(tipo == "Gestor"){
 						swal({title: "¡Bienvenido!", text: responseText, type: "success"},
                 				function(){
 									location.href("http://localhost:8080/PlantillaDS/gestor.jsp");
                 				}
                  		);
 					}else if(tipo == "Profesor"){
 						swal({title: "¡Bienvenido!", text: responseText, type: "success"},
                 				function(){
 									location.href("http://localhost:8080/PlantillaDS/profe.jsp");
                 				}
                  		);
 					}else{
 						location.reload();
 					}
                });
            });
        });
		</script>
	</head>
	<body style="height:100%;min-height:100%;">
		<div class="w3-container" align = "center" style="background:#02003a;color:white;height:10%;">
			<h1>Iniciar Sesión</h1>
		</div>

		<div class="container" style="margin-bottom:7.7%">
			<div align = "center"> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" alt="Mountain View" style="width:30%;"> </div>
			<div class="container" style="margin-left:33%;margin-right:33%;margin-top:5%">
				<label for="nombreUsuario">Username</label>
				<input type="text" placeholder="Nombre de usuario" id="nombreUsuario"/>
				
				<label for="pass">Password</label>
				<input type="password" placeholder="Contraseña" id="pass"/>
				
				<label for="tipo">Tipo de Usuario</label>
				<select id="tipo">
					<option>CEDA</option>
					<option>Gestor</option>
					<option>Profesor</option>
				</select>
				
				<input id="loguear" type="submit" value="Iniciar Sesión"	/>
			</div>
		</div>
		<footer class="w3-container" style="background: #02003a;color:white;clear: both;position: relative;z-index: 10;height: 6%;">
			<p>Acceso a Páginas de Administrador CEDA, Gestor Curricular y Profesor</p>
		</footer>
	</body>
	
</html>