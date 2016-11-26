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

import entidades.Documento;
import entidades.Seccion;



public class agregarSeccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public agregarSeccionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Documento d=new Seccion("Plantilla");
		
		String nombreSeccion = request.getParameter("nombreSeccion");
		d.add(new Seccion(nombreSeccion));
		d.incluir();
		System.out.println("hola");
		String result = "hola";
		
		
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		response.getWriter().write(result); 
	}

}
