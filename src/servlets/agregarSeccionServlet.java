package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Controlador;



public class agregarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public agregarSeccionServlet() {
        super();
    } 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreSeccion = request.getParameter("nombreSeccion");
		String vigencia = request.getParameter("vigencia");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura();
		controlador.crearSeccion(nombreSeccion);
		String result = "Seccion " + nombreSeccion + " agregada correctamente. Vigencia: " + vigencia;
		
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);

	    
	}

}
