package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Controlador;



public class eliminarElementoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public eliminarElementoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String vigencia = request.getParameter("vigencia");
		
		Controlador controlador = new Controlador();
		controlador.crearEstructura();
		//controlador.eliminarElemento(id);
		String result = "Elemento " + id + " eliminado correctamente." + ". Vigencia: " + vigencia;
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result);
	}

}
