package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import entidad.Controlador;
 


public class profesorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public profesorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		@SuppressWarnings("rawtypes")
		Enumeration parametros = request.getParameterNames();
		List<String> elementos = new ArrayList<String>();
		while(parametros.hasMoreElements()){
			Object obj = parametros.nextElement();
			String fieldName = (String) obj;
			String fieldValue = request.getParameter(fieldName);
			elementos.add(fieldValue);
		}        
		
		System.out.println(elementos.toString());
		Controlador controlador = new Controlador();
		controlador.crearEstructura("plantilla.xml");
		try {
			controlador.modificarAspectosOperativos(elementos);
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain");  
		response.setCharacterEncoding("UTF-8"); 
		String redirect = response.encodeRedirectURL(request.getContextPath() + "/profe.jsp");
		response.sendRedirect(redirect);
	}

}
