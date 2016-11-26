package entidades;

import java.util.ArrayList;

import java.util.List;

public class Seccion extends Documento {
private List<Documento> listaSeccion;
private String nombre;
	 public Seccion(String nombre){
		listaSeccion= new ArrayList<Documento>();
		this.nombre=nombre;
	 }
	
	 @Override
	public void add(Documento documento) {
		// TODO Auto-generated method stub
		
		listaSeccion.add(documento);
	}
	@Override
	public void remove(Documento documento) {
		// TODO Auto-generated method stub
		listaSeccion.remove(documento);
	}
	@Override
	//Obtener hijos(Elemento en lista)
	public void getChild(int i) {
		
		
	}
	@Override
	//ModificarContenido
	public void incluir() {
		System.out.println(nombre);
		//Guardar en base
		for (Documento seccion : listaSeccion) {
			//Guardar en base
			seccion.incluir();
			
		}
		}
			
		}
		
	
	

