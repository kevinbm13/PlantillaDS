package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Controlador;



public class eliminarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public eliminarSeccionServlet() {
        super();
    } 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vigencia = request.getParameter("vigencia");
		String id = request.getParameter("id");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura();
		//controlador.eliminar(idSeccion);
		String result = "Seccion " + id + " eliminada correctamente.\nVigencia: " + vigencia;
	
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);

	    
	}

}
