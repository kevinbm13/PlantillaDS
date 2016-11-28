package entidad;

import java.util.List;


public class Elemento extends Documento {
	private String id;
	private String contenido;
	private String nombre;
	public Elemento(String id,String nombre){
	
		this.id=id;
		this.nombre=nombre;
	}


	@Override
	public void remove(String idElemento) {
		
	}

public void obtenerElemento(String idElemento){
	
}

	@Override
	public void incluir(List<String>texto) {
		//Guardar en base
			
			System.out.println(texto.get(0));
			contenido=texto.get(0);
			texto.remove(0);
			
		}
		
	

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List getListaSeccion() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setListaSeccion(List<Documento>lista) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void getChild(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(Documento d) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Documento Clonar() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getContenido() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setContenido(String contenido) {
		 this.contenido=contenido;
	}


	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}


	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}