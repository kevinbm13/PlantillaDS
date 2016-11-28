package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Controlador;



public class agregarElementoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public agregarElementoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String vigencia = request.getParameter("vigencia");
		String nombreSeccion = request.getParameter("nombreSec");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura();
		controlador.crearElemento(id, nombre);
		String result = "Elemento " + nombre + " con el ID " + id + " agregado correctamente a la seccion "+ nombreSeccion + ". Vigencia: " + vigencia;
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);
	}

}
