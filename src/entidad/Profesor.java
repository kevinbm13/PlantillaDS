package entidad;

import java.util.List;

public class Profesor implements Usuario {

	public Profesor(){
		
	}
	


	@Override
	public void modificarPlantilla(Documento d, List<String> texto) {
		// TODO Auto-generated method stub
		d.incluir(texto);
		
	}
	
	
}
