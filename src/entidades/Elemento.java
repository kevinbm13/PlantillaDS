package entidad;

import java.util.List;


public class Elemento extends Documento {
	private String id;
	
	public Elemento(String id){
	
		this.id=id;
	}


	@Override
	public void remove(String idElemento) {
		
	}

public void obtenerElemento(String idElemento){
	
}

	@Override
	public void incluir() {
		//Guardar en base
		System.out.println(id);
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

	
	
	
	
}
