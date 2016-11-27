package entidad;

import java.util.List;

public abstract class Documento {
	
	public  abstract void add(Documento d);
     public abstract void remove(String documento);  
     public abstract void incluir();
     public abstract String getId();
     public abstract void setId(String id);
     public abstract List<Documento> getListaSeccion();
     public abstract void setListaSeccion(List<Documento>lista);
	public abstract void getChild(String idSeccion);
	

	
}
