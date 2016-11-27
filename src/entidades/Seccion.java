package entidad;

import java.util.ArrayList;
import java.util.List;

public class Seccion extends Documento {
private List<Documento> listaSeccion;
private String id;

private String contenido=null;

	 public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

	public Seccion(String string){
		listaSeccion= new ArrayList<Documento>();
		this.id=string;
	 }
	
	 @Override
	public void add(Documento documento) {
		// TODO Auto-generated method stub
		listaSeccion.add(documento);
	}
	@Override
	public void remove(String idSeccion) {

		for(int x=0;x<listaSeccion.size();x++){
			if(listaSeccion.get(x).getId().equals(idSeccion)){
				listaSeccion.remove(x);
			}
			
			else{
			
				listaSeccion.get(x).getChild(idSeccion);
			}
			
			
		}
			
	}
	
public void getChild(String id){
		
		for(int x=0;x<listaSeccion.size();x++){
		
			if(listaSeccion.get(x).getId().equals(id)){
				System.out.println("entre");
				listaSeccion.remove(x);
			}
			
			listaSeccion.get(x).getChild(id);
		}
		
		
	}
	public List<Documento> getListaSeccion() {
		return listaSeccion;
	}

	public void setListaSeccion(List<Documento> listaSeccion) {
		this.listaSeccion = listaSeccion;
	}

	

	
	
	@Override
	//ModificarContenido
	public void incluir(List<String> texto) {

	
		for (Documento seccion : listaSeccion) {
			
			seccion.incluir(texto);
			
			
		}
		}
	

	

	@Override
	public Documento Clonar() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	
	
	}
		
		
	
	

