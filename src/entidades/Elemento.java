package entidades;

public class Elemento extends Documento {
	private String nombre;
	
	public Elemento(String nombre){
	
		this.nombre=nombre;
	}
	@Override
	public void add(Documento documento) {
		// TODO Auto-generated method stub
		//No se implementa
	}

	@Override
	public void remove(Documento employee) {
		// TODO Auto-generated method stub
		//No se implementa
	}

	@Override
	public void getChild(int i) {
		// TODO Auto-generated method stub
		//No se implementa
	}

	@Override
	public void incluir() {
		//Guardar en base
		System.out.println(nombre);
	}
	
	
	
	
}
