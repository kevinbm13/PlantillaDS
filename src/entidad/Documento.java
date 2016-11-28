package entidad;

import java.util.List;

public abstract class Documento implements Clon{
	
	public  abstract void add(Documento d);
     public abstract void remove(String documento); 
     //--------------------------------------------------------
     public abstract void getChild(String idSeccion);
     public abstract void incluir(List<String>lista);
     //-------------------------------------------------------
     public abstract String getId();
     public abstract void setId(String id);
     //----------------------------------------------------------------------
     public abstract List<Documento> getListaSeccion();
     public abstract void setListaSeccion(List<Documento>lista);
     //----------------------------------------------------------------------
     public abstract String getContenido();
     public abstract void setContenido(String id);
     //----------------------------------------------------------------------
     public abstract String getNombre();
     public abstract void setNombre(String nombre);
     //--------------------------------------------------------------
     
     public Documento clonar() throws CloneNotSupportedException{
    	 
		return (Documento) super.clone();
    	 
     }
     //---------------------------------------------------------------
	
	

	
}
