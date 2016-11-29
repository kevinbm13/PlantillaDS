<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html style="height:100%;">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Iniciar sesión</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
		<link rel="stylesheet" type="text/css" href="http://www.w3schools.com/lib/w3.css">
		<link rel="stylesheet" type="text/css" href="mystyle.css">
		<script>
        $(document).ready(function() {                        
            $('#login').click(function(event) {  
            	var username=$('#username').val();
            	var pass=$('#password').val();
            	var tipo=$('#tipo').val();
             	$.post('loginServlet',{username:username, pass:pass, tipo:tipo},function(responseText) { 
             		if(response.equals("CEDA")){
             			swal({title: "¡Exito!", text: responseText, type: "success"},
                 				function(){
             						window.location.replace("admin.jsp");
                 				}
                  		);
 					}
 					else if(response.equals("Gestor")){
 						swal({title: "¡Exito!", text: responseText, type: "success"},
                 				function(){
             						window.location.replace("gestor.jsp");
                 				}
                  		);
 					}
 					else if(response.equals("Profesor")){
 						swal({title: "¡Exito!", text: responseText, type: "success"},
                 				function(){
             						window.location.replace("profe.jsp");
                 				}
                  		);
 					}else{
 						swal({title: "ERROR", text: responseText, type: "error"},
                 				function(){
 									location.reload();
                 				}
                  		);
 						
 					}
             		
                });
            });
        });
		</script>
	</head>
	<body style="height:100%;">
		<div class="w3-container" align = "center" style="background:#02003a;color:white;height:10%;">
			<h1>Iniciar Sesión</h1>
		</div>

		<div class="container" style="min-height:84%;height:84%;">
			<div align = "center"> <img src="http://repositoriotec.tec.ac.cr/themes/Mirage2//images/MarcaTECRGB.png" alt="Mountain View" style="width:30%;"> </div>
			<div class="container" style="margin-left:33%;margin-right:33%;margin-top:5%">
				<label for="username">Username</label>
				<input type="text" placeholder="Nombre de usuario" id="username"/>
				
				<label for="password">Password</label>
				<input type="password" placeholder="Contraseña" id="password"/>
				
				<label for="tipo">Tipo de Usuario</label>
				<select id="tipo">
					<option>CEDA</option>
					<option>Gestor</option>
					<option>Profesor</option>
				</select>
				
				<input id="login" type="submit" value="Iniciar Sesión"	/>
			</div>
		</div>
		<footer class="w3-container" style="background: #02003a;color:white;clear: both;position: relative;z-index: 10;height: 6%;">
			<p>Acceso a Página de Administración de Base de datos</p>
		</footer>
	</body>
	
</html>