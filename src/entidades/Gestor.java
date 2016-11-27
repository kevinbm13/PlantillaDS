package entidad;

import java.util.List;

public class Gestor implements Usuario {

	
	public Gestor(){
		
	}
	
	@Override
	public void modificarPlantilla(Documento documento ,List<String> texto) {
		documento.incluir(texto);
		

}
	



}


