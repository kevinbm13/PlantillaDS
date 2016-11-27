package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Controlador;
import entidades.Documento;
import entidades.Seccion;



public class agregarElementoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public agregarElementoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String vigencia = request.getParameter("vigencia");
		String nombreSeccion = request.getParameter("nombreSec");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura();
		controlador.crearElemento(nombreSeccion, nombre);
		String result = "Elemento " + nombre + " agregado correctamente. Vigencia: " + vigencia;
		
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);
	}

}
