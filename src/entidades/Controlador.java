package entidad;

public class Controlador {
	private Documento documento;
	private LectorXml lector;
	
	private Usuario usuario;
	public Controlador(){
		documento=new Seccion("Nodo raíz");
		lector=new LectorXml();
		
		
	}
	
	public void crearSeccion(String idSeccion){
		Documento nuevaSeccion=new Seccion(idSeccion);
		documento.add(nuevaSeccion);	
	}
	
	public void eliminarSeccion(String idSeccion){
		documento.remove(idSeccion);
		documento.incluir();
	}
	
	public void crearElemento(String idSeccion, String idElemento){
		Documento nuevoElemento=new Elemento(idElemento);		
		documento.add(nuevoElemento);
		documento.incluir();
	}
	
	public void crearEstructura(){
		
		lector.leer(documento);
		
	}
}
