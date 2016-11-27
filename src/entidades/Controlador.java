package entidad;

import java.util.List;



public class Controlador {
	private Documento documento;
	private LectorXml lector;
	private Usuario usuario;
	
	public Controlador(){
		documento=new Seccion("0");
		lector=new LectorXml();
		
		
	}
	
	public void crearSeccion(String idSeccion){
		Documento d=new Seccion(idSeccion);
		documento.add(d);	
	}
	
	public void crearElemento(String idElemento){
		Documento d=new Elemento(idElemento);
		documento.add(d);
		
	
	}
	
	public void eliminar(String idSeccion){
		documento.remove(idSeccion);
		documento.incluir();
		
	}
	

	
	public void crearEstructura(){
		
		lector.leer(documento);
		
	}
}
